package ejemplopractica3;

import vista.VentanaPrincipal;

public class Ejemplopractica3 {

    public static void main(String[] args) {
        // Swing se crea en el hilo de eventos
        java.awt.EventQueue.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}