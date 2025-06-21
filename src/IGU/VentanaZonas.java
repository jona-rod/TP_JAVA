package IGU;

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


    public VentanaZonas(Gestion gestion) {
        add(ventana_zonas);
        this.setSize(1400, 900);

        ListadoZonas listado = new ListadoZonas();
        String list = listado.generaListado(gestion);
        area_texto_zonas.setText(list);
        area_texto_zonas.setCaretPosition(0);

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = campos_texto_id.getText().toUpperCase().replaceAll("\\s+", "");
                if(gestion.getConjuntoZonas().containsKey(id)){
                    area_texto_zonas.setText(gestion.getConjuntoZonas().get(id).toString());
                }else
                    JOptionPane.showMessageDialog(VentanaZonas.this, "ID INCORRECTO\nla zona seleccionada no existe");
            }
        });
        zonasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area_texto_zonas.setText(list);

            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
