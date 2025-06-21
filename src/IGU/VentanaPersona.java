package IGU;

import CONTROLADORA.Controladora;
import LOGICA.GESTION.Gestion;
import LOGICA.PERSONAS.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * clase de la  ventana persona, sun funcion es mostrar el listado de las personas con sus datos
 * Utiliza la biblioteca swing para generar la interfaz
 * Extiende de {@link JFrame}
 * Esta clase otorga funciones y operaciones de clase controladora
 *
 * @see JFrame
 */

public class VentanaPersona extends JFrame {
    private JPanel ventana_persona;
    private JTextField campo_id;
    private JButton btn_mostrar;
    private JButton btn_personas;
    private JTextArea area_texto_persona;

    /**
     * Constructor de la Clase, genera una ventana en la que se muestran los datos de todas las personas que hay en el festival
     * @param controladora
     */
    public VentanaPersona(Controladora controladora) {
        add(ventana_persona);
        this.setSize(1400, 900);


        area_texto_persona.setText(controladora.muestraListadoPersonas());// 1 listadoPersonas
        area_texto_persona.setCaretPosition(0);


        btn_mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String persona = campo_id.getText().toUpperCase().replaceAll("\\s+", "");
                if(controladora.verificarPersona(persona)) { // 2 verificaPersona
                    area_texto_persona.setText(controladora.muestraPersona(persona)); // 3 muestraPersona
                    area_texto_persona.setCaretPosition(0);
                }else{
                    JOptionPane.showMessageDialog(VentanaPersona.this, "ID INCORRECTO\nla persona seleccionada no existe");
                }


            }
        });
        btn_personas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area_texto_persona.setText(controladora.muestraListadoPersonas()); //1
                area_texto_persona.setCaretPosition(0);
            }
        });
    }
}
