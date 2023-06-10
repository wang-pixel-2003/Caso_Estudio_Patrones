package Backend.Controller;

import Backend.Model.Libro.Libro;

import java.util.ArrayList;
import java.util.List;

public class CRegistroLibro {
    private List<Libro> libros;
    private VRegistroLibro view;

    /**
     * Esta funcion instancia la lista y hace referencia a la clase VRegistroLibro, quien es el que muestra el mensaje.
     * @param view
     */
    public CRegistroLibro(VRegistroLibro view){
        libros = new ArrayList<>();
        this.view = view;
    }

    /**
     * Esta funcion crea libros y lo agrega a una lista donde despues informa que esta correctamente agregado.
     * @param titulo
     * @param autor
     * @param categoria
     */
    public void agregarLibro(int idLibro, int estado,String titulo, String autor, String categoria){
        Libro libro = new Libro(idLibro,estado,titulo, autor, categoria);
        libros.add(libro);
        view.mostrarMensaje("Nombre de Libro agregado: " + libro.getTitulo());
    }

    /**
     * Esta funcion muestra los libros que tiene mi lista
     */
    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            view.mostrarLibros(libros);
        }
    }
}
