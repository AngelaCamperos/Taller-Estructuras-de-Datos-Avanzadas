import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class GenerarDatos {

    /**
     * Método que genera un archivo txt con los datos de prueba
     * @param n Cantidad de Datos de prueba a generar
     */
    public void generarDatos(int n) {
        try {
            String ruta = "datos.txt";
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i=0; i<n; i++) {
                int valorEntero = (int) Math.floor(Math.random() * (1000 - 0 + 1) + 0);
                bw.write(String.valueOf(valorEntero));
                if(1 != n-1) {
                    bw.write("\n");
                }
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que genera un archivo txt con la salida del programa
     * @param cadena Salida que se imprimira en el archivo txt
     */
    public void generarDatosSalida(String cadena) {
        try {
            String ruta = "datosSalida.txt";
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(cadena);
            bw.write("\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
