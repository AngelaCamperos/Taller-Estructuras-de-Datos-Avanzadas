/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

//Importaciones
import java.util.LinkedList;
import java.util.Queue;

/*

+++++++++++++ENUNCIADO PRIMER EJERCICIO TALLER ESTRUCTURAS DE DATOS+++++++++++++

                    Insertador de árbol binario completo

Un árbol binario completo es un árbol binario en el que todos los niveles, 
excepto posiblemente el último, están completamente llenos y todos los nodos 
están lo más a la izquierda posible.

Diseñe un algoritmo para insertar un nuevo nodo en un árbol binario completo 
manteniéndolo completo después de la inserción.


Implementar la CBTInserterclase:

* CBTInserter(TreeNode root)Inicializa la estructura de datos con la rootdel 
árbol binario completo.

* int insert(int v)Inserta a TreeNodeen el árbol con valor Node.val == valpara 
que el árbol permanezca completo y devuelve el valor del padre del insertado 
TreeNode.

* TreeNode get_root()Devuelve el nodo raíz del árbol.

********************************************************************************
* Input                                                                        *
* ["CBTInserter", "insert", "insert", "get_root"]                              *
* [[[1, 2]], [3], [4], []]                                                     *
* Output                                                                       *
* [null, 1, 2, [1, 2, 3, 4]]                                                   *
*                                                                              *
* Explanation                                                                  *
* CBTInserter cBTInserter = new CBTInserter([1, 2]);                           *
* cBTInserter.insert(3);  // return 1                                          *
* cBTInserter.insert(4);  // return 2                                          *
* cBTInserter.get_root(); // return [1, 2, 3, 4]                               *
********************************************************************************

Restricciones:

* El número de nodos en el árbol estará en el rango [1, 1000].

* 0 <= Node.val <= 5000

* rootes un árbol binario completo.

* 0 <= val <= 5000

* Como máximo, se realizarán llamadas a y .104insertget_root


*/

//Definición de un nodo de árbol binario.
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

class CBTInserter {

    TreeNode root;
    Queue<TreeNode> queue = new LinkedList<>();
    //@SuppressWarnings("empty-statement")
    @SuppressWarnings("empty-statement")
    public CBTInserter(TreeNode root) {
        this.root = root;
        boolean shouldInsert = true;
        queue.offer(root);
        while(shouldInsert) {
            boolean leftPresent = false;;
            boolean rightPresent = false;;
            TreeNode currNode = queue.peek();
            if(currNode.left != null) {
                queue.offer(currNode.left);
                leftPresent = true;
            } else {
                shouldInsert = false;
            }
            if(currNode.right != null) {
                queue.offer(currNode.right);
                rightPresent = true;
            } else {
                shouldInsert = false;
            }
            if(leftPresent && rightPresent) {
                queue.poll();
            }
        }
    }
    
