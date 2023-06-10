package Backend.Model.Cliente;

import Backend.Model.Persona.Persona;

public class Cliente extends Persona {

    public Cliente(int id, String nombre, String direccion, String telefono, String contrasenna, String usuario, String tipoUsuario) {
        super(id, nombre, direccion, telefono, contrasenna, usuario, tipoUsuario);
    }
}
