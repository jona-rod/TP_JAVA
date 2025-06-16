package LOGICA.LISTADOS;

import LOGICA.GESTION.Gestion;
import LOGICA.ZONAS.Zona;

import java.util.Collections;

public class ListadoZonas {

    public String generarListado(Gestion gestion) {
        int cantPersonas = 0;

        Collections.sort(gestion.getListadoZonas()); // Usa compareTo de Zona

        StringBuilder sb = new StringBuilder("LISTADO DE ZONAS:\n");
        for (Zona z : gestion.getListadoZonas()) {
            sb.append(z.toString()).append("\n");
            cantPersonas += z.concurrencia();
        }

        sb.append("La cantidad de personas en el predio es: ").append(cantPersonas);
        return sb.toString();
    }

}