package Logic;

import Model.Administrador.AdministradorDAO;
import Model.Cliente.ClienteDAO;
import Model.Libro.LibroDAO;
import Model.Persona.PersonaDAO;

public class GESTOR {
    private final AdministradorDAO administradorDao;
    private final ClienteDAO clienteDao;
    private final PersonaDAO personaDao;
    private final LibroDAO librosDao;

    public GESTOR() {
        administradorDao = new AdministradorDAO();
        clienteDao =  new ClienteDAO();
        personaDao = new PersonaDAO();
        librosDao = new LibroDAO();

    }
}