    public int insert(int v) {
        TreeNode currNode = queue.peek();
        boolean leftPresent = currNode.left != null;
        boolean rightPresent = currNode.right != null;
        if(!leftPresent) {
            currNode.left = new TreeNode(v);
            queue.offer(currNode.left);
            leftPresent = true;
        } else if(!rightPresent) {
            currNode.right = new TreeNode(v);
            queue.offer(currNode.right);
            rightPresent = true;
        }
        if(leftPresent && rightPresent) {
            queue.poll();
        }
        return currNode.val;
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}

/*

++++++++EXPLICACION CODIGO PRIMER EJERCICIO TALLER ESTRUCTURAS DE DATOS+++++++++

Este código define una clase TreeNode que representa un nodo en un árbol binario.
Cada nodo tiene un valor y dos nodos hijos, izquierdo y derecho. La clase 
proporciona tres constructores: uno sin argumentos, otro con un valor, y otro 
con un valor y dos nodos hijos.

El código también define una clase CBTInserter que puede utilizarse para 
insertar nuevos nodos en un árbol binario completo. Un árbol binario completo 
es un árbol binario en el que todos los niveles están completamente llenos, 
excepto posiblemente el último nivel, y todos los nodos del último nivel están 
lo más a la izquierda posible.

La clase CBTInserter tiene tres métodos: un constructor, insert y get_root. 
El constructor toma como argumento el nodo raíz de un árbol binario completo 
e inicializa el campo raíz del objeto CBTInserter con este nodo. También 
inicializa una cola vacía de objetos TreeNode y añade el nodo raíz a esta cola. 
A continuación, continúa añadiendo nodos a la cola hasta que llega a un nodo al 
que le falta un hijo.

El método insert inserta un nuevo nodo con el valor especificado en el árbol 
binario completo. Primero recupera el nodo al principio de la cola, y comprueba
si este nodo tiene un hijo perdido. Si no le falta ningún hijo, el método 
elimina el nodo de la cola. Si tiene un hijo ausente, el método crea un nuevo
objeto TreeNode con el valor especificado y lo inserta como hijo ausente del 
nodo al principio de la cola. A continuación, añade el nuevo nodo a la cola. 
El método devuelve el valor del nodo situado al principio de la cola antes de
ser eliminado.

El método get_root simplemente devuelve el nodo raíz del árbol binario completo.

He aquí una representación gráfica de cómo funciona la clase CBTInserter:

  1            - insert(2)
 / \           - insert(3)
    2          - insert(4)
       \       - insert(5)
        3      - insert(6)
       / \
      4   5


He aquí una representación gráfica sencilla de la inserción de nodos en un árbol
utilizando la clase CBTInserter:

Crea un TreeNode con el valor especificado, un TreeNode izquierdo y un TreeNode 
derecho. Añade el nuevo TreeNode al deque.
Compruebe si el primer TreeNode del deque tiene un hijo izquierdo nulo.
Si lo tiene, establezca el hijo izquierdo del primer TreeNode en el deque para 
que sea el último elemento en el deque (el nuevo TreeNode).

Tree:
   1

Deque:
   1

5. Si el primer TreeNode del deque no tiene un hijo izquierdo nulo, establece el
hijo derecho del primer TreeNode del deque para que sea el último elemento del 
deque (el nuevo TreeNode) y elimina el primer TreeNode del deque.

Árbol:
   1
  / \
 2   3

Deque:

Este proceso continúa hasta que todos los TreeNodes deseados se han añadido al 
árbol.


EL ANALISIS DE COMPLEJIDAD NOS DA O(N)
La complejidad temporal de la clase CBTInserter es O(1) para el método de 
inserción y O(n) para el constructor. Esto se debe a que el método de inserción 
siempre tarda un tiempo constante, ya que sólo realiza un número constante de 
operaciones. El constructor, en cambio, tarda un tiempo lineal porque tiene que 
recorrer todo el árbol para añadir todos los nodos a la cola.

La complejidad espacial de la clase CBTInserter es O(n), ya que la cola puede 
contener hasta n n nodos.

*/

/*
++++++++SOLUCION CODIGO EXPRESADO EN LA PAGINA DE ENTRENAMIENDO LEETCODE++++++++

//Definición de un nodo de árbol binario.
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
 

class CBTInserter {
    TreeNode root;
    Deque<TreeNode> deque;
    public CBTInserter(TreeNode root) {
        this.root = root;
        deque = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null || node.right == null)
                deque.offerLast(node);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode node = deque.peekFirst();
        deque.offerLast(new TreeNode(v));
        if (node.left == null)
            node.left = deque.peekLast();
        else {
            node.right = deque.peekLast();
            deque.pollFirst();
        }
    }
    /*
     *____________________ANALISIS DE EL ALGORITMO______________________________

    //EXPLICACION SOLUCION LEETCODE
    Tome que todos ls nodos enumerados por niveles de izquiera a derecha a esto 
    lo llamaremos orden numerico de los nodos
    
    En cada insercion ose que queremos insertar en el nodo con numero mas bajo 
    
    Al sostener una deque la cual es la cola de los dos extremos de estos en un 
    nodo numero podemos proceder a resolver el problema. Despues de insetar un 
    nodo, ese nodo ahora tiene el numero mas algo y no  tiene hijos, por lo que 
    va al final de la cola de los dos extremos. Para poder tener el cnodo con el
    numero mas bajo damos un salto a e inicio de la deque.
    
    Continuando primero se realiza una busqueda para poder llenar el deque con 
    los nodos que tengan de 0 a 1 hijo en orden numerico, luego se inseta un 
    nodo , el paadre es el primer elemento del deque y luego agregamos este 
    nuevo nodo a nuestro dequey asi sucesivamente
    
    //////////////////EXPLICACION NUESTRA SOBRE EL CODIGO///////////////////////
    El código define una clase llamada TreeNode, que tiene cuatro atributos: 
    un valor entero, un TreeNode izquierdo, un TreeNode derecho, y un constructor 
    que crea un TreeNode con un valor especificado, un TreeNode izquierdo y 
    un TreeNode derecho.

    La clase también define una clase CBTInserter, que tiene dos atributos: 
    un TreeNode raíz y un deque de TreeNodes. La clase CBTInserter tiene un 
    constructor que toma un TreeNode raíz e inicializa los atributos root y
    deque. El constructor también crea una cola de TreeNodes y añade el TreeNode 
    raíz a la cola. A continuación, itera a través de la cola, añadiendo 
    cualquier TreeNode con un hijo izquierdo o derecho nulo a la cola y 
    añadiendo los hijos izquierdo y derecho de cada TreeNode de la cola a la 
    cola.

    La clase CBTInserter también tiene un método llamado insert, que toma un 
    valor entero y crea un nuevo TreeNode con ese valor. Añade el nuevo TreeNode
    a la cola y comprueba si el primer TreeNode de la cola tiene un hijo 
    izquierdo nulo. Si lo tiene, establece el hijo izquierdo del primer TreeNode
    del deque como el último elemento del deque (el nuevo TreeNode). Si el 
    primer TreeNode de la deque no tiene un hijo izquierdo nulo, establece el   
    hijo derecho del primer TreeNode de la deque como el último elemento de la 
    deque (el nuevo TreeNode) y elimina el primer TreeNode de la deque.
    ____________________________________________________________________________
    
    ANALISIS DE COMPlEJIDAD
    La complejidad de este algoritmo es O(n), ya que recorre todos los nodos del
    árbol para añadirlos a la deque.

    */
