# TallerEstructuraDeDatos

PROJECT TITLE: TALLER DE ESTRUCTURA DE DATOS AVANZANDAS

PURPOSE OF PROJECT: MEJORAR EN EL DESARROLLO Y ANALISIS DE ESTRUCTURA DE DATOS MAS ESPECIFICAMENTE ARBOLES

VERSION or DATE: 2022

HOW TO START THIS PROJECT: 2022

AUTHORS:

ANGELA DANIELA CAMPEROS REYES - 1152076
JUAN ESTEBAN HERNANDEZ ALVAREZ - 1152122
MARIA ALEXANDRA SIERRA PABON - 1152079

USER INSTRUCTIONS: A continuación una lista de problemas relacionados con estructuras de datos avanzadas:

https://leetcode.com/problems/complete-binary-tree-inserter/ https://leetcode.com/problems/binary-tree-inorder-traversal/ https://leetcode.com/problems/validate-binary-search-tree/ https://leetcode.com/problems/minimum-height-trees/ https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/ https://leetcode.com/problems/find-if-path-exists-in-graph/ https://leetcode.com/problems/relative-ranks/ https://codeforces.com/problemset/problem/681/C https://atcoder.jp/contests/abc240/tasks/abc240_b?lang=en https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1998 Para cada problema debe:

Resolverlo en la plataforma

Escribir un programa que genere dos ficheros TXT, un fichero con datos de entrada y otro con datos de salida. Estos datos deben servir para probar la misma solución anterior en otra plataforma. La prueba debe realizarla (según lo explicado en clase) usando redirección de I/O por comandos < in.txt >out.txt

Explicar la solución con un ejemplo gráfico, con colores, paso a paso. Por ejemplo, si se requiere armar un árbol y luego recorrerlo, debe mostrarse un ejemplo completo de manera gráfica. Si se deben considerar varios escenarios o casos borde, deben incluirse en esta explicación.

Publicar todo lo anterior en git hub en un repositorio, usando el README para la documentación. Subir a UVIRTUAL un ZIP completo del repositorio.

Evaluar el trabajo de un compañero, según la rúbrica del taller.

El trabajo puede hacerlo en equipo, pero la entrega debe ser individual.

Sobre estos mismos problemas se hará el examen final del curso.


EJERCICIO NUMERO 1


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
  
  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  
  EJERICICIO NUMERO 2
  
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


++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  
  EJERCICIO NUEMERO 3
  
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


-----------------------------------------------------------------------------------------------------------------------------------------------------------
  
  EJERCICIO NUMERO 4
  
  
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

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  
  
  EJERCICIO NUMERO 5
  
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
  
  ------------------------------------------------------------------------------------------------------------------------------
  
  
  EJERCICIO NUMERO 6
  
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
  
  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  
  
  EJERICICIO NUEMRO 7
  
  
  package Ejercicio7;


class Solution {
public String[] findRelativeRanks(int[] nums) {
    int[] sorted=nums.clone();
    Arrays.sort(sorted);
    int i=0,j=nums.length-1;
    while(i<j){int temp=sorted[i];sorted[i]=sorted[j];sorted[j]=temp;i++;j--;}
    HashMap<Integer,String> map=new HashMap();
    for(int k=0;k<nums.length;k++)map.put(sorted[k],String.valueOf(k+1));
    String[] output=new String[nums.length];
    int k=0;
    for(int a:nums){
        if(map.get(a).equals("1"))output[k]="Gold Medal";
        else if(map.get(a).equals("2"))output[k]="Silver Medal";
        else if(map.get(a).equals("3"))output[k]="Bronze Medal";
        else output[k]=map.get(a);k++;
    }
    return output;
  }
}    

