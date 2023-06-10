

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

    public ArrayList<Prestamo> mostrarListaLibrosPrestados() {
        ArrayList<Prestamo> lista = new ArrayList<Prestamo>();
        ConexionBD con = new ConexionBD();
        String sql = "";
        sql = "SELECT \n" +
                "PL.ID_PRESTAMO,\n" +
                "CASE WHEN US.NOMBRE_COMPLETO IS NULL THEN 'SIN ASIGNAR' ELSE  US.NOMBRE_COMPLETO  END AS NOMBRE_COMPLETO,\n" +
                "LB.TITULO,\n" +
                "CASE WHEN TO_CHAR(PL.FECHA_DEVOLUCION,'DD/MM/YYYY') IS NULL THEN 'SIN ASIGNAR' ELSE TO_CHAR(PL.FECHA_DEVOLUCION,'DD/MM/YYYY') END AS FECHA_DEVOLUCION, \n" +
                "LB.TITULO\n" +
                "FROM LIBROS LB LEFT JOIN PRESTAMOS_LIBROS PL \n" +
                "ON LB.ID_LIBRO= PL.ID_LIBRO\n" +
                "LEFT JOIN USUARIOS US \n" +
                "ON US.ID_USUARIO=PL.ID_USUARIO\n" +
                "WHERE LB.ESTADO=1\n" +
                "ORDER BY FECHA_DEVOLUCION DESC\n";

        ResultSet rs = null;
        PreparedStatement ps = null;
//        System.out.println(sql);
        try {

            ps = con.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Prestamo pr = new Prestamo();


                pr.setId_Prestamo(rs.getInt(1));
                Persona persona = new Persona(rs.getString(2));
                Libro libro = new Libro(rs.getString(3));
                pr.setNombreUsuario(persona);
                pr.setLibro(libro);
                pr.setFecha_Devolucion(rs.getString(4));
                lista.add(pr);

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
        return lista;
    }



}


