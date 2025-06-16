package LOGICA.LISTADOS;

import LOGICA.GESTION.Gestion;
import LOGICA.ZONAS.Zona;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

public class ListadoZonas {

    public String generaListado(Gestion gestion) {
        int cantPersonas = 0;

        Collections.sort(gestion.getListadoZonas()); // Usa compareTo de Zona

        StringBuilder sb = new StringBuilder("LISTADO DE ZONAS:\n");
        for (Zona z : gestion.getListadoZonas()) {
            sb.append(z.toString()).append("\n");
            cantPersonas += z.concurrencia();
        }
        sb.append("La cantidad de personas en el predio es: ").append(cantPersonas);

        try{
            FileWriter file = new FileWriter("src//LOGICA/ARCHIVOS/listadoZonas.txt");
            BufferedWriter writer = new BufferedWriter(file);
            writer.write(sb.toString());
            writer.close();
        }catch(IOException e){
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }

        return sb.toString();
    }

}