/*
_____________________________ANALISIS DE EL ALGORITMO__________________________
El código que ha proporcionado es una solución Java a un problema que implica 
la clasificación de una lista de números en función de su tamaño. La solución
define una clase Solution con un único método público, findRelativeRanks(), 
que toma una matriz de enteros nums como entrada y devuelve una matriz de
cadenas como salida.

El método crea primero una copia de la matriz de entrada nums llamada sorted 
y ordena los elementos de sorted en orden ascendente. A continuación, el 
método invierte el orden de los elementos de sorted para que estén en orden descendente.

A continuación, el método crea un objeto HashMap llamado map y utiliza un bucle 
for para iterar sobre los elementos de sorted. Para cada elemento k de sorted, 
el método añade un par clave-valor a map, donde la clave es el elemento k y el 
valor es la representación de cadena del rango de k en sorted.

A continuación, el método declara una matriz de cadenas llamada output que se utilizará para almacenar los resultados finales del método. A continuación, el método utiliza otro bucle for para iterar sobre los elementos de nums. Para cada elemento a en nums, el método recupera el valor correspondiente de map y lo asigna a output[k]. Si el valor es "1", "2" o "3", el método asigna la medalla correspondiente (es decir, "Medalla de Oro", "Medalla de Plata" o "Medalla de Bronce") a output[k]. El método incrementa el valor de k después de cada iteración.

Por último, el método devuelve la matriz de salida como resultado del método findRelativeRanks().
                                                                          
 Se le da una matriz scorede números enteros de tamaño n, donde score[i]es el 
puntaje del atleta en una competencia. Se garantiza que todas las puntuaciones 
son únicas .ith
Los atletas se colocan en función de sus puntajes, donde el atleta del lugar 
tiene el puntaje más alto, el atleta del lugar tiene el puntaje más alto, y 
así sucesivamente. La ubicación de cada atleta determina su rango:1st2nd2nd
El lugar donde se encuentra el rango del atleta .1st"Gold Medal"
El lugar donde se encuentra el rango del atleta .2nd"Silver Medal"
El lugar donde se encuentra el rango del atleta .3rd"Bronze Medal"
Para el puesto del atleta del puesto, su rango es su número de puesto (
es decir, el puesto del atleta del puesto es ).4thnthxth"x"
Devuelve una matriz answerde tamaño ndonde answer[i]está el rango del atleta.ith
_________________________ANALISIS DE COMPLEJIDAD________________________________
                                                                          
La complejidad temporal de este algoritmo es O(n log n) porque la operación de ordenación realizada por el método tiene una complejidad temporal de O(n log n) y los bucles for tienen una complejidad temporal de O(n).
 */
                                                                          
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                                                                          
                                                                          
 EEJERICICO 8
                                                                          
                                                                          package Ejercicio8;


#include<functional>
#include<stdio.h>
#include<string.h>
#include<queue>
using namespace std;
typedef struct
{
	char stu[20];
	int x;
}carry;
carry str[1000005],str1[1000005];
int  main()
{
	int n,m,j=0;
	priority_queue<int, vector<int>,greater<int> >k;
	scanf("%d",&n);
	for(int i=1;i<=n;i++)
	{
		scanf(" %s",str[i].stu);
		if(strcmp(str[i].stu,"removeMin")!=0)
			scanf("%d",&str[i].x);
		if(strcmp(str[i].stu,"insert")==0)
		{
			k.push(str[i].x);
			str1[j++]=str[i];
		}
		else if(strcmp(str[i].stu,"removeMin")==0)
		{
			if(k.empty())
			{
				k.push(1);
				strcpy(str1[j].stu,"insert");
				str1[j++].x=1;
			}
			k.pop();
			str1[j++]=str[i];
		}
		else if(strcmp(str[i].stu,"getMin")==0)
		{
            if(k.empty())
			{
				strcpy(str1[j].stu,"insert");
				str1[j++].x=str[i].x;
				k.push(str[i].x);
				strcpy(str1[j].stu,"getMin");
				str1[j++].x=str[i].x;
			}
			else
			{
				while(k.top()<str[i].x)
				{
					strcpy(str1[j++].stu,"removeMin");
					k.pop();
					if(k.empty())
					{
						strcpy(str1[j].stu,"insert");
						str1[j++].x=str[i].x;
						k.push(str[i].x);
					}
				}
				if(k.top()>str[i].x)
				{
					strcpy(str1[j].stu,"insert");
					str1[j++].x=str[i].x;
					k.push(str[i].x);
				}
				if(k.top()==str[i].x)
				{
					strcpy(str1[j].stu,"getMin");
					str1[j++].x=str[i].x;
				}
			}
		}
	}
	printf("%d\n",j);
	for(int i=0;i<j;i++)
	{
		if(strcmp(str1[i].stu,"removeMin")==0)
			printf("%s\n",str1[i].stu);
		else
			printf("%s %d\n",str1[i].stu,str1[i].x);
	}
}


