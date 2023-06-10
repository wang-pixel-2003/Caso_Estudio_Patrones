package Backend.Model.Prestamo;

import Backend.Model.Libro.Libro;

import java.util.ArrayList;

public class Prestamo {

    private int id_Prestamo;
    private int id_Usuario;
    private int id_Libro;
    private String Fecha_Devolucion;

    public ArrayList<Libro> lista = new ArrayList<Libro>();

    public int getId_Prestamo() {
        return id_Prestamo;
    }

    public void setId_Prestamo(int id_Prestamo) {
        this.id_Prestamo = id_Prestamo;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public int getId_Libro() {
        return id_Libro;
    }

    public void setId_Libro(int id_Libro) {
        this.id_Libro = id_Libro;
    }

    public String getFecha_Devolucion() {
        return Fecha_Devolucion;
    }

    public void setFecha_Devolucion(String fecha_Devolucion) {
        Fecha_Devolucion = fecha_Devolucion;
    }

    public Prestamo() {
    }

    public Prestamo(int id_Prestamo, int id_Usuario, int id_Libro, String fecha_Devolucion) {
        this.id_Prestamo = id_Prestamo;
        this.id_Usuario = id_Usuario;
        this.id_Libro = id_Libro;
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
        return super.toString();
    }
}
