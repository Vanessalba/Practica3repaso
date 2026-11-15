package modelo;

import java.time.LocalDate;

/**
 * MODELO: guarda los datos de un cliente.
 * Solo tiene atributos, constructores, getters, setters y toString.
 * No sabe nada de ventanas.
 */
public class Cliente {

    // Atributos (privados: solo se tocan con getters y setters)
    private int numero;
    private String nombre;
    private float puntos;
    private LocalDate fechaNacimiento;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con todos los datos
    public Cliente(int numero, String nombre, float puntos, LocalDate fechaNacimiento) {
        this.numero = numero;
        this.nombre = nombre;
        this.puntos = puntos;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters: devuelven el valor
    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPuntos() {
        return puntos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    // Setters: cambian el valor
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntos(float puntos) {
        this.puntos = puntos;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // toString: el texto que se obtiene al imprimir el cliente
    @Override
    public String toString() {
        return "Cliente " + numero + " - " + nombre
                + " - Puntos: " + puntos
                + " - Nacimiento: " + fechaNacimiento;
    }
}
