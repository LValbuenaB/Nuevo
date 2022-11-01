
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static final String url = "jdbc:mysql://localhost:3306/usuarios?auroReconnect=true&useSSL=false";
    public static final String usuario = "root";
    public static final String contraseña = "1234";
    
    //Comentario prueba
    
    public Connection getConnection(){
        Connection conexion = null;
        
        try{
            conexion = (Connection) DriverManager.getConnection(url,usuario,contraseña);
        }catch(Exception ex){
            System.err.println("Error, "+ex);
        }
        return conexion;
    }
}
