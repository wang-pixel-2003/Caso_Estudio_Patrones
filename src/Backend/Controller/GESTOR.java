package Backend.Controller;

import Backend.Model.Libro.Libro;
import Backend.Model.Libro.LibroDAO;
import Backend.Model.Persona.Persona;
import Backend.Model.Persona.PersonaDAO;
import Backend.Model.Prestamo.Prestamo;
import Backend.Model.Prestamo.PrestamoDAO;


import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.List;

public class GESTOR {
   // private final AdministradorDAO administradorDao;
   // private final ClienteDAO clienteDao;
    private final PersonaDAO personaDao;
    private final LibroDAO librosDao;
    private Persona UsuarioLogin;
    private final PrestamoDAO prestamoDAO;

    public GESTOR() {
        //administradorDao = new AdministradorDAO();
       // clienteDao =  new ClienteDAO();
        personaDao = new PersonaDAO();
        librosDao = new LibroDAO();
        prestamoDAO = new PrestamoDAO();
    }

    /**
     * Esta funcion registra el libro y lo envia a la base de datos.
     * @param titulo
     * @param autor
     * @param categoria
     */
    public void agregarLibro(String titulo, String autor, String categoria){
        librosDao.registrarLibro(titulo, autor, categoria);
    }

    /**
     * Esta funcion modifica el estado y envia la informacion a actualizar.
     * @param titulo
     */
    public void modificarDisponible(String titulo){
        librosDao.modificarDisponible(titulo);
    }
    public void modificarApartado(String titulo){
        librosDao.modificarApartado(titulo);
    }
    public void agregarPrestamo(Persona usuarioLogin, String libro){
        librosDao.agregarPrestamoLibros(usuarioLogin, libro);
    }

    public void devolverPrestamo(Persona usuarioLogin, String libro){
        librosDao.devolverPrestamoLibros(usuarioLogin, libro);
    }
    /**
     * Esta funcion verifica el tipo de usuario para rediccionar al menu respectivo.
     * @param usuario
     * @param contrasenna
     * @return
     */
    public Persona VerificacionLogin(String usuario, String contrasenna) {
        this.UsuarioLogin = personaDao.consultarPersona(usuario,contrasenna);
        return personaDao.consultarPersona(usuario,contrasenna);

    }


    /**
     * Esta funcion devuelvo lista de libros disponibles
     * */

    public ArrayList<Libro> mostrarLibrosDisponibles() {
        return librosDao.mostrarListaLibrosDisponibles();
        /**if (librosDao.isEmpty()) {
            System.out.println("No hay libros disponibles.");
        } else {
            view.mostrarLibros(libros);
        }
         */
    }

    public ArrayList<Prestamo> mostrarLibrosPrestados() {
        return prestamoDAO.mostrarListaLibrosPrestados();
    }

    /**
     * Funcion que recibe el objeto de persona para mandarlo a la base de datos.
     * @param persona
     */
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
    /**
     * Funcion que contiene la lista de libros que pertenecen al usuario despues de la consulta al DAO de libros
     * @param usuario
     * @return
     */
    public ArrayList<Libro> listarLibrosxUsuario(String usuario){
        return librosDao.librosUsuario(usuario);
    }
}
