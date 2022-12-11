/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;
/*
Dada la rootde un árbol binario, determine si es un árbol de búsqueda binario (BST) válido .

Un BST válido se define de la siguiente manera:

* La izquierda subárbol de un nodo contiene solo nodos con claves menores que
la clave del nodo.

* El subárbol derecho de un nodo contiene solo nodos con claves mayores que la 
clave del nodo.

* Los subárboles izquierdo y derecho también deben ser árboles de búsqueda binarios.

Ejemplo 1:
********************************************
*             (1)                          *
*            /   \                         *
*           /     \                        *
*         (2)     (3)                      *
* Entrada: raíz = [2,1,3]                  *
* Salida: verdadero                        *
********************************************

Restricciones:

* El número de nodos en el árbol está en el rango .[1, 104]
* -231 <= Node.val <= 231 - 1

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

public class ValidateBinarySearchTree {
public boolean isValidBST(TreeNode root) {
    return isValid(root, null, null);
}

public boolean isValid(TreeNode root, Integer min, Integer max) {
    if(root == null) return true;
    if(min != null && root.val <= min) return false;
    if(max != null && root.val >= max) return false;
    
    return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
}}

/*

++++++++++++ENUNCIADO TERCERER EJERCICIO TALLER ESTRUCTURAS DE DATOS++++++++++++

Este código define una clase TreeNode que representa un nodo en un árbol binario
y una clase Solution que contiene una implementación de un algoritmo que 
comprueba si un árbol binario es un árbol de búsqueda binario (BST) válido.

La clase TreeNode tiene un único campo llamado val que contiene el valor 
almacenado en el nodo.

La clase Solution tiene un método llamado isValidBST que toma el nodo raíz de 
un árbol binario como entrada y devuelve true si el árbol es un BST válido, y 
false en caso contrario.

El método isValidBST llama a otro método llamado isValid, que toma como 
entrada el nodo raíz, un valor mínimo y un valor máximo, y devuelve true si
el árbol enraizado en el nodo de entrada es un BST válido con los valores mínimo
y máximo dados, y false en caso contrario.

Para comprobar si un árbol es un BST válido, el método isValid comprueba primero
si el nodo raíz es nulo. Si lo es, entonces el árbol está vacío y por lo tanto 
es un BST válido, por lo que el método devuelve true. Si el nodo raíz no es nulo,
el método comprueba si el valor del nodo raíz es menor o igual que el valor 
mínimo (si el valor mínimo no es nulo) o mayor o igual que el valor máximo (si 
el valor máximo no es nulo). Si cualquiera de estas comprobaciones es verdadera, 
entonces el árbol no es un BST válido, por lo que el método devuelve false. En 
caso contrario, el método comprueba recursivamente los subárboles izquierdo y 
derecho del nodo raíz, utilizando el valor del nodo raíz como valor máximo para
el subárbol izquierdo y como valor mínimo para el subárbol derecho. El método
devuelve true si ambas llamadas recursivas devuelven true, y false en caso 
contrario.

//ANALISIS DE COMPLEJIDAD
La complejidad temporal de este algoritmo es O(n), donde n es el número de
nodos del árbol, porque cada nodo se visita una vez. La complejidad espacial 
es O(n), porque en el peor de los casos, la pila de llamadas contendrá todos
los nodos del árbol.



//CODGIO EXPUESTO EN LEETCODE
* public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 

public class Solution
{
    public boolean validate(TreeNode root, Integer low, Integer high) {
        // Los árboles vacíos son BST válidos.
        if (root == null) {
            return true;
        }
        // El valor del nodo actual debe estar entre bajo y alto.
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        // El valor del nodo actual debe estar entre bajo y alto.
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

}

/*
class Solution {

    private Deque<TreeNode> stack = new LinkedList();
    private Deque<Integer> upperLimits = new LinkedList();
    private Deque<Integer> lowerLimits = new LinkedList();

    public void update(TreeNode root, Integer low, Integer high) {
        stack.add(root);
        lowerLimits.add(low);
        upperLimits.add(high);
    }

    public boolean isValidBST(TreeNode root) {
        Integer low = null, high = null, val;
        update(root, low, high);

        while (!stack.isEmpty()) {
            root = stack.poll();
            low = lowerLimits.poll();
            high = upperLimits.poll();

            if (root == null) continue;
            val = root.val;
            if (low != null && val <= low) {
                return false;
            }
            if (high != null && val >= high) {
                return false;
            }
            update(root.right, val, high);
            update(root.left, low, val);
        }
        return true;
    }
}
*/

/*
 * ANALISIS DE EL ALGORITMO
 A primera vista, el problema es trivial. Recorramos el árbol y verifiquemos en cada paso si 
 node.right.val > node.valy node.left.val < node.val. Este enfoque incluso funcionaría para algunos árboles.
 
 // Definicion
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

GRAFICO

     (5)    No BTS por que 4 < 5
    /   \
   1     4
        /  \
       3     6
       
El problema es que este enfoque no funcionará para todos los casos. No solo el hijo derecho debe ser más 
grande que el nodo, sino todos los elementos en el subárbol derecho. Aquí hay un ejemplo :       
      
     (5)
    /   \
   /  ***********  En cada nodo las condiciones
   1  *   6     *  
      *  /  \   * noderight.val > node.val
      * 4     7 * node.left.val < node.val
      * *********      
                  son validos
                  
                  Pero no es BST por que no todos los elementos
                  elemntos en el subarbol  derecho del nodo 5
                  son mayores que 5 ( 4 < 5)
                  
Eso significa que uno debe mantener los límites superior e inferior para cada nodo al atravesar el árbol, 
y comparar el valor del nodo no con los valores de los niños sino con estos límites.


ANALISIS DE COMPLEJIDAD
Complejidad del tiempo:O ( N )en el peor de los casos, cuando el árbol es BST o el elemento 
"malo" es una hoja más a la derecha.

 */

