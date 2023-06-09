package Frontend.tl;
import Frontend.ui.UI;

public class Controller {
    private UI interfaz = new UI();
    public void start() throws Exception {
        int opcion = -1;
        do {
            interfaz.mostrarMenu();
            opcion = interfaz.leerOpcion();
            procesarOpcion(opcion);
        }
        while (opcion != -0);
    }
    public void procesarOpcion(int opcion) throws Exception {
        switch (opcion) {
            case 1:
                interfaz.mostrarMenuAdmin();
                opcion = interfaz.leerOpcion();
                procesarOpcionAdmin(opcion);
                break;
            case 2:
                interfaz.mostrarMenuCliente();
                opcion = interfaz.leerOpcion();
                procesarOpcionCliente(opcion);
                break;
            case 0:
                break;
            default:
                interfaz.imprimirMensaje("Opcion desconocida");
        }
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
