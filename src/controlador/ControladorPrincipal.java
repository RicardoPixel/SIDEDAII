package controlador;

import modelo.SistemaModelo;
import vista.VistaMenuDidactico;
import vista.VistaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControladorPrincipal implements ActionListener {
    private SistemaModelo modelo;
    private VistaPrincipal vistaPrincipal;
    private VistaMenuDidactico vistaMenu;

    public ControladorPrincipal(SistemaModelo modelo, VistaPrincipal vistaPrincipal, VistaMenuDidactico vistaMenu) {
        this.modelo = modelo;
        this.vistaPrincipal = vistaPrincipal;
        this.vistaMenu = vistaMenu;

        this.vistaPrincipal.btnIngresar.addActionListener(this);
        this.vistaMenu.btnVolverPrincipal.addActionListener(this);
        configurarEventosMenu();
    }

    private void configurarEventosMenu() {
        this.vistaMenu.btnComplejidad.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                vistaMenu.mostrarColumnasComplejidad(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                vistaMenu.mostrarColumnasComplejidad(false);
            }
        });

        this.vistaMenu.btnProblemas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                vistaMenu.mostrarColumnasProblemas(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                vistaMenu.mostrarColumnasProblemas(false);
            }
        });

        this.vistaMenu.btnGrafos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                vistaMenu.mostrarColumnasGrafos(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                vistaMenu.mostrarColumnasGrafos(false);
            }
        });
    }

    public void iniciar() {
        vistaPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (fuente == vistaPrincipal.btnIngresar) {
            vistaPrincipal.setVisible(false);
            vistaMenu.setVisible(true);
        } else if (fuente == vistaMenu.btnVolverPrincipal) {
            vistaMenu.ocultarTodosLosSubmenus();
            vistaMenu.setVisible(false);
            vistaPrincipal.setVisible(true);
        }
    }
}
