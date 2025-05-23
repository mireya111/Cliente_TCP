package cliente.vista;

import cliente.clase.Cliente;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana() {
        super("Cliente TCP");
        setSize(342, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(204, 229, 255)); // celeste claro

        JLabel nombre, jornada;
        JLabel explicacion;
        JTextField nombreText;
        JButton timbrar;
        ButtonGroup opciones = new ButtonGroup();
        JRadioButton opcion1 = new JRadioButton("Salida del trabajo");
        JRadioButton opcion2 = new JRadioButton("Ingreso del Almuerzo");
        JRadioButton opcion3 = new JRadioButton("Salida al Almuerzo");
        JRadioButton opcion4 = new JRadioButton("Ingreso al trabajo");

        nombre = new JLabel("Primer nombre y apellido del empleado (en ese orden):");
        jornada = new JLabel("Jornada:");
        nombreText = new JTextField();
        timbrar = new JButton("Timbrar");
        explicacion = new JLabel("<html><div style='width:200px;'>Si desea cortar la comunicación del cliente, el servidor y crear el archivo, coloca 'x' en el nombre</div></html>");

        nombre.setBounds(10, 10, 300, 20);
        jornada.setBounds(10, 90, 380, 20);
        nombreText.setBounds(10, 40, 310, 20);
        timbrar.setBounds(10, 220, 300, 20);
        explicacion.setBounds(10, 250, 310, 50);
        explicacion.setForeground(new Color(194, 6, 6));

        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        opcion1.setBounds(10, 130, 200, 20);
        opcion2.setBounds(10, 150, 200, 20);
        opcion3.setBounds(10, 170, 200, 20);
        opcion4.setBounds(10, 190, 200, 20);

        timbrar.setBackground(new Color(66, 133, 244)); // azul Google
        timbrar.setForeground(Color.WHITE);// celeste claro

        add(nombre);
        add(explicacion);
        add(jornada);
        add(nombreText);
        add(timbrar);
        add(opcion1);
        add(opcion2);
        add(opcion3);
        add(opcion4);

        timbrar.addActionListener(e -> {
            String nombreAguardar = nombreText.getText();
            String jornadaAguardar = "";

            if (opcion1.isSelected()) {
                jornadaAguardar = "Salida del trabajo";
            } else if (opcion2.isSelected()) {
                jornadaAguardar = "Ingreso del Almuerzo";
            } else if (opcion3.isSelected()) {
                jornadaAguardar = "Salida al Almuerzo";
            } else if (opcion4.isSelected()) {
                jornadaAguardar = "Ingreso al trabajo";
            }

            if (!nombreAguardar.isEmpty() && !jornadaAguardar.isEmpty()) {
                Cliente cliente = new Cliente();
                try {
                    String respuesta = cliente.enviarNombre(nombreAguardar, jornadaAguardar);
                    JOptionPane.showMessageDialog(this, "Datos enviados al servidor: " + respuesta + "\n");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al enviar datos al servidor: " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            }
        });
    }
}