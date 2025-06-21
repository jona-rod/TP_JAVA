package IGU;

import LOGICA.GESTION.Gestion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMuevePersona extends JFrame{
    private JPanel ventana_mueve_personas;
    private JTextArea area_texto_personas;
    private JTextField campoi_id_persona;
    private JTextField campor_id_zona;
    private JButton btn_mover;
    private JTextArea area_texto_zonas;

    public VentanaMuevePersona(Gestion gestion) {
        add(ventana_mueve_personas);
        this.setSize(1600, 900);

        area_texto_zonas.setText(gestion.muestraListadoZonasConPersonas());
        area_texto_zonas.setCaretPosition(0);
        area_texto_personas.setText(gestion.muestraListadoPersonas());
        area_texto_personas.setCaretPosition(0);



        btn_mover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gestion.muevePersona(campoi_id_persona.getText().toUpperCase().replaceAll("\\s+", ""), campor_id_zona.getText().toUpperCase().replaceAll("\\s+", ""));
                    JOptionPane.showMessageDialog(null, "Se realiza cambio de zona con exito");
                    area_texto_zonas.setText(gestion.muestraListadoZonasConPersonas());
                    area_texto_zonas.setCaretPosition(0);
                    area_texto_personas.setText(gestion.muestraListadoPersonas());
                    area_texto_personas.setCaretPosition(0);
                    gestion.guardarDatos();

                    }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    }finally {
                        gestion.guardarDatos();
                    }
                }
        });
    }
}
