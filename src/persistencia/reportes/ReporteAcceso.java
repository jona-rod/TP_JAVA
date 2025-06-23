package persistencia.reportes;

import java.io.*;

/**
 * clase que se encarga de crear un archivo de texto con los accesos que se hacen en el festival
 */
public class ReporteAcceso {
    /**
     * guarda el texto de los reportes de accesos
     */
    StringBuilder reporte;
    /**
     * guarda la ruta al archivo txt
     */
    private static final String rutaArchivo = "src/persistencia/archivos/reporteDeAccesos.txt";

    /**
     * constructor de la clase reporteAcceso
     * genera el reporte con los accesos que se van haciendo a las zonas, sean aceptados como denegados
     */

    public ReporteAcceso() {
        reporte = new StringBuilder();

        // Verifica si el archivo existe
        File archivo = new File(rutaArchivo);
        boolean archivoExiste = archivo.exists();

        // Si el archivo no existe, crea uno nuevo
        if (!archivoExiste) {
            reporte.append("-------- REPORTE DE ACCESOS --------").append("\n");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
                writer.write(reporte.toString());
            } catch (IOException e) {
                System.err.println("Error al generar el informe: " + e.getMessage());
            }
        } else {
            // carga el contenido del archivo existente al stringBuilder
            try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    reporte.append(linea).append("\n");
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo existente: " + e.getMessage());
            }
        }
    }

    /**
     * devuelve atributo reporte
     * @return Stringbuilder reporte
     */

    public StringBuilder getReporte() {
        return reporte;
    }

    /**
     * agrega un acceso al reporte, se utiliza en la clase Gestion
     * @param registro devuelve el registro si fue autorizado o no el acceso
     */
    public void agregaAcceso(String registro) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(registro);
            writer.newLine();
            reporte.append(registro);
        } catch (IOException e) {
            System.err.println("Error al registrar acceso: " + e.getMessage());
        }
    }

}
