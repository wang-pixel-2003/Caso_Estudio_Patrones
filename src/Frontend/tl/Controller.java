package Frontend.tl;
import Backend.Controller.GESTOR;
import Backend.Model.Libro.Libro;
import Backend.Model.Persona.Persona;
import Frontend.ui.UI;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    GESTOR gestor = new GESTOR();

    private UI interfaz = new UI();
    public void start() throws Exception {
        interfaz.mostrarMenu();
        loginUsuario();
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
                interfaz.imprimirMensaje("Aqui va el modificar libro");
                break;
            case 3:
                interfaz.imprimirMensaje("==lista de libros==");
                for (Libro libro:gestor.listarTotalLibros()) {
                    interfaz.imprimirMensaje(libro.toString());
                }
                break;
            case 4:
                interfaz.imprimirMensaje("Mostar lista de libros prestados");
                break;
            case 5:
                interfaz.imprimirMensaje("Mostar lista de libros disponibles");
                break;
            case 6:
                interfaz.imprimirMensaje("Buscar libro por usuario");
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
                interfaz.imprimirMensaje("Me registro como usuario");
                break;
            case 2:
                interfaz.imprimirMensaje("solicito libro");
                break;
            case 3:
                interfaz.imprimirMensaje("devolver libro");
                break;
            case 4:
                interfaz.imprimirMensaje("mostrar libros disponibles");
                break;
            case 0:
                break;
            default:
                interfaz.imprimirMensaje("Opcion desconocida");
        }
    }
}