/* ______________________ANALISIS DE EL ALGORITMO______________________________-
 * 
 * 
Este código es una implementación de una estructura de datos de cola utilizando 
una cola de prioridad. Permite tres operaciones en la cola: insert, removeMin,
y getMin. Está escrito en C++ y utiliza la clase priority_queue de la biblioteca
estándar para implementar la cola de prioridad.
El código define primero una estructura carry que tiene dos miembros: un array 
char llamado stu para almacenar el nombre de una operación y un int llamado x 
para almacenar un argumento entero para la operación. Luego declara dos matrices
de carry structs llamadas str y str1 para almacenar las operaciones de entrada y
salida, respectivamente.
En la función principal, el código lee el número de operaciones, n, de la entrada
estándar y, a continuación, lee n líneas de entrada, cada una de las cuales 
contiene una operación y su argumento. Para cada operación, actualiza la cola de
prioridad de la siguiente manera:
* Para una operación de inserción, coloca el argumento entero en la cola de
prioridad. También añade la operación a la matriz str1.
* Para una operación removeMin, elimina el elemento más pequeño de la cola de
prioridad. Si la cola de prioridad está vacía, coloca un elemento ficticio 
con valor 1 en la cola de prioridad. A continuación, añade la operación removeMin
a la matriz str1.
* Para una operación getMin, extrae repetidamente elementos de la cola de prioridad
hasta que el elemento más pequeño de la cola de prioridad es mayor o igual que el 
argumento entero para la operación getMin. Si el elemento más pequeño de la cola de
prioridad es mayor que el argumento, empuja el argumento a la cola de prioridad. 
A continuación, añade la operación getMin a la matriz str1.
Una vez procesadas todas las operaciones, el código muestra el número de operaciones
en la matriz str1, seguido de las propias operaciones.
  En primer lugar, esta pregunta utiliza una cola de prioridad, que es la base para resolver esta pregunta.
  ¿Qué es una cola de prioridad?
   Archivo de encabezado de llamada:
  #include<queue>
  usando el espacio de nombres std; (la plantilla de la cola necesita definir el tipo de contenedor)
       uso detallado (parte): 
  Priority_queue<Type> k; ------ Defina una cola ordenada (el elemento superior es el más grande El uno)
  priority_queue<(el tipo de datos de los elementos en la cola), (el tipo del contenedor subyacente utilizado para almacenar y acceder a los elementos de la cola), (reglas de comparación) > k ------ ( forma estándar) define una cola ordenada
  Por ejemplo: cola_prioridad<int, vector<int>, mayor<int> > k; (nota: debe haber un espacio después de la regla de comparación)
define una cola ordenada, y la regla de clasificación es de grande a pequeño (el elemento superior es el más pequeño El que está en la parte superior del mayor) (el más pequeño en la parte superior de mayor, el más grande en la parte superior de menor)
  k.empty() ------ Verifique si es un ejemplo vacío, en caso afirmativo, devuelve 1, no devuelve 0
  k.push(i) ------ Desde Agregar elemento i después del elemento existente (el tamaño del equipo no está predeterminado)
  k.pop() - ----- Borrar el elemento superior (por supuesto, después de ordenar, lo mismo a continuación)
  k.top() ---- -- Mostrar el elemento superior
  k.size() ------ Mostrar el número de elementos existentes
 
Luego mira la solución específica de la pregunta:
  En primer lugar, hay insert, getmin, removemin, tres formas.
insert y removemin no se detallarán aquí;
Concéntrese en discutir la situación de getmin. Realmente llevó demasiado tiempo depurar en ese momento.
(1) Cuando la cola está vacía, inserte directamente + getmin;
(2) Cuando el valor mínimo actual de la cola es menor que el valor mínimo en getmin, es necesario eliminar continuamente el valor mínimo en la cola hasta que sea mayor o igual a
Valor mínimo en getmin
(3) Cuando el valor mínimo actual en la cola es mayor que getmin, inserte directamente;
(4) Cuando se elimina el valor mínimo en la cola, la cola está vacía y se inserta directamente;
---------------ANALISIS DE COMPLEJIDA____________________________________
El algoritmo tiene una complejidad de O(N)
La complejidad temporal de este algoritmo es O(n log n), donde n es el número de
operaciones. Esto se debe a que cada operación tarda O(log n) en ejecutarse, ya 
que la clase priority_queue utiliza un montón binario como estructura de datos subyacente.
La complejidad espacial es O(n), porque las matrices str y str1 tienen un tamaño n.
   */
                
  
  ---------------------------------------------------------------------------------------------------------------------------------------
  
  
  EJERCICIO 9
  
  
  package Ejecicio9;


