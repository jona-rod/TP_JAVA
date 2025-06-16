package LOGICA.REPORTES;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReporteAcceso {

    StringBuilder reporte;
    private static final String rutaArchivo = "src/Archivos/INFORME_Consistencia_de_Datos.txt";

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
