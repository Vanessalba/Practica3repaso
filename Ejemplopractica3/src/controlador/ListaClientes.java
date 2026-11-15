package controlador;

import java.util.ArrayList;
import modelo.Cliente;

/**
 * CONTROLADOR: lista de clientes.
 * "extends ArrayList<Cliente>" significa que ES un ArrayList de clientes,
 * así que ya tiene add, get, remove, size, isEmpty... y además le añadimos
 * los métodos para movernos por la lista.
 */
public class ListaClientes extends ArrayList<Cliente> {

    // Posición (índice) del cliente que se está mostrando. Empieza en 0.
    private int actual;

    // Constructor
    public ListaClientes() {
        super();        // crea el ArrayList vacío
        actual = 0;
    }

    // ---------- Preguntas (devuelven true o false) ----------

    public boolean esVacia() {
        return this.isEmpty();
    }

    public boolean esPrimero() {
        return actual == 0;
    }

    public boolean esUltimo() {
        return actual == this.size() - 1;
    }

    // ---------- Moverse por la lista ----------

    public void avanzar() {
        if (!esUltimo()) {
            actual++;
        }
    }

    public void retroceder() {
        if (!esPrimero()) {
            actual--;
        }
    }

    public void irAlPrimero() {
        actual = 0;
    }

    public void irAlUltimo() {
        if (esVacia()) {
            actual = 0;
        } else {
            actual = this.size() - 1;
        }
    }

    // ---------- Gestionar clientes ----------

    // Añade un cliente al final. Devuelve false si el número ya existe.
    public boolean anadirCliente(Cliente c) {
        if (existeNumero(c.getNumero())) {
            return false;
        }
        this.add(c);
        return true;
    }

    // Borra el cliente actual
    public void borrarCliente() {
        if (esVacia()) {
            return;
        }
        this.remove(actual);
        // Si borramos el último, el índice se sale de la lista: lo bajamos uno
        if (actual >= this.size() && actual > 0) {
            actual--;
        }
    }

    // Devuelve el cliente que se está mostrando (null si no hay ninguno)
    public Cliente obtenerClienteActual() {
        if (esVacia()) {
            return null;
        }
        return this.get(actual);
    }

    // Ordena la lista por número de cliente (método de burbuja)
    public void ordenarPorNumero() {
        Cliente seleccionado = obtenerClienteActual();

        for (int i = 0; i < this.size() - 1; i++) {
            for (int j = 0; j < this.size() - 1 - i; j++) {
                if (this.get(j).getNumero() > this.get(j + 1).getNumero()) {
                    // Intercambiamos los dos clientes
                    Cliente temporal = this.get(j);
                    this.set(j, this.get(j + 1));
                    this.set(j + 1, temporal);
                }
            }
        }

        // Seguimos mostrando el mismo cliente que antes de ordenar
        if (seleccionado != null) {
            actual = this.indexOf(seleccionado);
        }
    }

    // ---------- Métodos extra ----------

    // Dice si ya hay un cliente con ese número
    public boolean existeNumero(int numero) {
        for (Cliente c : this) {
            if (c.getNumero() == numero) {
                return true;
            }
        }
        return false;
    }

    // Devuelve el índice actual (por si la vista lo necesita)
    public int getActual() {
        return actual;
    }
}
