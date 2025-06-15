package LOGICA.ARCHIVOS;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class informeDeDatos {
    private StringBuilder informe;
    public informeDeDatos(){
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
