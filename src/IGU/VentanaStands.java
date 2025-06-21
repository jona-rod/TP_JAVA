package IGU;

import LOGICA.GESTION.Gestion;
import LOGICA.LISTADOS.ListadoStands;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaStands extends JFrame {
    private JPanel ventana_stands;
    private JTextField campos_id;
    private JButton btn_mostrar;
    private JButton btn_stands;
    private JTextArea area_texto_stands;

    public VentanaStands(Gestion gestion) {
        add(ventana_stands);
        this.setSize(1400, 900);

        ListadoStands listado = new ListadoStands();
        String list = listado.generarListado(gestion);
        area_texto_stands.setText(list);
        area_texto_stands.setCaretPosition(0);


        btn_mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = campos_id.getText().toUpperCase().replaceAll("\\s+", "");
                if(gestion.getConjuntoZonas().containsKey(id)){
                    area_texto_stands.setText(gestion.getConjuntoZonas().get(id).toString());
                }else
                    JOptionPane.showMessageDialog(VentanaStands.this, "ID INCORRECTO\nel stand seleccionada no existe");
            }
        });
        btn_stands.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area_texto_stands.setText(list);
            }
        });
    }

}
