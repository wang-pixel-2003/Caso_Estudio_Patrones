package Backend.Model.Persona;

import Backend.Model.Libro.LibroDAO;
import Backend.Model.dl.ConexionBD;
import Backend.Model.dl.TestConexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDAO {

    /**
     * Funcion que recibe los parametros de usuario y contrasenna para consultar si existe un usuario con estos datos y realizar un login en la aplicacion
     * @param usuario
     * @param contrasenna
     * @return
     */
    public Persona consultarPersona(String usuario, String contrasenna) {
        ConexionBD con = new ConexionBD();
        String sql = "SELECT US.ID_USUARIO,US.NOMBRE_COMPLETO, US.DIRECCION, US.TELEFONO, US.USERNAME,US.CONTRASENNA, RL.DESCRIPCION_ROL\n" +
                "FROM USUARIOS US, ROLES RL\n" +
                "WHERE US.ID_ROL=RL.ID_ROL\n" +
                "AND US.USERNAME='"+usuario+"' AND US.CONTRASENNA='"+contrasenna+"'";

        Persona persona = new Persona();
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                persona.setId(rs.getInt("ID_USUARIO"));
                persona.setNombre(rs.getString("NOMBRE_COMPLETO")) ;
                persona.setDireccion(rs.getString("DIRECCION"));
                persona.setTelefono(rs.getString("TELEFONO"));
                persona.setContrasenna(rs.getString("CONTRASENNA"));
                persona.setUsuario(rs.getString("USERNAME"));
                persona.setTipoUsuario(rs.getString("DESCRIPCION_ROL"));
            }
            con.desconectarBD();//cierre de conexión

        } catch (SQLException ex) {
            Logger.getLogger(TestConexion.class.getName()).log(Level.SEVERE, null, ex);
            con.desconectarBD();//cierre de conexión
            return persona;
        }
        return persona;
    }

    /**
     * Funcion que recibe un parametro de persona y guarda el objeto en la base de datos
     * @param persona
     */
    public void registroPersona(Persona persona) {
        ConexionBD con = new ConexionBD();
        String sql;
        sql = "INSERT INTO USUARIOS (ID_USUARIO, NOMBRE_COMPLETO, DIRECCION, TELEFONO, USERNAME, CONTRASENNA, ID_ROL) VALUES (nextval('SEC_USUARIOS'),?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.getConnection().prepareStatement(sql);
            ps.setString(1,persona.getNombre());
            ps.setString(2,persona.getDireccion());
            ps.setString(3,persona.getTelefono());
            ps.setString(4, persona.getUsuario());
            ps.setString(5, persona.getContrasenna());
            ps.setInt(6, Integer.parseInt(persona.getTipoUsuario()));

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
}
