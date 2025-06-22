package logica.listados;

import logica.gestion.Gestion;
import logica.zonas.Zona;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

/**
 * se utiliza para generar un listado de zonas que esté ordenado por la cantidad de personas que hay en cada zona, mostrando
 *  en el listado desde la zona que más gente tiene a la zona que menos gente tiene
 */
public class ListadoZonas {

    /**
     * genera un listado con las zonas y los datos de cada una
     * @param gestion objeto Gestion
     * @return String con el listado de todas las zonas
     */
    public static String generaListado(Gestion gestion) {
        int cantPersonas = 0;

        Collections.sort(gestion.getListadoZonas()); // Usa compareTo de Zona

        StringBuilder sb = new StringBuilder();
        for (Zona z : gestion.getListadoZonas()) {
            sb.append(z.toString()).append("\n");
            cantPersonas += z.concurrencia();
        }
        sb.append("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n"+
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n");
        sb.append("Personas en zonas : " + cantPersonas + "\n\n");
        int cantPersonasPredio = gestion.getListadoPersonas().size();
        sb.append("Personas en stands : " + (cantPersonasPredio - cantPersonas) + "\n\n");
        sb.append("Total de personas en el predio : ").append(cantPersonasPredio).append("\n\n");

        return sb.toString();
    }
    /**
     * genera un archivo con las zonas y los datos de cada una
     * @param gestion objeto Gestion
     */
    public static void generaArchivoListadoZonas(Gestion gestion) {
        try{
            FileWriter file = new FileWriter("src//persistencia/archivos/listadoZonas.txt");
            BufferedWriter writer = new BufferedWriter(file);
            writer.write(generaListado(gestion));
            writer.close();
        }catch(IOException e){
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}