package Ejercicio4;

//Importaciones
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Un árbol es un gráfico no dirigido en el que dos vértices cualesquiera están 
conectados  exactamente por  un camino. En otras palabras, cualquier gráfico 
conexo sin ciclos simples es un árbol.

Dado un árbol de nnodos etiquetados de 0a n - 1, y una matriz de  n - 1 
edgesdonde indica que hay un borde no dirigido entre los dos nodos  y  en el 
árbol, puede elegir cualquier nodo del árbol como raíz. Cuando selecciona un 
nodo como raíz, el árbol de resultados tiene altura . Entre todos los árboles 
enraizados posibles, aquellos con altura mínima (ie ) se denominan árboles de 
altura mínima (MHT).edges[i] = [ai, bi]aibixhmin(h)

Devuelve una lista de las etiquetas raíz de todos los MHT . Puede devolver 
la respuesta en cualquier orden .

La altura de un árbol con raíces es el número de aristas en el camino 
descendente más largo entre la raíz y una hoja.

Restricciones:

* 1 <= n <= 2 * 104
* edges.length == n - 1
* 0 <= ai, bi < n
* ai != bi
* Todos los pares son distintos.(ai, bi)
* Se garantiza que la entrada dada sea un árbol y no habrá bordes repetidos .
*/

public class Solution {
    boolean[] visited = null;
	TreeNode[] allNodes = null;
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	    visited = new boolean[n];
	    allNodes = new TreeNode[n];
	    int minH = Integer.MAX_VALUE;
		List<Integer> result = new ArrayList<Integer>();
		buildTree(edges);
		for (TreeNode node:allNodes){
			Arrays.fill(visited, false);
			int h = findHeight(node.val);
			if (h<minH){
				minH = h;
				result.clear();
			}
			if (h == minH) result.add(node.val);
		}
        return result;
    }
    private void buildTree(int[][] edges){
	    for (int i=0;i<allNodes.length;i++) allNodes[i] = new TreeNode(i);
		for (int i=0;i<edges.length;i++){
			allNodes[edges[i][0]].children.add(allNodes[edges[i][1]].val);
			allNodes[edges[i][1]].children.add(allNodes[edges[i][0]].val);
		}
	}
	private int findHeight(int nodeVal){
		visited[nodeVal]=true;
		int maxH = -1;
		for (int t: allNodes[nodeVal].children){
			if (visited[t]) continue;
    		if (!allNodes[nodeVal].visitedHeights.containsKey(t)){
				int tHeight = findHeight(t);
				allNodes[nodeVal].visitedHeights.put(t, tHeight);
			}
			int h = allNodes[nodeVal].visitedHeights.get(t);
			if (h>maxH)	maxH = h;
		}
		return maxH+1;
	}
	private class TreeNode {
		List<Integer> children = new ArrayList<Integer>();
		Map<Integer, Integer> visitedHeights = new HashMap<Integer, Integer>();
		int val;
		public TreeNode(int v){
		    this.val = v;
		}
	}
}

/*
EXPLICACION DE ANALISIS DEL ALGORIMOS

Este código define una clase Solución que contiene una implementación de un 
algoritmo para encontrar los árboles de altura mínima (MHTs) en un grafo no 
dirigido y conectado.

La clase Solution tiene un método llamado findMinHeightTrees que toma como 
entrada el número de nodos del grafo, n, y una lista de aristas, representadas
como una matriz de pares de índices de nodos. El método devuelve una lista de 
los índices de los MHT en el grafo.

Para encontrar los MHT, el método findMinHeightTrees inicializa primero una 
matriz de valores booleanos para saber qué nodos han sido visitados, y una 
matriz de objetos TreeNode para representar los nodos del grafo. A continuación,
utiliza el método buildTree para construir una representación en árbol del grafo
añadiendo los hijos de cada nodo a su objeto TreeNode.

A continuación, el método findMinHeightTrees itera sobre la matriz de objetos 
TreeNode y, para cada nodo, utiliza el método findHeight para encontrar la 
altura del subárbol enraizado en ese nodo. Realiza un seguimiento de la altura
mínima de todos los nodos, y si la altura de un nodo es igual a la altura mínima,
añade el índice del nodo a la lista de MHTs.

El método buildTree itera sobre la lista de aristas y, para cada arista, añade
los índices de los dos extremos a la lista de hijos del objeto TreeNode de cada
extremo.

El método findHeight toma el índice de un nodo como entrada y devuelve la altura 
del subárbol enraizado en ese nodo. Utiliza un objeto Map para almacenar las 
alturas de los hijos de cada nodo, de forma que no tenga que recalcular la 
altura de un hijo cada vez que se visita. El método marca el nodo de entrada 
como visitado y luego itera sobre los hijos del nodo. Para cada hijo, comprueba
si ya se ha calculado la altura del subárbol enraizado en ese hijo. Si no es así,
utiliza la recursión para encontrar la altura del subárbol y almacena el 
resultado en el objeto Map. A continuación, actualiza la altura máxima de los 
hijos y devuelve la altura máxima más uno (para tener en cuenta la altura del 
nodo actual).

ANALISIS DE COMPLEJIDAD DEL CODIGO


La complejidad temporal de este algoritmo es O(n^2), porque el método findHeight
se invoca una vez para cada nodo, y para cada llamada a findHeight, el método
itera sobre los hijos del nodo actual, que podrían ser todos los demás nodos 
en el peor de los casos. La complejidad espacial es O(n), porque el array
visited, el array allNodes y el objeto Map utilizado por el método findHeight
tienen cada uno un tamaño n.

*/



