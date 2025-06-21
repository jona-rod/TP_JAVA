package IGU;

import CONTROLADORA.Controladora;
import LOGICA.GESTION.Gestion;
import LOGICA.LISTADOS.ListadoStands;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * clase de la  ventana Stands, su funcion es mostrar el listado de los stands con sus datos
 * Utiliza la biblioteca swing para generar la interfaz
 * Extiende de {@link JFrame}
 * Esta clase otorga funciones y operaciones de clase controladora
 *
 * @see JFrame
 */
public class VentanaStands extends JFrame {
    private JPanel ventana_stands;
    private JTextField campos_id;
    private JButton btn_mostrar;
    private JButton btn_stands;
    private JTextArea area_texto_stands;
    /**
     * Constructor de la Clase, genera una ventana en la que se muestran los datos de todos los stands que hay en el festival
     * @param controladora
     */
    public VentanaStands(Controladora controladora) {
        add(ventana_stands);
        this.setSize(1400, 900);

        //10 generaListadoStands
        String list = controladora.generaListadoStands();
        area_texto_stands.setText(list); // var obtierne de 10
        area_texto_stands.setCaretPosition(0);


        btn_mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = campos_id.getText().toUpperCase().replaceAll("\\s+", "");
                if(controladora.verificarZona(id)){  //8
                    area_texto_stands.setText(controladora.muestraZona(id)); //9
                }else
                    JOptionPane.showMessageDialog(VentanaStands.this, "ID INCORRECTO\nel stand seleccionada no existe");
            }
        });
        btn_stands.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area_texto_stands.setText(list); // var obtiene de 10
            }
        });
    }

}
