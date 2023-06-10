package Backend.Model.Persona;

import Backend.Model.dl.ConexionBD;
import Backend.Model.dl.TestConexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDAO {

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
}
