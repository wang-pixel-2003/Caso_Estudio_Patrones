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

public class LibroDAO {

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

}