/*
SOLUCION SACADA DEL LEET CODE

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // casos de aristas o borde
        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }

        // Construye el gráfico con la lista de adyacencia
        ArrayList<Set<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++)
            neighbors.add(new HashSet<Integer>());

        for (int[] edge : edges) {
            Integer start = edge[0], end = edge[1];
            neighbors.get(start).add(end);
            neighbors.get(end).add(start);
        }

        // Inicializar la primera capa de hojas
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (neighbors.get(i).size() == 1)
                leaves.add(i);

        // Recorta las hojas hasta llegar a los centroides
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();

            // eliminar las hojas actuales junto con las aristas
            for (Integer leaf : leaves) {
                // el único vecino que queda para el nodo hoja
                Integer neighbor = neighbors.get(leaf).iterator().next();
                // eliminar la arista junto con el nodo hoja
                neighbors.get(neighbor).remove(leaf);
                if (neighbors.get(neighbor).size() == 1)
                    newLeaves.add(neighbor);
            }

            // prepararse para la siguiente ronda
            leaves = newLeaves;
        }

        // Los nodos restantes son los centroides del grafo
        return leaves;
    }
}


/*
 *
 __________________________ ANALISIS DE ALGORITMOS______________________________

 El primer paso que describimos arriba es en realidad el problema de la
profundidad máxima del árbol N-ario , que consiste en encontrar la distancia 
máxima desde la raíz hasta los nodos hoja. Para ello,podemos aplicar los 
algoritmos de búsqueda primero en profundidad ( DFS ) o búsqueda primero en 
amplitud ( BFS ).

Sin una prueba rígida, podemos ver que la solución directa anterior es correcta
y funcionaría para la mayoría de los casos de prueba.

Sin embargo, esta solución no es eficiente, cuya complejidad temporal sería 
O(Norte)elevado2 Donde Norte el número de nodos en el árbol. Como se puede 
imaginar, resultará en una excepción de límite de tiempo excedido en el juez en 
línea.

En primer lugar, aclaremos algunos conceptos.

La distancia entre dos nodos es el número de aristas que conectan los dos nodos.

Tenga en cuenta que normalmente podría haber varias rutas para conectar los 
nodos en un gráfico. Sin embargo, en nuestro caso, dado que el gráfico de 
entrada puede formar un árbol desde cualquier nodo, como se especifica en el 
problema, solo podría haber una ruta entre dos nodos cualesquiera. Además, no 
habría ningún ciclo en el gráfico. Como resultado, no habría ambigüedad en la 
definición anterior de distancia .

La altura de un árbol se puede definir como la distancia máxima entre la raíz y 
todos los nudos de sus hojas.

Con las definiciones anteriores, podemos reformular el problema como encontrar 
los nodos que en general están cerca de todos los demás nodos,especialmente los 
nodos hoja.

Si vemos el gráfico como un área del círculo y los nodos de hoja como la 
periferia del círculo, entonces lo que estamos buscando son en realidad 
los centroides del círculo, es decir , los nodos que están cerca de todos 
los nodos periféricos (nodos de hoja) .

    (O)                   (1)
     |                   / | \
    (1)                 /  |  \
   /   \              (0) (2) (3)   
 (2)   (3)         

Por ejemplo, en el gráfico anterior, está claro que el nodo con el valor 1es el 
centroide del gráfico. Si elegimos el nodo 1como raíz para formar 
un árbol, obtendríamos un árbol con la altura mínima , en comparación con otros
árboles que se forman con cualquier otro nodo.

Antes de continuar, aquí hacemos una afirmación que es esencial para el algoritmo.

Para el gráfico similar a un árbol, el número de centroides no es más de 2.

Si los nodos forman una cadena, es intuitivo ver que se cumple la declaración 
anterior, que se puede dividir en los siguientes dos casos:

Si el número de nodos es par, entonces habría dos centroides.
Si el número de nodos es impar, entonces solo habría un centroide.

(O)-(X)-(X)-(O)           (O)-(X)-(O)

Para el resto de los casos, podríamos probar por contradicción . Supongamos que 
tenemos 3 centroides en el gráfico, si eliminamos todoslos nodos que no son 
centroides en el gráfico, entonces los 3 nodos centroidesdeben formar un 
triángulo , de la siguiente manera:
 
 
    (X)         (X)          
   /   \       /   \               
 (X)   (X)   (O)   (O)
Debido a que estos centroides son igualmente importantes entre sí, y también
deberían estar igualmente cerca entre sí. Si falta alguno de los bordes del 
triángulo, los 3 centroides se reducirían a un solo centroide.

Sin embargo, la forma del triángulo forma un ciclo que se contradice con la 
condición de que no hay ciclo en nuestro gráfico de árbol. De manera similar, 
para cualquiera de los casos que tengan más de 2 centroides,estos deben formar 
un ciclo entre los centroides, lo cual se contradice con 
nuestra condición.

Por lo tanto, no puede haber más de 2 centroides en un gráfico similar a un 
árbol.

Dada la intuición anterior, el problema ahora se reduce a buscar todos los nodos
del centroide en un gráfico similar a un árbol, que además no son más de dos.

La idea es que vayamos recortando los nodos hoja capa por capa, hasta llegar 
al núcleo del grafo, que son los nodos centroides.

Una vez que recortamos la primera capa de los nodos de hoja (nodos que tienen 
una sola conexión), algunos de los nodos que no son de hoja se convertirían en 
nodos de hoja.

El proceso de recorte continúa hasta que solo quedan dos nodos en el gráfico, 
que son los centroides que estamos buscando.

El algoritmo anterior se asemeja al algoritmo de clasificación topológica que 
genera el orden de los objetos en función de sus dependencias. Por ejemplo, en
el escenario de programación de cursos, los cursos que tienen la menor 
dependencia aparecerían primero en el orden.

En nuestro caso, primero recortamos los nodos hoja, que están más alejados de 
los centroides. En cada paso, los nodos que recortamos están más cerca de los 
centroides que los nodos del paso anterior. Al final, el proceso de recorte 
termina en los nodos de los centroides .

Implementación

Dado el algoritmo anterior, podríamos implementarlo a través de la estrategia 
Breadth First Search (BFS), para recortar los nodos hoja capa por capa ( es 
decir , nivel por nivel).

Inicialmente, construiríamos un gráfico con la lista de adyacencia de la entrada.

Luego creamos una cola que se usaría para contener los nodos hoja.

Al principio, ponemos todos los nodos hoja actuales en la cola.

Luego ejecutamos un ciclo hasta que solo queden dos nodos en el gráfico.

En cada iteración, eliminamos los nodos hoja actuales de la cola. Al eliminar
los nodos, también eliminamos los bordes que están vinculados a los nodos. 
Como consecuencia, algunos de los nodos que no son hoja se convertirían en 
nodos hoja. Y estos son los nodos que se eliminarían en la próxima iteración.

La iteración termina cuando no quedan más de dos nodos en el gráfico, que son
los nodos centroides deseados.



Análisis de Complejidad

Dejar|V|sea ​​el número de nodos en el gráfico, entonces el número de aristas 
sería|V| - 1∣V∣−1como se especifica en el problema.

Complejidad del tiempo:El ( ∣ V ∣ )

Primero, se necesita∣V∣−1 iteraciones para que construyamos un gráfico, 
dadas las aristas.

Con el grafo construido, recuperamos los nodos hoja iniciales, lo que 
toma∣V∣pasos.

Durante el proceso de recorte de BFS, eliminaremos casi todos los nodos (∣V∣)
y bordes (∣V∣−1) desde los bordes. Por lo tanto, nos llevaría alrededor
|V| + |V| - 1∣operaciones para llegar a los centroides.

En resumen, la complejidad temporal total del algoritmo es El ( ∣ V ∣ ).
 */