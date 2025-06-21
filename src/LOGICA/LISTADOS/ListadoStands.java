package LOGICA.LISTADOS;

import LOGICA.GESTION.Gestion;
import LOGICA.ZONAS.Stand;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;



public class ListadoStands {
    public String generarListado(Gestion gestion) {
        // Ordena usando el Comparator estático de Stand
        gestion.getListadoStands().sort(Stand.POR_RESPONSABLE);

        StringBuilder sb = new StringBuilder();
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