package logica.reportes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * genera un reporte con los errores que puede haber en la carga de datos, o excepciones que pueden tener.
 */
public class ReporteDeDatos {
    /**
     * guarda el texto del informe de los datos
     */
    private StringBuilder informe;

    /**
     * constructor de la clase reporteDeDatos
     * carga en informe un titulo para el reporte
     */
    public ReporteDeDatos(){
        informe = new StringBuilder("\tInforme de errores de datos cargados desde archivos");
    }

    /**
     * agrega un error al texto del informe el cual es recibido como parametro
     * @param error
     */
    public void agregaError(String error){
        informe.append("\n").append(error);
    }

    /**
     * genera un archivo de texto, que contenga todos los posibles errores en la carga de datos
     */
    public void generaInforme(){
        try{
            FileWriter file = new FileWriter("src//persistencia/archivos/INFORME_De_Datos.txt");
            BufferedWriter writer = new BufferedWriter(file);
            writer.write(informe.toString());
            writer.close();
        }catch(IOException e){
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
