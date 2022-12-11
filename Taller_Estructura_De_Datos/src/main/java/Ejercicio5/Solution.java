package Ejercicio5;

 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null && cloned == null){
            return null;
        }
        
        if(original == target){
            return cloned;
        }
        
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        
        if(left != null){
            return left;
        }
        
        return getTargetCopy(original.right, cloned.right, target);
        
    }

/*

EXPLICACION ANALISIS DE NUESTRO CODIGO

Este código define un método llamado getTargetCopy que toma como entradas el 
nodo raíz de un árbol binario original, el nodo raíz de un árbol binario clonado
que es una copia del árbol original, y un nodo destino del árbol original. El 
método devuelve el nodo correspondiente en el árbol clonado para el nodo de 
destino introducido.

Para encontrar el nodo correspondiente en el árbol clonado, el método 
getTargetCopy utiliza la recursión para recorrer los árboles original y 
clonado en profundidad. Comprueba si tanto el árbol original como el clonado 
son nulos y, si lo son, devuelve null. Si el árbol original no es nulo y el 
nodo de destino es el nodo actual del árbol original, devuelve el nodo 
correspondiente del árbol clonado. En caso contrario, se llama a sí mismo 
recursivamente con el hijo izquierdo del nodo actual en los árboles original y 
clonado como nuevos nodos raíz, y el mismo nodo destino. Si la llamada devuelve
un valor no nulo, devuelve ese valor. En caso contrario, realiza otra llamada 
recursiva con el hijo derecho del nodo actual en los árboles original y clonado
como los nuevos nodos raíz, y el mismo nodo destino. Si esta llamada devuelve un
valor no nulo, devuelve ese valor, de lo contrario devuelve null.


ANALISIS DE COMPLEJIDAD DE NUESTRO CODIGO


La complejidad temporal de este algoritmo es O(n), donde n es el número de nodos 
del árbol original, porque cada nodo del árbol original se visita una vez. La 
complejidad espacial es O(n), porque en el peor de los casos, la pila de llamadas 
contendrá todos los nodos del árbol original.




CODIGO SOLUCION EXPUESTA POR LEETCODGE CON ANALISIS
class Solution {
    TreeNode ans, target;
    
    public void inorder(TreeNode o, TreeNode c) {
        if (o != null) {
            inorder(o.left, c.left);
            if (o == target) {
                ans = c;    
            }
            inorder(o.right, c.right);    
        }
    }
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        inorder(original, cloned);
        return ans;
    }
}


/*
 ____________________________ANALISIS DE ALGORITMO______________________________
 
 Cómo resolver

Recorramos ambos árboles en paralelo y, una vez que se identifique el nodo de 
destino en el primer árbol, devolvamos el nodo correspondiente del segundo árbol.

Cómo atravesar el árbol: DFS vs BFS

Hay dos formas de atravesar el árbol: búsqueda primero en profundidad DFS y
búsqueda primero en amplitud BFS . Aquí un pequeño resumen

//IMAGEN Arbol Binario Transversales Que se encuentras en el paquete

Ambos comienzan desde la raíz y bajan, ambos usan estructuras adicionales, 
¿cuál es la diferencia? Así es como se ve a gran escala: BFS atraviesa nivel
por nivel, y DFS primero va a las hojas.


//Imagen ComparativaBFSVSDFS
La descripción no nos da ninguna pista de qué recorrido es mejor usar aquí. 
Las soluciones de entrevista simple son recorridos en orden DFS.

En el Enfoque 1 y el Enfoque 2, vamos a analizar los DFS en orden recursivos y 
los recorridos DFS en orden iterativos. Ambos necesitan hasta O ( H )espacio 
para guardar la pila, dondeHHes la altura de un árbol.

En el Enfoque 3, proporcionamos una solución BFS. Normalmente, es una mala idea
usar BFS durante la entrevista, a menos que el entrevistador lo presione 
agregando nuevos detalles en la descripción del problema.

______
______ ANALISIS DE COMPLEJIDAD________
___________________________________________________________________________


Complejidad del tiempo:\mathcal{O}(N)O ( N ). Dado que uno tiene que visitar 
cada nodo, dondenortenortees un número de nodos.

 */