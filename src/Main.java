import CONTROLADORA.Controladora;
import IGU.VentanaPrincipal;
import LOGICA.ARCHIVOS.ArchivosSerializados;
import LOGICA.ARCHIVOS.LecturaDeArchivosTXT;
import LOGICA.GESTION.Gestion;

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

        Controladora controladora = new Controladora(gestion);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaPrincipal pantalla = new VentanaPrincipal(controladora);
                pantalla.setVisible(true);
                pantalla.setLocationRelativeTo(null);
            }
        });
    }
}