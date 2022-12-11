
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Ejercicio9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> l = new HashSet<Integer>();
        GenerarDatos g = new GenerarDatos();
        g.generarDatos(n);
        int[] numeros= new int[n];
        llenarArreglo(numeros);
        for (int i = 0; i < numeros.length; i++) {
            l.add(numeros[i]);
        }
        System.out.println(l.size());
    }

    public static int[] llenarArreglo(int arr[]) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File("datos.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            int j = 0;
            while ((linea = br.readLine()) != null) {
                arr[j] = Integer.parseInt(linea);
                j++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return arr;
    }
}

