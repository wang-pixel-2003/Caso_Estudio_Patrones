package Backend.Model.Libro;

import Backend.Model.Persona.Persona;
import Backend.Model.dl.ConexionBD;
import Backend.Model.dl.TestConexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta funcion lo que hace es insertar en la tabla libros, el libro con sus titulo, autor, categoria.
 */
public class LibroDAO {
    public void registrarLibro(String titulo, String autor, String categoria){
        ConexionBD con = new ConexionBD();
        String sql = "";
        sql = "INSERT INTO Libros (id_libro, titulo, autor, categoria, estado) VALUES (nextval('SEC_TIPO_LIBROS'),?,?,?,?)";

        PreparedStatement ps = null;
        try {
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1,titulo);
            ps.setString(2,autor);
            ps.setString(3,categoria);
            ps.setInt(4, 0);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.desconectarBD();
            } catch (Exception ex) {
                con.desconectarBD();
            }
        }
    }

    /**
     * Esta funcion lo que hace es llamar la informacion de la tabla libros.
     * @return
     */
    public ArrayList<Libro> mostrarListaLibros() {
        ArrayList<Libro> list = new ArrayList<Libro>();
        ConexionBD con = new ConexionBD();
        String sql = "";
        sql = "SELECT lb.id_libro, lb.titulo, lb.autor, lb.categoria, lb.estado FROM LIBROS lb";

        ResultSet rs = null;
        PreparedStatement ps = null;
//        System.out.println(sql);
        try {

            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Libro lb= new Libro();

                lb.setIdLibro(rs.getInt(1));
                lb.setTitulo(rs.getString(2));
                lb.setAutor(rs.getString(3));
                lb.setCategoria(rs.getString(4));
                lb.setEstado(rs.getInt(5));
                list.add(lb);

            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                rs.close();
                con.desconectarBD();
            } catch (Exception ex) {
                con.desconectarBD();
            }
        }

        con.desconectarBD();
        return list;
    }

    /**
     * Esta funcion actualiza la informacion de libro en la tabla de libros, agarra el estado, titulo.
     * @param estado
     * @param titulo
     */
    public void modificarEstado(int estado, String titulo){
        ConexionBD con = new ConexionBD();
        String sql = "";
        sql = "UPDATE Libros Set estado=? WHERE titulo=?";

        PreparedStatement ps = null;
        try {
            ps = con.getConnection().prepareStatement(sql);
            if (estado == 0){
                ps.setInt(1, 0);
                ps.setString(2,titulo);
                ps.executeUpdate();
            }
            if (estado == 1){
                ps.setInt(1, 1);
                ps.setString(2,titulo);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                con.desconectarBD();
            } catch (Exception ex) {
                con.desconectarBD();
            }
        }
    }

    public ArrayList<Libro> mostrarListaLibrosDisponibles() {
        ArrayList<Libro> list = new ArrayList<Libro>();
        ConexionBD con = new ConexionBD();
        String sql = "";
        sql = "SELECT lb.id_libro, lb.titulo, lb.autor, lb.categoria, lb.estado FROM LIBROS lb WHERE lb.estado = 0 ";

        ResultSet rs = null;
        PreparedStatement ps = null;
//        System.out.println(sql);
        try {

            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Libro lb= new Libro();

                lb.setIdLibro(rs.getInt(1));
                lb.setTitulo(rs.getString(2));
                lb.setAutor(rs.getString(3));
                lb.setCategoria(rs.getString(4));
                lb.setEstado(rs.getInt(5));
                list.add(lb);

            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                rs.close();
                con.desconectarBD();
            } catch (Exception ex) {
                con.desconectarBD();
            }
        }

        con.desconectarBD();
        return list;
    }




}
