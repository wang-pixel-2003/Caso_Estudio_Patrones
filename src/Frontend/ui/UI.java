package Frontend.ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class UI {
    private PrintStream out = System.out;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


    public void mostrarMenu() {
        System.out.println("================ CASO DE ESTUDIO ========================");
        System.out.println("          G R U P O   2: M A R I O   64                  ");
        System.out.println("==========================================================");
        System.out.println("============ Bienvenido - Biblioteca El Caso =============");
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar Sesion");
    }

    public void mostrarMenuAdmin() {
        System.out.println("============= Biblioteca El Caso =====================");
        System.out.println("============ Menu del Administrador ==================");
        System.out.println("=======================================================");
        System.out.println("1. Registrar libro");
        System.out.println("2. Modificar libro");
        System.out.println("3. Mostrar lista de libros ");
        System.out.println("4. Mostrar libros prestados");
        System.out.println("5. Mostrar libros disponibles");
        System.out.println("6. Buscar libro por usuario");
        System.out.println("0. Salir");
        System.out.print("Seleccione la opción que desea: ");
    }
    public void mostrarMenuCliente() {
        System.out.println("============= Biblioteca El Caso =====================");
        System.out.println("=============   Menu del Cliente  ====================");
        System.out.println("=======================================================");
        System.out.println("1. Solicitar libro");
        System.out.println("2. Devolver libro prestado");
        System.out.println("3. Mostrar libros disponibles");
        System.out.println("4. Mostrar libros prestados");
        System.out.println("0. Salir");
        System.out.print("Seleccione la opción que desea: ");
    }


    public int leerOpcion() throws IOException {
        return Integer.parseInt(in.readLine());
    }

    public void imprimirMensaje(String mensaje) {
        out.println(mensaje);
    }

    public String leerTexto() throws IOException{
        return in.readLine();
    }
}
