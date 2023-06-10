package Backend.Model.Administrador;


import Backend.Model.Persona.Persona;

public class Administrador  extends Persona {

    public Administrador(int id, String nombre, String direccion, String telefono, String contrasenna, String usuario, String tipoUsuario) {
        super(id, nombre, direccion, telefono, contrasenna, usuario, tipoUsuario);
    }
}

