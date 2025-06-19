package IGU;

import LOGICA.GESTION.Gestion;
import LOGICA.LISTADOS.ListadoZonas;

import javax.swing.*;

public class VentanaZonas extends JFrame {
    private JPanel ventana_zonas;
    private JTextArea area_texto_zonas;


    public VentanaZonas(Gestion gestion) {
        add(ventana_zonas);
        this.setSize(1300, 800);

        ListadoZonas listado = new ListadoZonas();
        area_texto_zonas.setText(listado.generaListado(gestion));

    }


}
