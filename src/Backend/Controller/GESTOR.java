package Backend.Controller;

import Backend.Model.Libro.Libro;
import Backend.Model.Libro.LibroDAO;
import Backend.Model.Persona.Persona;
import Backend.Model.Persona.PersonaDAO;

import java.util.ArrayList;
import java.util.List;

public class GESTOR {
   // private final AdministradorDAO administradorDao;
   // private final ClienteDAO clienteDao;
    private final PersonaDAO personaDao;
    private final LibroDAO librosDao;
    private List<Libro> libros;
    private VRegistroLibro view;
    private Persona UsuarioLogin;

    public GESTOR() {
        //administradorDao = new AdministradorDAO();
       // clienteDao =  new ClienteDAO();
        personaDao = new PersonaDAO();
        librosDao = new LibroDAO();
        libros = new ArrayList<>();
    }

    /**
     * Esta funcion crea libros y lo agrega a una lista donde despues informa que esta correctamente agregado.
     * @param titulo
     * @param autor
     * @param categoria
     */
    public void agregarLibro(int idLibro,int estado, String titulo, String autor, String categoria){
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

    /**
     * Esta funcion verifica el tipo de usuario para rediccionar al menu respectivo
     */

    public Persona VerificacionLogin(String usuario, String contrasenna) {
        this.UsuarioLogin = personaDao.consultarPersona(usuario,contrasenna);
        return personaDao.consultarPersona(usuario,contrasenna);

    }

    /*Esta seccion es para llevar el objeto a las diferentes partes del programa */
    public Persona getUsuarioLogin() {
        return UsuarioLogin;
    }

    public void setUsuarioLogin(Persona usuarioLogin) {
        UsuarioLogin = usuarioLogin;
    }


    public  ArrayList<Libro>listarTotalLibros(){
        return librosDao.mostrarListaLibros();

    }
}
