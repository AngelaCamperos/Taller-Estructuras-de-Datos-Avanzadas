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
