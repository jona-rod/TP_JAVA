package IGU;

import LOGICA.GESTION.Gestion;

import javax.swing.*;

public class VentanaMuevePersona extends JFrame{
    private JPanel ventana_mueve_personas;
    private JTextPane textPane1;
    private JTextPane area_texto_zonas;
    private JTextArea textArea1;
    private JTextArea area_texto_personas;
    private JTextField campoi_id_persona;
    private JTextField campor_id_zona;
    private JButton btn_mover;

    public VentanaMuevePersona(Gestion gestion) {
        add(ventana_mueve_personas);
        this.setSize(1300, 800);
    }
}
