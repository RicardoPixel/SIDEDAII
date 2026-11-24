package main;

import controlador.ControladorPrincipal;
import modelo.SistemaModelo;
import vista.VistaMenuDidactico;
import vista.VistaPrincipal;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SistemaModelo modelo = new SistemaModelo();
            VistaPrincipal vistaPrincipal = new VistaPrincipal();
            VistaMenuDidactico vistaMenu = new VistaMenuDidactico();
            ControladorPrincipal controlador = new ControladorPrincipal(modelo, vistaPrincipal, vistaMenu);
            controlador.iniciar();
        });
    }
}