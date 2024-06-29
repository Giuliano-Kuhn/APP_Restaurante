package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    String bd= "bd_restaurante";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String pass = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;

    public ConexionDB() {
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd, user, pass);
        } catch (SQLException |ClassNotFoundException ex) {
            System.out.println("FALLO LA CONEXION A DB " + bd);
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return cx;
    }
    
    
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("FALLO LA DESCONEXION A DB " + bd);
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
