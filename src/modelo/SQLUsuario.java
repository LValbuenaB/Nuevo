
package modelo;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLUsuario {
    
    public boolean registrar(Usuarios usuario){//servira para insertar o registrar un usuario neuvo a la bd
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        
        try{
            Connection conexion = con.getConnection();
            
            ps = conexion.prepareStatement("insert into usuario (nombreUsuario,contraseña,nombre,correo,idTipo_usuario) values (?,?,?,?,?)");
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getContraseña());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getCorreo());
            ps.setInt(5, usuario.getIdTipo_usuario());
            ps.executeUpdate();
            
            return true;//Si se realiza una inserción correcta se retorna true
            
        }catch(Exception ex){
            return false;
        }
    }
    
    public int verificarUsuario(String usuario){
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Connection conexion = con.getConnection();
            
            ps = conexion.prepareStatement("select count(id) from usuario where nombreUsuario=?");//Se realiza conteo para saber cuantos usuarios cone se usario existen, para valdiar que no se repitan al realizar el nuevo regstro por el formulario
            ps.setString(1, usuario);
           
            rs = ps.executeQuery();
            
            //la consulta retorna un conteo y con el if se da cuyenta de cuanto es el valor del conteo y retornar el valor del conteo, si el metodo retorna un valor de 0 es proque ya hay un usuario con ese nombre
            if (rs.next()) {//Si se cumple significa que esta retornando un conteo - un valor
                return rs.getInt(1);
            }
            
            return 1;
            
        }catch(Exception ex){
            return 1;//Es obligatorio retornar 1, ya que si hay una excepcion significa que nos e puede agrargar el nuevo usario
        }
    }
    
    public boolean comprobarEmail(String correo){
        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        //Este es un patron de reconocimiento tipo Pattern, los patrones que deben tener un correo electronico
        //Puede empezar de acuerdoa  las letras que se escriben arriba, se lee asi: puede comenzar con un _ o letras mayus o min o numeros o guion alto en el primer []
        //Luego un correo puede llevar un punto depsues del punto puede volver a tner _ mayyus o min o numeros o guion alto antes del @
        //despues del @se debe comprobar si es hotmail, gmail y es despues del @ que se verifica esto
        //ya no comienza con _ si no con mayus min o guio alto (-) despues de esto viene un punto (.com) y luego mayus min y (com) y luego otro punto (.co) qu eambien puede despues del punto
        //recibir letras min mayus 
        
        Matcher matcher = patron.matcher(correo);
        
        return matcher.find();
    }

    public boolean iniciarSesion(Usuarios usuario) throws SQLException{
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            Connection conexion = con.getConnection();
            
            ps = conexion.prepareStatement("select u.id,u.nombreUsuario,u.contraseña,u.nombre,u.idTipo_usuario,t.nombre from usuario as u inner join tipo_usuario as t on u.idtipo_usuario = t.id where u.nombreUsuario=?");
            ps.setString(1, usuario.getNombreUsuario());
                       
            rs = ps.executeQuery();
            
            if (rs.next()){
                if (usuario.getContraseña().equals(rs.getString("contraseña"))) {//Se comprueba la contraseña - se verifica si la contraseña de usurario que el pne es iguala al contraseña de la bd
                    
                    ps = conexion.prepareStatement("update usuario set ultima_sesion=? where id=?");
                    ps.setString(1, usuario.getUltima_sesion());
                    ps.setInt(2, rs.getInt("id"));
                    ps.executeUpdate();
                   
                    usuario.setId(rs.getInt("u.id"));
                    usuario.setNombre(rs.getString("u.nombre"));
                    usuario.setIdTipo_usuario(rs.getInt("u.idTipo_usuario"));
                    usuario.setNombreRol(rs.getString("t.nombre"));
                                        
                    return true;
                }
                else{
                    return false;
                }
            }
            
            return false;
            
        }catch(Exception ex){
            return false;//Es obligatorio retornar 1, ya que si hay una excepcion significa que nos e puede agrargar el nuevo usario
        }
    }
}
