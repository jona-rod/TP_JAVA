import IGU.VentanaPrincipal;
import LOGICA.ARCHIVOS.LecturaDeArchivosTXT;
import LOGICA.GESTION.Gestion;

import javax.swing.*;

/**
 * Clase principal de la aplicación que ejecuta el programa
 * @version 1.0
 */
public class Main{
    /**
     * Metodo principal del programa.
     * Verifica si hay que cargar datos desde txt o del serializado, y ejecuta la ventana principal
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        Gestion gestion = new Gestion();
        LecturaDeArchivosTXT lectura = new LecturaDeArchivosTXT();
        lectura.leeZonas(gestion);
        lectura.leePersonas(gestion);
        lectura.leeHabilitadas(gestion);
        lectura.leeAccesos(gestion);
        lectura.leeEventos(gestion);
        lectura.generaInformeDatos();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaPrincipal pantalla = new VentanaPrincipal(gestion);
                pantalla.setVisible(true);
                pantalla.setLocationRelativeTo(null);
            }
        });
    }
}