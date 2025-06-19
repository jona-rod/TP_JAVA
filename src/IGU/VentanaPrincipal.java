package IGU;

import LOGICA.GESTION.Gestion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JPanel ventana_principal;
    private JButton btn_consultar;
    private JButton btn_mover;
    private JButton btn_mostrarZonas;
    private JButton btn_mostrarStands;
    private JPanel principalWest;
    private JPanel principalEast;

    public VentanaPrincipal(Gestion gestion) {

        add(ventana_principal);
        this.setSize(1300, 800);

        btn_consultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        VentanaPersona ventanaPersona = new VentanaPersona(gestion);
                        ventanaPersona.setVisible(true);
                        ventanaPersona.setLocationRelativeTo(null);
                    }
                });

            }
        });
        btn_mover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        VentanaMuevePersona ventanaMuevePersona = new VentanaMuevePersona(gestion);
                        ventanaMuevePersona.setVisible(true);
                        ventanaMuevePersona.setLocationRelativeTo(null);
                    }
                });

            }
        });
        btn_mostrarZonas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        VentanaZonas ventanaZonas = new VentanaZonas(gestion);
                        ventanaZonas.setVisible(true);
                        ventanaZonas.setLocationRelativeTo(null);
                    }
                });

            }
        });
        btn_mostrarStands.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        VentanaStands ventanaStands = new VentanaStands(gestion);
                        ventanaStands.setVisible(true);
                        ventanaStands.setLocationRelativeTo(null);
                    }
                });



            }
        });
    }
}
