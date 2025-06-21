package logica.reportes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * clase que se encarga de crear un archivo de texto con los accesos que se hacen en el festival
 */
public class ReporteAcceso {
    /**
     * guarda el texto de los reportes de accesos
     */
    StringBuilder reporte;
    /**
     *
     */
    private static final String rutaArchivo = "src/persistencia/archivos/reporteDeAccesos.txt";

    /**
     * constructor de la clase reporteAcceso
     * genera el reporte con los accesos que se van haciendo a las zonas, sean aceptados como denegados
     */
    public ReporteAcceso() {
        reporte = new StringBuilder();
        reporte.append("-------- REPORTE DE ACCESOS --------").append("\n");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write(reporte.toString());
        } catch (IOException e) {
            System.err.println("Error al generar el informe: " + e.getMessage());
        }
    }

    public StringBuilder getReporte() {
        return reporte;
    }

    /**
     * agrega un acceso al reporte, se utiliza en la clase Gestion
     * @param registro
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
