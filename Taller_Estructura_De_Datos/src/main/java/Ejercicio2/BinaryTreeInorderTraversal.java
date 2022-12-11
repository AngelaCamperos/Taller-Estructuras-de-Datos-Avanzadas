/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

//IMPORTACIONES
//import Ejercicio1.TreeNode;
import java.util.LinkedList;
import java.util.List;

/*

++++++++++++ENUNCIADO SEGUNDO EJERCICIO TALLER ESTRUCTURAS DE DATOS+++++++++++++
Dada la rootde un árbol binario, devuelve el recorrido en orden de los valores 
de sus nodos 

                        (1)      
                          \
                          (2)
                          / 
                         (3)

EJEMPLO 1
********************************************************************************
* Entrada: raíz = [1, nulo, 2,3]                                               *
* Salida: [1,3,2]                                                              *                                                                  *
********************************************************************************

EJEMPLO 2
********************************************************************************
* Entrada: raíz = []                                                           *
* Salida: []                                                                   *                                                                 *     
********************************************************************************

EJEMPLO 3
********************************************************************************
* Entrada: raíz = [1]                                                          *
* Salida: [1]                                                                  *
******************************************************************************** 

Restricciones:

* El número de nodos en el árbol está en el rango [0, 100].

* -100 <= Node.val <= 100

*/

public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
         this.left = left;
         this.right = right;
      }
  }

public class BinaryTreeInorderTraversal {

List<Integer> resultList= new LinkedList<Integer>();
public List<Integer> inorderTraversal(TreeNode root) {
    if (root==null) 
       return resultList;
    
    inorderTraversal(root.left);
    resultList.add(root.val);
    inorderTraversal(root.right);
    return resultList;
  }
}

/*

++++++++EXPLICACION CODIGO SEGUNDO EJERCICIO TALLER ESTRUCTURAS DE DATOS++++++++
Este código utiliza un algoritmo recursivo para recorrer un árbol binario en 
orden y almacenar los valores de los nodos en una lista.

He aquí una representación gráfica de lo que hace el algoritmo:

          root
         /    \
        /      \
       /        \
  left subtree  right subtree

El algoritmo comprueba primero si el nodo raíz es nulo. Si lo es, la función
devuelve la lista de resultados.

Si el nodo raíz no es nulo, la función se llama a sí misma en el subárbol 
izquierdo de la raíz.

A continuación, el valor del nodo raíz se añade a la lista de resultados.

Por último, la función se llama a sí misma en el subárbol derecho de la raíz.

EL ANALISIS DE COMPLEJIDAD NOS DA

la complejidad temporal de este algoritmo es O(n), 
donde n es el número de nodos del árbol. Esto se debe a que la función visita 
cada nodo exactamente una vez. La complejidad espacial también es O(n) porque 
las llamadas a funciones recursivas crean una pila de llamadas con una 
profundidad máxima de n.

*/

