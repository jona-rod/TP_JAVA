package IGU;

import LOGICA.GESTION.Gestion;
import LOGICA.PERSONAS.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPersona extends JFrame {
    private JPanel ventana_persona;
    private JTextField campo_id;
    private JButton btn_mostrar;
    private JButton btn_personas;
    private JTextArea area_texto_persona;

    public VentanaPersona(Gestion gestion) {
        add(ventana_persona);
        this.setSize(1400, 900);


        area_texto_persona.setText(gestion.muestraListadoPersonas());
        area_texto_persona.setCaretPosition(0);


        btn_mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String persona = campo_id.getText().toUpperCase().replaceAll("\\s+", "");
                if(gestion.getListadoPersonas().get(persona) != null) {
                    area_texto_persona.setText(gestion.getListadoPersonas().get(persona).toString());
                    area_texto_persona.setCaretPosition(0);
                }else{
                    JOptionPane.showMessageDialog(VentanaPersona.this, "ID INCORRECTO\nla persona seleccionada no existe");
                }


            }
        });
        btn_personas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area_texto_persona.setText(gestion.muestraListadoPersonas());
                area_texto_persona.setCaretPosition(0);
            }
        });
    }
}
