package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class VistaPrincipal extends JFrame {

    public static final Color AZUL_EPN = new Color(0, 40, 85);
    public static final Color ROJO_EPN = new Color(200, 16, 46);
    public static final Color BLANCO = Color.WHITE;

    public JButton btnIngresar;

    public VistaPrincipal() {
        setTitle("SIDEDAII - Escuela Politécnica Nacional");
        setSize(820, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(AZUL_EPN);
        panelSuperior.setBorder(new MatteBorder(0, 0, 4, 0, ROJO_EPN));

        JLabel lblInstitucion = new JLabel("ESCUELA POLITÉCNICA NACIONAL", SwingConstants.CENTER);
        lblInstitucion.setForeground(BLANCO);
        lblInstitucion.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblInstitucion.setBorder(new EmptyBorder(16, 15, 16, 15));
        panelSuperior.add(lblInstitucion, BorderLayout.CENTER);
        add(panelSuperior, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel();
        panelCentral.setBackground(BLANCO);
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBorder(new EmptyBorder(40, 40, 40, 40));

        JLabel lblAcronimo = new JLabel("SIDEDAII");
        lblAcronimo.setFont(new Font("Segoe UI", Font.BOLD, 48));
        lblAcronimo.setForeground(AZUL_EPN);
        lblAcronimo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSubtitulo = new JLabel("Sistema Didáctico de Estructuras de Datos y Algoritmos II");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblSubtitulo.setForeground(new Color(45, 45, 45));
        lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnIngresar = new JButton("INGRESAR");
        btnIngresar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnIngresar.setBackground(ROJO_EPN);
        btnIngresar.setForeground(BLANCO);
        btnIngresar.setFocusPainted(false);
        btnIngresar.setContentAreaFilled(true);
        btnIngresar.setOpaque(true);
        btnIngresar.setBorder(new EmptyBorder(12, 42, 12, 42));
        btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnIngresar.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelCentral.add(Box.createVerticalGlue());
        panelCentral.add(lblAcronimo);
        panelCentral.add(Box.createRigidArea(new Dimension(0, 18)));
        panelCentral.add(lblSubtitulo);
        panelCentral.add(Box.createRigidArea(new Dimension(0, 38)));
        panelCentral.add(btnIngresar);
        panelCentral.add(Box.createVerticalGlue());

        add(panelCentral, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.setBackground(AZUL_EPN);
        panelInferior.setBorder(new MatteBorder(4, 0, 0, 0, ROJO_EPN));

        JLabel lblFacultad = new JLabel("FACULTAD DE INGENIERÍA EN SISTEMAS", SwingConstants.CENTER);
        lblFacultad.setForeground(BLANCO);
        lblFacultad.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblFacultad.setBorder(new EmptyBorder(16, 15, 16, 15));
        panelInferior.add(lblFacultad, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }
}