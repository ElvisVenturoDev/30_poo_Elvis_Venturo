package vallegrande.edu.pe;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class EjemploJPanel {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Panel Valle Grande");

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);

        ventana.add(panel);
        ventana.setSize(400, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}