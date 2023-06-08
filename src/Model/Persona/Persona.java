package Model.Persona;

public class Persona {
    private String nombre;
    private String direccion;
    private String telefono;
    private String contrasenna;
    private String usuario;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Persona(String nombre, String direccion, String telefono, String contrasenna, String usuario) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contrasenna = contrasenna;
        this.usuario = usuario;
    }
}