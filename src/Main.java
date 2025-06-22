import controladora.Controladora;
import igu.VentanaPrincipal;
import logica.listados.ListadoStands;
import logica.listados.ListadoZonas;
import persistencia.ArchivosSerializados;
import persistencia.LecturaDeArchivosTXT;
import logica.gestion.Gestion;

import javax.swing.*;


public class Main{
    /**
     * Metodo principal del programa.
     * Verifica si hay que cargar datos desde txt o del serializado, y ejecuta la ventana principal
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        Gestion gestion = new Gestion();

        if (!ArchivosSerializados.archivosNoExisten()) {
            ArchivosSerializados.cargarDatos(gestion);
        }else {
            LecturaDeArchivosTXT lectura = new LecturaDeArchivosTXT();
            lectura.leeZonas(gestion);
            lectura.leePersonas(gestion);
            lectura.leeHabilitadas(gestion);
            lectura.leeAccesos(gestion);
            lectura.leeEventos(gestion);
            lectura.generaInformeDatos();
            gestion.guardarDatos();
        }
        ListadoZonas.generaArchivoListadoZonas(gestion);
        ListadoStands.generaArchivoListadoStands(gestion);

        Controladora controladora = new Controladora(gestion);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaPrincipal pantalla = new VentanaPrincipal(controladora);
                pantalla.setVisible(true);
                pantalla.setLocationRelativeTo(null);
            }
        });
        // actualiza los listados de zonas y stands al finalizar el programa
        //aunque los actualiza al consultar listados en pantalla si después de consultar se mueve
        //una persona de una zona a otra, garantiza que se actualizan los archivos

    }
}