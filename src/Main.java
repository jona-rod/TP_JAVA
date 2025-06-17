import LOGICA.ARCHIVOS.LecturaDeArchivosTXT;
import LOGICA.GESTION.Gestion;

import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    public static void main(String[] args) {

        Gestion gestion = new Gestion();
        LecturaDeArchivosTXT lectura = new LecturaDeArchivosTXT();
        lectura.leeZonas(gestion);

       lectura.leePersonas(gestion);
        lectura.generaInformeDatos();
        lectura.leePersonas(gestion);
        lectura.le
        System.out.println(gestion.getConjuntoZonas().get("CO01").toString());
       System.out.println(gestion.getConjuntoZonas().get("ST01").toString());
       System.out.println(gestion.getConjuntoZonas().get("ES04").toString());

    }
}