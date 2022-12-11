package Ejercicio6;

//iMPORTACIONES
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Hay un gráfico bidireccionaln con vértices, donde cada vértice está etiquetado
de 0a n - 1( inclusive ). Los bordes del gráfico se representan como una matriz 
de enteros 2D edges, donde cada uno denota un borde bidireccional entre vértice 
y vértice . Cada par de vértices está conectado como máximo por una arista, y 
ningún vértice tiene una arista en sí mismo.edges[i] = [ui, vi]uivi

Desea determinar si existe una ruta válida de vértice sourcea vértice destination.

Dado edgesy los enteros n, sourcey destination, devuelven truesi hay una ruta 
válida de sourcea destination, o falsede lo contrario .


*/

class Solution {
    
    int[]par;
    private int findPar(int u)
    {
       return par[u] == u ? u : (par[u] = findPar(par[u]));
    }
    public boolean validPath(int n, int[][] edges, int start, int end) {
        par = new int[n];
        for(int i = 0;i<n;i++)
        {
            par[i] = i;
        }
        for(int[]e:edges)
        {
            int p1 = findPar(e[0]);
            int p2 = findPar(e[1]);
            if(p1 != p2)
            {
                par[p1] = p2;
            }
        }
        // if global parent of start vertex and end vertex is same then there exists a path
        return findPar(start) == findPar(end);
    }


/*
   
EXPLICACION DE NUESTRO CODIGO
    
Este código define una clase Solución que contiene una implementación de un 
algoritmo para comprobar si existe un camino entre dos nodos dados en un 
grafo no dirigido y conectado.

La clase Solution tiene un método llamado validPath que toma como entradas 
el número de nodos del grafo, n, una lista de aristas representadas como pares 
de índices de nodos, el índice del nodo inicial y el índice del nodo final. 
El método devuelve verdadero si existe un camino entre los nodos inicial y final,
y falso en caso contrario.

El método validPath inicializa primero un array llamado par para contener el 
padre de cada nodo del grafo. Cada nodo es inicialmente su propio padre. El 
método itera sobre la lista de aristas y para cada arista, encuentra el padre de 
cada uno de los dos puntos finales usando el método findPar. Si los padres de los
dos puntos finales son diferentes, establece que el padre del primer punto final 
sea el mismo que el padre del segundo punto final. Esto crea un bosque de árboles,
donde cada árbol representa un componente conectado del grafo.

Una vez procesadas todas las aristas, el método validPath utiliza el método 
findPar para encontrar el padre global de los nodos inicial y final. Si el padre
global de los nodos inicial y final es el mismo, significa que existe un camino 
entre los nodos inicial y final en el grafo original, por lo que el método devuelve 
true, en caso contrario devuelve false.

El método findPar toma el índice de un nodo como entrada y devuelve el padre 
global de ese nodo. Utiliza la recursión para recorrer los punteros de los
padres hasta llegar a la raíz del árbol. Utiliza la compresión de rutas para 
establecer el padre de cada nodo visitado en el nodo raíz, de forma que las
futuras llamadas a findPar para el mismo nodo sean más rápidas.

    ANALISIS DE COMPLEJIDAD
    
    
La complejidad temporal de este algoritmo es O(m * α(n)), donde m es el número 
    de aristas del grafo y n es el número de nodos del grafo. El método findPar 
    tarda O(α(n)) en encontrar el padre global de un nodo, donde α es la función
    inversa de Ackermann. Esta función crece muy lentamente y suele considerarse
    constante, por lo que en la práctica se considera que la complejidad temporal
    es O(m). La complejidad espacial es O(n), porque la matriz par tiene un tamaño
    de n.

    
    
    
CODIGO SOLUCION EXPUESTA POR LEETCODE

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //Almacenar todas las aristas en 'graph'.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }
        
        // Almacena todos los nodos a visitar en la 'cola'.
        boolean[] seen = new boolean[n];
        seen[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            if (currNode == destination) {
                return true; 
            }

              // Para todos los vecinos del nodo actual, si no lo hemos visitado antes,            
            // lo añadimos a la 'cola' y lo marcamos como visitado.
            for (int nextNode : graph.get(currNode)) {
                if (!seen[nextNode]) {
                    seen[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
        
        return false;
    }
}

/*
 ________________________ANALISIS DE ALGORITMOS_________________________________
 Algoritmo
1. Inicialice una cola vacía ( queue) para almacenar los nodos a visitar.
2. Use una matriz booleana seenpara marcar todos los nodos visitados y un mapa
    hash graphpara almacenar todos los bordes.
3. Agregue el nodo 0de inicio queuey márquelo como visitado .
4. Si queuetiene nodos, obtenga el primer nodo curr_nodede queue. Regrese 
    truesi curr_nodees destination, de lo contrario, vaya al paso 5.
5. Agregue todos los nodos vecinos no visitadoscurr_node de to queuey márquelos
    como visitados , luego repita el paso 4.
6. Si vaciamos queuesin encontrar destination, volver false.

__________________________ANALISIS DE COMPLEJIDAD_______________________________
DejarnortenorteSea el número de nodos ymetrometroSea el número de aristas.

Complejidad del tiempo:O(n + m)

En una búsqueda BFS típica, la complejidad del tiempo es O( V+mi )dónde EN es el
número de vértices y Y es el número de aristas. Existennortenortenodos 
ymetrometrobordes en este problema.

*  Construimos una lista adyacente de todos los mbordes en graphlos que toma O(m).

*  Cada nodo se agrega a la cola y se saca de la cola una vez, tomaEn O( n )para 
manejar todos los nodos.

La complejidad del tiempo esO(n + m).
 */
