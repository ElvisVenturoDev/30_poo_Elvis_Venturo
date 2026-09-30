package vallegrande.edu.pe;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EjemploJTextField {
    public static void main(String[] args) {
        JFrame ventana = new JFrame(" Valle Grande");
        JPanel panel = new JPanel();

        JTextField campoTexto = new JTextField(15);
        campoTexto.setText("Ingresa tu código");

        panel.add(campoTexto);
        ventana.add(panel);

        ventana.setSize(350, 120);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}