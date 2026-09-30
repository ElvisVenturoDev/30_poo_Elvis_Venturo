package vallegrande.edu.pe;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EjemploJLabel {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Etiqueta Valle Grande");

        JLabel etiqueta = new JLabel("¡Bienvenido al portal institucional!");

        ventana.add(etiqueta);
        ventana.setSize(350, 150);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}