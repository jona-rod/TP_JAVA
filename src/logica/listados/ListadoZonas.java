package logica.listados;

import logica.gestion.Gestion;
import logica.zonas.Zona;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

/**
 * se utiliza para generar un listado de zonas que este ordenado por la cantidad de personas que hay en cada zona, mostrando
 *  en el listado desde la zona que mas gente tiene a la zona que menos gente tiene
 */
public class ListadoZonas {

    /**
     * genera un listado con todas las zonas y los datos de cada una
     * @param gestion
     * @return el texto con el listado de todas las zonas
     */
    public String generaListado(Gestion gestion) {
        int cantPersonas = 0;

        Collections.sort(gestion.getListadoZonas()); // Usa compareTo de Zona

        StringBuilder sb = new StringBuilder();
        for (Zona z : gestion.getListadoZonas()) {
            sb.append(z.toString()).append("\n");
            cantPersonas += z.concurrencia();
        }
        sb.append("La cantidad de personas en el predio es: ").append(cantPersonas);

        try{
            FileWriter file = new FileWriter("src//persistencia/archivos/listadoZonas.txt");
            BufferedWriter writer = new BufferedWriter(file);
            writer.write(sb.toString());
            writer.close();
        }catch(IOException e){
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }

        return sb.toString();
    }

}