package vallegrande.edu.pe;

import javax.swing.JOptionPane;

public class EjemploJOptionPane {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Proceso completado con éxito.");

        String codigo = JOptionPane.showInputDialog(null, "Ingresa tu código de alumno:");

        if (codigo != null && !codigo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Código ingresado: " + codigo);
        }
    }
}