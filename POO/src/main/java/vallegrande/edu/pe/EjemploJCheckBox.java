package vallegrande.edu.pe;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

public class EjemploJCheckBox {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Casilla Valle Grande");
        JPanel panel = new JPanel();

        JCheckBox casilla = new JCheckBox("Acepto el reglamento interno");
        casilla.setSelected(true);

        panel.add(casilla);
        ventana.add(panel);

        ventana.setSize(320, 120);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}