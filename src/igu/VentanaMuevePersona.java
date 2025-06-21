package igu;

import controladora.Controladora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * clase de la  ventana mueve persona
 * Utiliza la biblioteca swing para generar la interfaz
 *   Extiende de {@link JFrame}
 *  Esta clase otorga funciones y operaciones de clase controladora
 *
 *  @see JFrame
 */
public class VentanaMuevePersona extends JFrame{
    private JPanel ventana_mueve_personas;
    private JTextArea area_texto_personas;
    private JTextField campoi_id_persona;
    private JTextField campor_id_zona;
    private JButton btn_mover;
    private JTextArea area_texto_zonas;

    /**
     * Constructor de la Clase, genera una ventana en la que se muestran los datos de las personas y los datos de las zonas,
     * teniendo un boton desplegable para poner un id de persona y un id de zona para mover a esa persona
     * @param controladora
     */
    public VentanaMuevePersona(Controladora controladora) {
        add(ventana_mueve_personas);
        this.setSize(1600, 900);

        area_texto_zonas.setText(controladora.muestraListadoZonasConPersonas()); // 4 muestraListadoZonasSoloPersonas
        area_texto_zonas.setCaretPosition(0);
        area_texto_personas.setText(controladora.muestraListadoPersonas()); // 1
        area_texto_personas.setCaretPosition(0);



        btn_mover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controladora.muevePersona(campoi_id_persona.getText().toUpperCase().replaceAll("\\s+", ""), campor_id_zona.getText().toUpperCase().replaceAll("\\s+", ""));  // 5 muevePersona
                    JOptionPane.showMessageDialog(null, "Se realiza cambio de zona con exito");
                    area_texto_zonas.setText(controladora.muestraListadoZonasConPersonas()); //4
                    area_texto_zonas.setCaretPosition(0);
                    area_texto_personas.setText(controladora.muestraListadoPersonas()); //1
                    area_texto_personas.setCaretPosition(0);
                    }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    }finally {
                        controladora.guardaDatos(); //6 guardaDatos
                    }
                }
        });
    }
}
