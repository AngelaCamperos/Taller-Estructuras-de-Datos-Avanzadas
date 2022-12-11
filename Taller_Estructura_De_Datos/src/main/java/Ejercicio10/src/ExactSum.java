import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class ExactSum {

    /**
     * Método main con la solución al problema número 10
     * del taller Estructuras de Datos Avanzadas
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt(); // Número de datos a generar (2 < n < 10000)
            GenerarDatos gen = new GenerarDatos();
            gen.generarDatos(n); //Genera los datos aleatoriamente
            int[] libros = new int[n];
            llenarArreglo(libros); //Lee los datos del archivo txt

            int l1=0, l2=0;
            int min = 1000001;
            int dinero = sc.nextInt(); //Dinero que tiene Peter para gastar en 2 libros (<1000001)

            for (int i=0; i<n; i++) {
                int tmp = dinero - libros[i];
                for (int j=i+1; j<n; j++) {
                    if (tmp-libros[j] == 0) {
                        int dif = Math.abs(libros[i]-libros[j]);
                        if (min > dif) {
                            min = dif;
                            if (libros[i] > libros[j]) {
                                l1 = j;
                                l2 = i;
                            } else {
                                l1 = i;
                                l2 = j;
                            }
                        }
                        break;
                    }
                }
            }

            String salida = "Peter should buy books whose prices are "+libros[l1]+" and "+libros[l2]+"\n\n";
            System.out.printf(salida);
            gen.generarDatosSalida(salida);
        }
    }

    /**
     * Método que recive datos de un archivo txt y los guarda en un arreglo
     * @param arr Arreglo en el cual se guardarán los datos
     * @return Un arreglo con los datos guardados
     */
    static int[] llenarArreglo(int arr[]) {
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