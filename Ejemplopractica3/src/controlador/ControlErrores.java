package controlador;

import java.awt.Color;
import java.time.LocalDate;
import javax.swing.JLabel;

/**
 * Clase ESTÁTICA para comprobar los campos del formulario.
 * Todos sus métodos son "static": se usan sin crear objetos,
 * por ejemplo: ControlErrores.validarPuntos("50")
 *
 * Cada método validar... devuelve:
 *   - null            si el dato es correcto
 *   - un texto        con el error si es incorrecto
 */
public class ControlErrores {

    // ---------- Comprobaciones ----------

    // Puntos: tiene que ser un número entre 0 y 1000
    public static String validarPuntos(String texto) {
        try {
            float puntos = Float.parseFloat(texto.trim());
            if (puntos < 0 || puntos > 1000) {
                return "Los puntos deben estar entre 0 y 1000.";
            }
            return null;   // todo bien
        } catch (NumberFormatException e) {
            return "Los puntos deben ser un número.";
        }
    }

    // Fecha: formato dd/MM/aaaa, fecha real y año entre 1900 y 2015
    public static String validarFecha(String texto) {
        try {
            // Cortamos el texto "25/12/1990" en tres trozos por la barra
            String[] partes = texto.trim().split("/");
            if (partes.length != 3) {
                return "Fecha no válida. Use dd/mm/aaaa.";
            }
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int anio = Integer.parseInt(partes[2]);

            // LocalDate.of lanza error si la fecha no existe (ej. 31/02)
            LocalDate.of(anio, mes, dia);

            if (anio < 1900 || anio > 2015) {
                return "El año debe estar entre 1900 y 2015.";
            }
            return null;   // todo bien
        } catch (Exception e) {
            return "Fecha no válida. Use dd/mm/aaaa.";
        }
    }

    // Número de cliente: entero mayor que 0
    public static String validarNumero(String texto) {
        try {
            int numero = Integer.parseInt(texto.trim());
            if (numero <= 0) {
                return "El número debe ser mayor que 0.";
            }
            return null;
        } catch (NumberFormatException e) {
            return "El número debe ser un entero.";
        }
    }

    // Nombre: no puede estar vacío
    public static String validarNombre(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return "El nombre no puede estar vacío.";
        }
        return null;
    }

    // ---------- Convertir texto a datos (usar solo DESPUÉS de validar) ----------

    public static LocalDate convertirFecha(String texto) {
        String[] partes = texto.trim().split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);
        return LocalDate.of(anio, mes, dia);
    }

    // ---------- Mostrar el error en un JLabel rojo ----------

    public static void mostrarError(JLabel etiqueta, String error) {
        etiqueta.setForeground(Color.RED);
        etiqueta.setText(error);
    }

    public static void limpiarError(JLabel etiqueta) {
        etiqueta.setText("");
    }
}
