package IGU;

import LOGICA.GESTION.Gestion;
import LOGICA.LISTADOS.ListadoStands;

import javax.swing.*;

public class VentanaStands extends JFrame {
    private JPanel ventana_stands;
    private JTextArea area_texto_stands;

    public VentanaStands(Gestion gestion) {
        add(ventana_stands);
        this.setSize(1300, 800);

        ListadoStands listado = new ListadoStands();

        area_texto_stands.setText(listado.generarListado(gestion));
    }

}
