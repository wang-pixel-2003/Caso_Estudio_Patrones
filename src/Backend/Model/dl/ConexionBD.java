package Backend.Model.dl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    private static String _usuarioBD = "mumehwgs";
    private static String _contrasennaBD = "OIflOBHDTggkVwm1325mpzvicyIzuFgO";
    private static String _bd = "mumehwgs";
    private static String _host = "rajje.db.elephantsql.com";
    private static String puerto = "5432";
    private static String _url = "jdbc:postgresql://" + _host + ":" + puerto + "/" + _bd;

    private static Connection connection = null;

    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = (Connection) DriverManager.getConnection(_url, _usuarioBD, _contrasennaBD);
    //        System.out.println("conexion exitosa!");
        } catch (SQLException ex) {
      //      System.out.println("conexion erronea");
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
     //       System.out.println("conexion erronea");
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connection;
    }

    public void desconectarBD() {
        try {
            connection.close();
       //     System.out.println("cerrando conexion.");
        } catch (Exception e) {
        }
    }
}
