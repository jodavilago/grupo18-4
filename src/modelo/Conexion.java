package modelo;


import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    
private Connection conexion = null;

    public void EstableciendoConexion() {
        
        
        String url = "jdbc:mysql://localhost:3306/bd_estudiantes";
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, "root", "Jd900630");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Problemas al establecer la conexión ");
        }
    }
    
    public void cerrandoConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            System.out.println("Problema al cerrar la conexión de la Base de Datos");
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    

}