/*

++++++++SOLUCION CODIGO EXPRESADO EN LA PAGINA DE ENTRENAMIENDO LEETCODE++++++++
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
         this.left = left;
         this.right = right;
      }
  }

     
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // pasar al siguiente nodo de la derecha
            } else { // tiene un subárbol izquierdo
                pre = curr.left;
                while (pre.right != null) { // encuentra el más a la derecha
                    pre = pre.right;
                }
                pre.right = curr; // poner cur después del nodo pre
                TreeNode temp = curr; // almacenar el nodo cur
                curr = curr.left; // mover cur a la parte superior del nuevo árbol
                temp.left = null; //la izquierda de cur original es nula, para evitar bucles infinitos
            }
        }
        return res;
    }
}

 *_______________________ANALISIS DE EL ALGORITMO_______________________________

//EXPLICACION SOLUCION LEETCODE
 En este método, tenemos que utilizar una nueva estructura de datos-Threaded 
Binary Tree, y la estrategia es la siguiente:

Paso 1: Inicializar current como raíz

Paso 2: Mientras current no sea NULL,

Si current no tiene un hijo a la izquierda

    a. Añadir el valor de current

    b. Ir a la derecha, es decir, current = current.right

Si

    a. En el subárbol izquierdo de current, haga a current hijo derecho del nodo más a la derecha

    b. Ir a este hijo izquierdo, es decir, current = current.left

Por ejemplo


         1
        / \
       2 3
      / \ /
     4 5 6

En primer lugar, 1 es la raíz, por lo que inicializar 1 como actual, 1 tiene 
hijo izquierdo que es 2, el subárbol izquierdo de la corriente es

         2
        / \
       4 5
Así que en este subárbol, el nodo más a la derecha es 5, a continuación, hacer 
la corriente (1) como el hijo derecho de 5. Establece current = cuurent.left 
(current = 2). El árbol ahora se ve como

         2
        / \
       4 5
            \
             1
              \
               3
              /
             6
Para la corriente 2, que ha dejado al niño 4, podemos continuar con el mismo 
proceso que hicimos anteriormente

        4
         \
          2
           \
            5
             \
              1
               \
                3
               /
              6

luego agrega 4 porque no tiene hijo izquierdo, luego agrega 2, 5, 1, 3 uno por 
uno, para el nodo 3 que tiene hijo izquierdo 6, haz lo mismo que arriba. 
Finalmente, el taversal de orden es [4,2,5,1,6,3].

//EXPLICACION NUESTRA

Este código define una clase TreeNode que representa un nodo en un árbol binario
, así como una clase Solution que contiene una implementación del algoritmo
inorder traversal para un árbol binario.

La clase TreeNode tiene tres campos: val, left y right. El campo val contiene el
valor almacenado en el nodo, left se refiere al hijo izquierdo del nodo, y right 
se refiere al hijo derecho del nodo.

La clase Solución tiene un método llamado inorderTraversal que toma el nodo raíz 
de un árbol binario como entrada y devuelve una lista de los valores de los 
nodos del árbol en orden. En otras palabras, los valores estarán en el orden de
hijo izquierdo, padre, hijo derecho.

Para ello, el método inorderTraversal utiliza un bucle while para recorrer los 
nodos del árbol. Para cada nodo, comprueba si tiene un hijo izquierdo. Si no lo
tiene, añade el valor del nodo a la lista y se mueve al hijo derecho del nodo 
actual. Si el nodo tiene un hijo izquierdo, el algoritmo busca el nodo situado 
más a la derecha en el subárbol izquierdo, convierte el nodo actual en hijo 
derecho del nodo situado más a la derecha, mueve el nodo actual al subárbol 
izquierdo y establece el hijo izquierdo del nodo actual original en null para 
evitar bucles infinitos.

________________________________ANALISIS DE COMPLEJIDAD_________________________

//EXPLICACION DE LEETCODE

Complejidad de tiempo: O(n)

Para demostrar que la complejidad temporal es O(n), el mayor problema radica
en encontrar la complejidad temporal de encontrar los nodos predecesores de 
todos los nodos del árbol binario. Intuitivamente, la complejidad es 
O(nlogn), porque encontrar el nodo predecesor de un único nodo está relacionado 
con la altura del árbol. Pero, de hecho, encontrar los nodos predecesores de 
todos los nodos sólo  necesita un tiempo O(n). Dado que un árbol binario con n 
nodos tiene n-1 aristas, todo el procesamiento de cada arista se realiza hasta 2
veces, una es para localizar un nodo, y la otra es para encontrar el nodo 
predecesor. Así que la complejidad es O(n).

//EXPLICACION NUESTRA
La complejidad temporal de este algoritmo es O(n), donde n es el número de nodos
del árbol, porque cada nodo se visita una vez. La complejidad espacial es O(n), 
porque en el peor de los casos, la lista de valores contendrá todos los valores 
del árbol.
 */
