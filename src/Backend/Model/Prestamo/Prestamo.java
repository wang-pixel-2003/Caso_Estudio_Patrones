package Backend.Model.Prestamo;

import Backend.Model.Libro.Libro;
import Backend.Model.Persona.Persona;

import java.util.ArrayList;

public class Prestamo {

    private int id_Prestamo;
    private Persona nombreUsuario;
    private Libro Libro;
    private String Fecha_Devolucion;

    public int getId_Prestamo() {
        return id_Prestamo;
    }

    public void setId_Prestamo(int id_Prestamo) {
        this.id_Prestamo = id_Prestamo;
    }

    public Persona getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(Persona nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Backend.Model.Libro.Libro getLibro() {
        return Libro;
    }

    public void setLibro(Backend.Model.Libro.Libro libro) {
        Libro = libro;
    }

    public String getFecha_Devolucion() {
        return Fecha_Devolucion;
    }

    public void setFecha_Devolucion(String fecha_Devolucion) {
        Fecha_Devolucion = fecha_Devolucion;
    }

    public Prestamo() {
    }


    public Prestamo(int id_Prestamo, Persona nombreUsuario, Backend.Model.Libro.Libro libro, String fecha_Devolucion) {
        this.id_Prestamo = id_Prestamo;
        this.nombreUsuario = nombreUsuario;
        Libro = libro;
        Fecha_Devolucion = fecha_Devolucion;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id_Prestamo=" + id_Prestamo +
                ", nombreUsuario=" + nombreUsuario.getNombre() +
                ", Libro=" + Libro.getTitulo() +
                ", Fecha_Devolucion='" + Fecha_Devolucion + '\'' +
                '}';
    }
}
