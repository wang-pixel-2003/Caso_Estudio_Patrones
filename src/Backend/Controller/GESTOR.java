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
    private Persona UsuarioLogin;

    public GESTOR() {
        //administradorDao = new AdministradorDAO();
       // clienteDao =  new ClienteDAO();
        personaDao = new PersonaDAO();
        librosDao = new LibroDAO();
        libros = new ArrayList<>();
    }

    /**
     * Esta funcion registra el libro y lo envia a la base de datos
     * @param titulo
     * @param autor
     * @param categoria
     */
    public void agregarLibro(String titulo, String autor, String categoria){
        librosDao.registrarLibro(titulo, autor, categoria);
    }

    /**
     * Esta funcion verifica el tipo de usuario para rediccionar al menu respectivo
     */

    public Persona VerificacionLogin(String usuario, String contrasenna) {
        this.UsuarioLogin = personaDao.consultarPersona(usuario,contrasenna);
        return personaDao.consultarPersona(usuario,contrasenna);

    }
    public void registroUsuario(Persona persona) {
        personaDao.registroPersona(persona);
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
