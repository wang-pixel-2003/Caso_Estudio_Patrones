package Model.Cliente;

import Model.Persona.Persona;

public class Cliente extends Persona {
    public Cliente(String nombre, String direccion, String telefono, String contrasenna, String usuario) {
        super(nombre, direccion, telefono, contrasenna, usuario);
    }
}
