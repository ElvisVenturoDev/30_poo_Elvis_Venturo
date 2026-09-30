package vallegrande.edu.pe;

import javax.swing.JFrame;

public class EjemploJFrame {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ventana Valle Grande");

        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}