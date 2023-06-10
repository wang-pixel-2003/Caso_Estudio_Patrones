package Frontend.tl;
import Backend.Controller.GESTOR;
import Backend.Model.Persona.Persona;
import Frontend.ui.UI;

public class Controller {
    GESTOR gestor = new GESTOR();

    private UI interfaz = new UI();
    public void start() throws Exception {
        interfaz.mostrarMenu();
        loginUsuario();

    }
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


    public void procesarOpcionAdmin(int opcion) throws Exception {
        switch (opcion) {
            case 1:
                interfaz.imprimirMensaje("Aqui va el registrar el libro");
                break;
            case 2:
                interfaz.imprimirMensaje("Aqui va el modificar libro");
                break;
            case 3:
                interfaz.imprimirMensaje("Mostrar lista de libros");
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