import java.util.*;
import java.io.*;
import java.math.*;
 
class Main{
    public static final int [] x8 = {0 , 1,1,1,0,-1,-1,-1};
    public static final int [] y8 = {-1,-1,0,1,1, 1, 0,-1};
    public static final int [] y4 = {0,1,0,-1};
    public static final int [] x4 = {1,0,-1,0};
    public static final int MOD = 1000000007;
    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        PrintWriter output = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //st = new StringTokenizer(buff.readLine());
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ok = 0;
        if( a == 1 ){
            if(b == 10 || b == 2){
                ok = 1;
            }
        }
        else if( a == 10 ){
            if(b == 9 || b == 1){
                ok = 1;
            }
        }
        else{
            if(b == (a-1) || b == (a+1)){
                ok = 1;
            }
        }
        output.print(ok == 1 ?"Yes":"No");
        output.flush();
    }
}

/*
El código comprueba si dos enteros a y b son números consecutivos. El programa utiliza varias bibliotecas
Java y define varias matrices y variables constantes, incluyendo una matriz x8 que contiene 8 elementos
que representan las 8 direcciones en una cuadrícula 2D, una matriz y8 que contiene 8 elementos que representan
las 8 direcciones en una cuadrícula 2D, una matriz y4 que contiene 4 elementos que representan las 4 direcciones
cardinales en una cuadrícula 2D, una matriz x4 que contiene 4 elementos que representan las 4 direcciones cardinales
en una cuadrícula 2D, una constante MOD igual a 1000000007, y una constante INF igual al valor máximo de un int en Java.
El programa declara varios objetos, incluyendo un PrintWriter llamado output, un Scanner llamado sc, un BufferedReader
llamado buff, y un StringTokenizer llamado st.
A continuación, el programa lee dos enteros, a y b, utilizando el objeto Scanner sc. El programa inicializa una variable 
ok a 0, que se utilizará para saber si a y b son números consecutivos.
A continuación, el programa comprueba si a y b son números consecutivos comparándolos con un conjunto de valores 
predeterminados. Si a es igual a 1, b debe ser 10 o 2 para que a y b se consideren números consecutivos. Si a es
igual a 10, b debe ser 9 o 1 para que a y b se consideren números consecutivos. En caso contrario, si a no es igual
a 1 ni a 10, b debe ser uno menos que a o uno más que a para que a y b se consideren números consecutivos. Si se
cumple alguna de estas condiciones, el programa establece el valor de ok en 1.
Finalmente, el programa utiliza la salida del objeto PrintWriter para imprimir "Sí" o "No" dependiendo del valor de ok.
La complejidad temporal de este algoritmo es O(1) porque el número de operaciones realizadas por el algoritmo
es constante y no depende del tamaño de la entrada.
*/
  
  
  
  
  
