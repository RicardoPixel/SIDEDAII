package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class VistaMenuDidactico extends JFrame {

    public JButton btnEficiencia;
    public JButton btnComplejidad;
    public JButton btnProblemas;
    public JButton btnGrafos;
    public JButton btnVolverPrincipal;

    private JPanel panelSimulacion;
    private JLabel lblTituloSimulacion;
    private JPanel panelColumnasComplejidad;
    private JPanel panelColumnasProblemas;
    private JPanel panelColumnasGrafos;

    public VistaMenuDidactico() {
        setTitle("SIDEDAII - Menú Didáctico");
        setSize(980, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(VistaPrincipal.AZUL_EPN);
        panelSuperior.setBorder(new MatteBorder(0, 0, 4, 0, VistaPrincipal.ROJO_EPN));

        JLabel lblInstitucion = new JLabel("ESCUELA POLITÉCNICA NACIONAL", SwingConstants.CENTER);
        lblInstitucion.setForeground(VistaPrincipal.BLANCO);
        lblInstitucion.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblInstitucion.setBorder(new EmptyBorder(14, 15, 14, 15));
        panelSuperior.add(lblInstitucion, BorderLayout.CENTER);
        add(panelSuperior, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel(new BorderLayout(15, 0));
        panelCentro.setBackground(new Color(238, 240, 243));
        panelCentro.setBorder(new EmptyBorder(15, 15, 15, 15));

        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));
        panelMenu.setBackground(new Color(225, 228, 232));
        panelMenu.setPreferredSize(new Dimension(275, 0));
        panelMenu.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(195, 200, 206), 1),
                new EmptyBorder(16, 15, 16, 15)
        ));

        JLabel lblMenuTitulo = new JLabel("MENÚ DIDÁCTICO", SwingConstants.CENTER);
        lblMenuTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblMenuTitulo.setForeground(VistaPrincipal.AZUL_EPN);
        lblMenuTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnEficiencia = crearBotonMenu("1. Eficiencia Algorítmica", VistaPrincipal.ROJO_EPN);
        btnComplejidad = crearBotonMenu("2. Análisis de Complejidad Algorítmica", VistaPrincipal.ROJO_EPN);
        btnProblemas = crearBotonMenu("3. Problemas de Complejidad", VistaPrincipal.ROJO_EPN);
        btnGrafos = crearBotonMenu("4. Grafos", VistaPrincipal.ROJO_EPN);
        btnVolverPrincipal = crearBotonMenu("Volver a la Pantalla Principal", VistaPrincipal.AZUL_EPN);

        panelMenu.add(lblMenuTitulo);
        panelMenu.add(Box.createRigidArea(new Dimension(0, 18)));
        panelMenu.add(btnEficiencia);
        panelMenu.add(Box.createRigidArea(new Dimension(0, 12)));
        panelMenu.add(btnComplejidad);
        panelMenu.add(Box.createRigidArea(new Dimension(0, 12)));
        panelMenu.add(btnProblemas);
        panelMenu.add(Box.createRigidArea(new Dimension(0, 12)));
        panelMenu.add(btnGrafos);
        panelMenu.add(Box.createVerticalGlue());
        panelMenu.add(btnVolverPrincipal);

        panelCentro.add(panelMenu, BorderLayout.WEST);

        panelSimulacion = new JPanel(new BorderLayout(10, 10));
        panelSimulacion.setBackground(VistaPrincipal.BLANCO);
        panelSimulacion.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(195, 200, 206), 1),
                new EmptyBorder(18, 20, 18, 20)
        ));

        lblTituloSimulacion = new JLabel("ÁREA DE SIMULACIÓN", SwingConstants.CENTER);
        lblTituloSimulacion.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTituloSimulacion.setForeground(VistaPrincipal.AZUL_EPN);
        panelSimulacion.add(lblTituloSimulacion, BorderLayout.NORTH);

        panelColumnasComplejidad = crearPanelColumnasComplejidad();
        panelColumnasComplejidad.setVisible(false);

        panelColumnasProblemas = crearPanelColumnasProblemas();
        panelColumnasProblemas.setVisible(false);

        panelColumnasGrafos = crearPanelColumnasGrafos();
        panelColumnasGrafos.setVisible(false);

        JPanel contenedorSubmenus = new JPanel(new CardLayout());
        contenedorSubmenus.setOpaque(false);
        contenedorSubmenus.add(panelColumnasComplejidad, "COMPLEJIDAD");
        contenedorSubmenus.add(panelColumnasProblemas, "PROBLEMAS");
        contenedorSubmenus.add(panelColumnasGrafos, "GRAFOS");

        panelSimulacion.add(contenedorSubmenus, BorderLayout.CENTER);
        panelCentro.add(panelSimulacion, BorderLayout.CENTER);
        add(panelCentro, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.setBackground(VistaPrincipal.AZUL_EPN);
        panelInferior.setBorder(new MatteBorder(4, 0, 0, 0, VistaPrincipal.ROJO_EPN));

        JLabel lblFacultad = new JLabel("FACULTAD DE INGENIERÍA EN SISTEMAS", SwingConstants.CENTER);
        lblFacultad.setForeground(VistaPrincipal.BLANCO);
        lblFacultad.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblFacultad.setBorder(new EmptyBorder(14, 15, 14, 15));
        panelInferior.add(lblFacultad, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    public void mostrarColumnasComplejidad(boolean visible) {
        ocultarTodosLosSubmenus();
        panelColumnasComplejidad.setVisible(visible);
        refrescarSimulacion();
    }

    public void mostrarColumnasProblemas(boolean visible) {
        ocultarTodosLosSubmenus();
        panelColumnasProblemas.setVisible(visible);
        refrescarSimulacion();
    }

    public void mostrarColumnasGrafos(boolean visible) {
        ocultarTodosLosSubmenus();
        panelColumnasGrafos.setVisible(visible);
        refrescarSimulacion();
    }

    public void ocultarTodosLosSubmenus() {
        panelColumnasComplejidad.setVisible(false);
        panelColumnasProblemas.setVisible(false);
        panelColumnasGrafos.setVisible(false);
        refrescarSimulacion();
    }

    private void refrescarSimulacion() {
        panelSimulacion.revalidate();
        panelSimulacion.repaint();
    }

    private JButton crearBotonMenu(String texto, Color colorFondo) {
        JButton boton = new JButton("<html><div style='text-align:center;'>" + texto + "</div></html>");
        boton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        boton.setBackground(colorFondo);
        boton.setForeground(VistaPrincipal.BLANCO);
        boton.setFocusPainted(false);
        boton.setContentAreaFilled(true);
        boton.setOpaque(true);
        boton.setBorder(new EmptyBorder(11, 12, 11, 12));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 54));
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        return boton;
    }

    private JPanel crearPanelColumnasComplejidad() {
        JPanel contenedor = new JPanel(new GridLayout(1, 3, 14, 0));
        contenedor.setBackground(VistaPrincipal.AZUL_EPN);
        contenedor.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(VistaPrincipal.ROJO_EPN, 2),
                new EmptyBorder(18, 16, 18, 16)
        ));

        contenedor.add(crearColumna(
                "CASOS DE ANÁLISIS",
                new String[]{"• Peor caso", "• Mejor caso", "• Caso promedio"}
        ));
        contenedor.add(crearColumna(
                "NOTACIONES",
                new String[]{"• Big-O (O)", "• Big-Omega (Ω)", "• Big-Theta (Θ)"}
        ));
        contenedor.add(crearColumna(
                "CLASES COMUNES",
                new String[]{"• Constante O(1)", "• Logarítmica O(log n)", "• Lineal O(n)", "• Cuadrática O(n²)", "• Exponencial O(2ⁿ)"}
        ));

        return contenedor;
    }

    private JPanel crearPanelColumnasProblemas() {
        JPanel contenedor = new JPanel(new GridLayout(1, 2, 14, 0));
        contenedor.setBackground(VistaPrincipal.AZUL_EPN);
        contenedor.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(VistaPrincipal.ROJO_EPN, 2),
                new EmptyBorder(18, 16, 18, 16)
        ));

        contenedor.add(crearColumna(
                "CLASES TRATABLES Y VERIFICACIÓN",
                new String[]{"• Problemas P", "• Problemas NP"}
        ));
        contenedor.add(crearColumna(
                "DIFICULTAD Y COMPLETITUD",
                new String[]{"• Problemas NP-Hard", "• Problemas NP-Complete"}
        ));

        return contenedor;
    }

    private JPanel crearPanelColumnasGrafos() {
        JPanel contenedor = new JPanel(new GridLayout(1, 2, 14, 0));
        contenedor.setBackground(VistaPrincipal.AZUL_EPN);
        contenedor.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(VistaPrincipal.ROJO_EPN, 2),
                new EmptyBorder(18, 16, 18, 16)
        ));

        contenedor.add(crearColumna(
                "ORDENAMIENTO Y RUTAS",
                new String[]{"• Orden Topológico", "• TSM", "• Dijkstra"}
        ));
        contenedor.add(crearColumna(
                "ÁRBOLES DE EXPANSIÓN Y RECORRIDO",
                new String[]{"• PRIM", "• Kahn", "• Kruskal"}
        ));

        return contenedor;
    }

    private JPanel crearColumna(String titulo, String[] items) {
        JPanel col = new JPanel();
        col.setLayout(new BoxLayout(col, BoxLayout.Y_AXIS));
        col.setBackground(new Color(10, 56, 110));
        col.setBorder(new EmptyBorder(12, 12, 12, 12));

        JLabel lblCol = new JLabel(titulo);
        lblCol.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblCol.setForeground(VistaPrincipal.BLANCO);
        lblCol.setAlignmentX(Component.LEFT_ALIGNMENT);
        col.add(lblCol);
        col.add(Box.createRigidArea(new Dimension(0, 10)));

        for (String item : items) {
            JLabel lblItem = new JLabel(item);
            lblItem.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            lblItem.setForeground(new Color(235, 240, 245));
            lblItem.setAlignmentX(Component.LEFT_ALIGNMENT);
            col.add(lblItem);
            col.add(Box.createRigidArea(new Dimension(0, 6)));
        }

        return col;
    }
}