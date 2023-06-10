package Backend.Model.dl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class TestConexion {

/*============ESTA CLASE ES SOLAMENTE DE PRUEBA PARA VERIFICAR QUE LA CONEXIÓN A LA BASE DE DATOS FUNIONE CORRECTAMENTE*/

    public static void main(String[] args) {
        String idCliente = "8";
        String obtieneNombreCliente = consultaClienteTest("19");
        System.out.println("nombre del cliente: " + obtieneNombreCliente);

    }

    public static String consultaClienteTest(String idCliente) {
        ConexionBD con = new ConexionBD();
        String sql = "SELECT NOMBRE_COMPLETO FROM USUARIOS CL WHERE CL.ID_USUARIO=" + idCliente + "";
        String nombre = "";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                nombre = rs.getString(1);

            }
            con.desconectarBD();//cierre de conexión

        } catch (SQLException ex) {
            Logger.getLogger(TestConexion.class.getName()).log(Level.SEVERE, null, ex);
            con.desconectarBD();//cierre de conexión
            return nombre;
        }
        return nombre;

    }
}
