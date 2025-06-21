package LOGICA.LISTADOS;

import LOGICA.GESTION.Gestion;
import LOGICA.ZONAS.Stand;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;


/**
 * se encarga de generar un listado de stands que esten ordenados alfabeticamente por los nombres de los responsables de
 * los stands
 */
public class ListadoStands {
    /**
     * genera un listado de los stands enstando ardenados al ¿fabeticamente por los nombres de las personas responsables de
     * cada stand,Ordena usando el Comparator estático de Stand
     * @param gestion
     * @return el texto con el listado de los stands ordenados alfabeticamente
     */
    public String generarListado(Gestion gestion) {
        gestion.getListadoStands().sort(Stand.POR_RESPONSABLE);

        StringBuilder sb = new StringBuilder("LISTADO DE STANDS:\n");
        for (Stand s : gestion.getListadoStands()) {
            sb.append(s.toString()).append("\n");
        }
        try{
            FileWriter file = new FileWriter("src//LOGICA/ARCHIVOS/listadoStands.txt");
            BufferedWriter writer = new BufferedWriter(file);
            writer.write(sb.toString());
            writer.close();
        }catch(IOException e){
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }

        return sb.toString();
    }
}