package LOGICA.LISTADOS;

import LOGICA.GESTION.Gestion;
import LOGICA.ZONAS.Stand;

import java.util.Collections;



public class ListadoStands {
    public String generarListado(Gestion gestion) {
        // Ordena usando el Comparator estático de Stand
        gestion.getListadoStands().sort(Stand.POR_RESPONSABLE);

        StringBuilder sb = new StringBuilder("LISTADO DE STANDS:\n");
        for (Stand s : gestion.getListadoStands()) {
            sb.append(s.toString()).append("\n");
        }
        return sb.toString();
    }
}