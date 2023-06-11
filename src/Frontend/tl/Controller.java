package Frontend.tl;
import Backend.Controller.GESTOR;
import Backend.Model.Libro.Libro;
import Backend.Model.Persona.Persona;
import Backend.Model.Prestamo.Prestamo;
import Frontend.ui.UI;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    GESTOR gestor = new GESTOR();

    private UI interfaz = new UI();
    public void start() throws Exception {
        interfaz.mostrarMenu();
        primerMenuOpcion();
    }

    /**
     * Esta funcion lo que hace es pedir al administrador que inserte los datos de los libros a registrar
     * @throws IOException
     */
    public void registroLibro() throws IOException {
        interfaz.imprimirMensaje("Digite el titulo del libro");
        String titulo = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite el autor del libro");
        String autor = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite el categoria del libro");
        String categoria = interfaz.leerTexto();
        gestor.agregarLibro(titulo, autor, categoria);
        interfaz.imprimirMensaje("El libro " + titulo + " fue registrado exitosamente\n");

    }

    public void modificarEstado() throws IOException {
        interfaz.imprimirMensaje("Digite el titulo del libro");
        String titulo = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite el numero de estado a escoger");
        interfaz.imprimirMensaje("Estado 0 = Disponible");
        interfaz.imprimirMensaje("Estado 1 = Ocupado");
        int estado = Integer.parseInt(interfaz.leerTexto());
        if (estado == 0){
            gestor.modificarDisponible(titulo);
        }
        if (estado == 1){
            gestor.modificarApartado(titulo);
        }
    }


    /**
     * Funcion que permite elegir la opcion del primer menu
     * @throws Exception
     */
    public void primerMenuOpcion() throws Exception {
        int opcion = interfaz.leerOpcion();
        if(opcion == 1) {
            registroUsuario();
        } else if (opcion == 2) {
            loginUsuario();
        } else {
            interfaz.imprimirMensaje("****** La opcion ingresada no es valida ****");
            interfaz.imprimirMensaje("****** Gracias por visitarnos ****");
        }
    }
    /**
     * Funcion que lee la informacion del nuevo usuario para registrarloy.
     * @throws Exception
     */
    public void registroUsuario() throws Exception {
        interfaz.imprimirMensaje("Digite su Nombre");
        String nombre = interfaz.leerTexto();

        interfaz.imprimirMensaje("Digite su Direccion");
        String direccion = interfaz.leerTexto();

        interfaz.imprimirMensaje("Digite su Telefono");
        String telefono = interfaz.leerTexto();

        interfaz.imprimirMensaje("Digite su Nombre de Usuario");
        String nombreUsuario = interfaz.leerTexto();

        interfaz.imprimirMensaje("Digite su Contraseña");
        String contrasenna = interfaz.leerTexto();

        Persona usuario = new Persona( nombre, direccion, telefono, contrasenna, nombreUsuario,"2");
        gestor.registroUsuario(usuario);

        interfaz.imprimirMensaje("Se registro el usuario exitosamente!\n");
        interfaz.mostrarMenu();
        primerMenuOpcion();

    }
    /**
     * Esta funcion es para el logeo de la aplicacion.
     * @throws Exception
     */
    public void loginUsuario() throws Exception{

        int opcion =-1;

        interfaz.imprimirMensaje("Digite el usuario:");
        String usuario = interfaz.leerTexto();
        interfaz.imprimirMensaje("Digite contrasena:");
        String password = interfaz.leerTexto();

        Persona resultado = gestor.VerificacionLogin(usuario,password);
        if (resultado.getTipoUsuario().equals("ADMINISTRADOR")){
            do{
                interfaz.mostrarMenuAdmin();
                opcion = interfaz.leerOpcion();
                procesarOpcionAdmin(opcion);
            }
            while (opcion != -0);

        } else if (resultado.getTipoUsuario().equals("CLIENTES")){
            do{
                interfaz.mostrarMenuCliente();
                opcion = interfaz.leerOpcion();
                procesarOpcionCliente(opcion);
            }
            while (opcion != -0);
        } else {
            interfaz.imprimirMensaje("El usuario o password no existe");
        }
        interfaz.imprimirMensaje("****** Gracias por visitarnos ****");
    }

    /**
     * Esta funcion lo hace es ver que accion seleciono el usuario.
     * @param opcion
     * @throws Exception
     */
    public void procesarOpcionAdmin(int opcion) throws Exception {
        switch (opcion) {
            case 1:
                registroLibro();
                break;
            case 2:
                modificarEstado();
                break;
            case 3:
                interfaz.imprimirMensaje("==lista de libros==");
                for (Libro libro:gestor.listarTotalLibros()) {
                    interfaz.imprimirMensaje(libro.toString());
                }
                break;
            case 4:
                interfaz.imprimirMensaje("==lista de libros prestados==");
                for (Prestamo prestamo:gestor.mostrarLibrosPrestados()) {
                    interfaz.imprimirMensaje(prestamo.toString());
                }
                break;

            case 5:
                interfaz.imprimirMensaje("==lista de libros disponibles==");
                for (Libro libro:gestor.mostrarLibrosDisponibles()) {
                    interfaz.imprimirMensaje(libro.toString());
                }
                break;
            case 6:
                interfaz.imprimirMensaje("Ingrese el nombre del usuario");
                String usuario = interfaz.leerTexto();
                interfaz.imprimirMensaje("\n==lista de libros del usuario " + usuario + "==");
                for (Libro libro:gestor.listarLibrosxUsuario(usuario)) {
                    interfaz.imprimirMensaje(libro.toString());
                }
                break;
            case 0:
                break;
            default:
                interfaz.imprimirMensaje("Opcion desconocida");
        }
    }
    public void procesarOpcionCliente(int opcion) throws Exception {
        switch (opcion) {
            case 1:
                interfaz.imprimirMensaje("==lista de libros==");
                for (Libro libro:gestor.listarTotalLibros()) {
                    interfaz.imprimirMensaje(libro.toString());
                }
                interfaz.imprimirMensaje("Digite el nombre del libro");
                String tituloLibro = interfaz.leerTexto();
                gestor.modificarApartado(tituloLibro);
                gestor.agregarPrestamo(gestor.getUsuarioLogin(), tituloLibro);
                interfaz.imprimirMensaje("El libro solicitado fue: " + tituloLibro);
                break;
            case 2:
                for (Libro libro:gestor.listarTotalLibros()) {
                    interfaz.imprimirMensaje(libro.toString());
                }
                interfaz.imprimirMensaje("Digite el nombre del libro");
                String libroTitulo = interfaz.leerTexto();
                gestor.modificarDisponible(libroTitulo);
                gestor.devolverPrestamo(gestor.getUsuarioLogin(), libroTitulo);
                interfaz.imprimirMensaje("El libro fue devuelto: " + libroTitulo);
                break;
            case 3:
                interfaz.imprimirMensaje("==lista de libros disponibles==");
                for (Libro libro:gestor.mostrarLibrosDisponibles()) {
                    interfaz.imprimirMensaje(libro.toString());
                }
                break;
            case 4:
                interfaz.imprimirMensaje("==lista de libros prestados==");
                for (Prestamo prestamo:gestor.mostrarLibrosPrestados()) {
                    interfaz.imprimirMensaje(prestamo.toString());
                }
                break;

            case 0:
                break;
            default:
                interfaz.imprimirMensaje("Opcion desconocida");
        }
    }
}
