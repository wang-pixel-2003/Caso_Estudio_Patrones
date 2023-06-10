

package Backend.Model.Prestamo;

import Backend.Model.Persona.Persona;
import Backend.Model.Libro.Libro;
import Backend.Model.dl.ConexionBD;
import Backend.Model.dl.TestConexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrestamoDAO {
    public ArrayList<Prestamo> mostrarListaLibrosEstado() {
        ArrayList<Prestamo> list = new ArrayList<Prestamo>();
        ConexionBD con = new ConexionBD();
        String sql = "";
        sql = "SELECT pr.id_libro, pr.id_usuario, pr.fecha_devolucion FROM PRESTAMOS_LIBRO pr";

        ResultSet rs = null;
        PreparedStatement ps = null;
//        System.out.println(sql);
        try {

            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Prestamo pr = new Prestamo();


                pr.setId_Prestamo(rs.getInt(1));
                pr.setId_Libro(rs.getInt(2));
                pr.setId_Usuario(rs.getInt(3));
                pr.setFecha_Devolucion(rs.getString(4));
                list.add(pr);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
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


