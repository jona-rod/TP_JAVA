package LOGICA.REPORTES;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReporteDeDatos {
    private StringBuilder informe;
    public ReporteDeDatos(){
        informe = new StringBuilder("\tInforme de errores de datos cargados desde archivos");
    }
    public void agregaError(String error){
        informe.append("\n").append(error);
    }
    public void generaInforme(){
        try{
            FileWriter file = new FileWriter("src//LOGICA/ARCHIVOS/INFORME_De_Datos.txt");
            BufferedWriter writer = new BufferedWriter(file);
            writer.write(informe.toString());
            writer.close();
        }catch(IOException e){
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
