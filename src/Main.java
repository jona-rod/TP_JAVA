import LOGICA.ARCHIVOS.LecturaDeArchivosTXT;
import LOGICA.GESTION.Gestion;
import LOGICA.ZONAS.Zona;

import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    public static void main(String[] args) {

        Gestion gestion = new Gestion();
        LecturaDeArchivosTXT lectura = new LecturaDeArchivosTXT();
        lectura.leeZonas(gestion);
        lectura.leePersonas(gestion);
        lectura.leeHabilitadas(gestion);
        lectura.leeAccesos(gestion);
        lectura.leeEventos(gestion);
        lectura.generaInformeDatos();
        System.out.println("\nMUESTRA ZONA CO01.................................");
        System.out.println(gestion.getConjuntoZonas().get("CO01").toString());
        System.out.println("\nMUESTRA ZONA CO03.................................");
        System.out.println(gestion.getConjuntoZonas().get("CO03").toString());

        gestion.muevePersona("PUB001","CO04"); //no tiene autorizacion

        gestion.muevePersona("PUB001","CO03"); // tiene autorizacion

        System.out.println("\nDATOS DE PERSONA...................................");
        System.out.println(gestion.getListadoPersonas().get("PUB001").toString());

        System.out.println("\nMUESTRA ZONA CO01 MODIFICADA.................................");
        System.out.println(gestion.getConjuntoZonas().get("CO01").toString());
        System.out.println("\nMUESTRA ZONA CO03 MODIFICADA.................................");
        System.out.println(gestion.getConjuntoZonas().get("CO03").toString() + "\n");

        System.out.println("\nMUESTRA DATOS PERSONA .................................");
        System.out.println(gestion.getListadoPersonas().get("PUB001").toString());
        System.out.println("\nMUESTRA LISTA ZONAS AUTORIZADAS .................................");
        System.out.println(gestion.getListadoPersonas().get("PUB001").muestraListaZonasAutorizadasPersona());

    }
}