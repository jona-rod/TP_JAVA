package IGU;

import CONTROLADORA.Controladora;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * clase de la  ventana principal, muestra cuatro botones, listado personas, listado zonas, mueve persona, listado stands
 * Utiliza la biblioteca swing para generar la interfaz
 * Extiende de {@link JFrame}
 * Esta clase otorga funciones y operaciones de clase controladora
 *
 * @see JFrame
 */
public class VentanaPrincipal extends JFrame {
    private JPanel ventana_principal;
    private JButton btn_consultar;
    private JButton btn_mover;
    private JButton btn_mostrarZonas;
    private JButton btn_mostrarStands;
    private JPanel principalWest;
    private JPanel principalEast;
    /**
     * Constructor de la clase, inicializa los componentes de la Interfaz Gráfica
     * @param controladora Objeto de la clase {@link Controladora} que conecta con la clase gestion que gestiona los datos de los artistas
     */
    public VentanaPrincipal(Controladora controladora) {

        add(ventana_principal);
        this.setSize(1400, 900);

        btn_consultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        VentanaPersona ventanaPersona = new VentanaPersona(controladora);
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
                        VentanaMuevePersona ventanaMuevePersona = new VentanaMuevePersona(controladora);
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
                        VentanaZonas ventanaZonas = new VentanaZonas(controladora);
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
                        VentanaStands ventanaStands = new VentanaStands(controladora);
                        ventanaStands.setVisible(true);
                        ventanaStands.setLocationRelativeTo(null);
                    }
                });



            }
        });

        //Termina el programa al cerrar la ventana principal
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


}
