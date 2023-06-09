package Frontend;

import Backend.Model.Libro.Libro;

import java.util.List;

public class VRegistroLibro {
    /**
     * Muestra el mensaje que es resivido en el CRegistroLibro
     * @param mensaje
     */
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    /**
     * Muestra el total de libros registrados
     * @param libros
     */
    public void mostrarLibros(List<Libro> libros){
        System.out.println("Libros registrados:");
        for (Libro libro: libros) {
            System.out.println(libro);
        }
    }

}
