package logica.listados;

import logica.gestion.Gestion;
import logica.zonas.Stand;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 * se encarga de generar un listado de stands que esten ordenados alfabeticamente por los nombres de los responsables de
 * los stands
 */
public class ListadoStands {
    /**
     * genera un listado de los stands ordenados alfábeticamente por los nombres de las personas responsables de
     * cada stand.Ordena usando el Comparator estático de Stand
     * @param gestion objeto Gestion
     * @return el texto con el listado de los stands ordenados alfabeticamente
     */
    public static String generarListado(Gestion gestion) {
        gestion.getListadoStands().sort(Stand.POR_RESPONSABLE);

        StringBuilder sb = new StringBuilder();
        for (Stand s : gestion.getListadoStands()) {
            sb.append(s.toString()).append("\n");
        }
        return sb.toString();
    }
    /**
     * genera un archivo con el listado de los stands ordenados alfabéticamente por los nombres de las personas responsables de
     * cada stand.Ordena usando el Comparator estático de Stand
     * @param gestion objeto Gestion
     */
    public static void generaArchivoListadoStands(Gestion gestion) {
        try{
            FileWriter file = new FileWriter("src//persistencia/archivos/listadoStands.txt");
            BufferedWriter writer = new BufferedWriter(file);
            writer.write(generarListado(gestion));
            writer.close();
        }catch(IOException e){
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}