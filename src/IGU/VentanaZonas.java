package IGU;

import CONTROLADORA.Controladora;
import LOGICA.GESTION.Gestion;
import LOGICA.LISTADOS.ListadoZonas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaZonas extends JFrame {
    private JPanel ventana_zonas;
    private JTextField campos_texto_id;
    private JButton mostrarButton;
    private JButton zonasButton;
    private JTextArea area_texto_zonas;


    public VentanaZonas(Controladora controladora) {
        add(ventana_zonas);
        this.setSize(1400, 900);

        // 7 generaListadoZonas
        String list = controladora.generaListadoZonas();
        area_texto_zonas.setText(list); // var obtiene de 7
        area_texto_zonas.setCaretPosition(0);

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = campos_texto_id.getText().toUpperCase().replaceAll("\\s+", "");
                if(controladora.verificarZona(id)){ // 8  verifica zona
                    area_texto_zonas.setText(controladora.muestraZona(id)); //9 muestraZona
                }else
                    JOptionPane.showMessageDialog(VentanaZonas.this, "ID INCORRECTO\nla zona seleccionada no existe");
            }
        });
        zonasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area_texto_zonas.setText(list); // var obtiene de 7

            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
