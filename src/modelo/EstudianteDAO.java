package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EstudianteDAO {
    private Conexion conexion;
     String n = "", a = "", fn = "", ci = "", cp = "", pr="";
        long cel = 0, f = 0;
    
    
    public EstudianteDAO(Conexion conexion) {
        this.conexion = conexion;
         String n = "", a = "", fn = "", ci = "", cp = "", pr="";
        long cel = 0, f = 0;
    }

    
    public boolean agregarEstudiante(String nombres, String apellidos, String fechaNacimiento, String correoInstitucional, String correoPersonal, long celular, long fijo, String programa)
    {     Estudiante nuevo = new Estudiante(nombres, apellidos, fechaNacimiento, correoInstitucional, correoPersonal, celular, fijo,programa);
      
        PreparedStatement ps;
        String sql = "INSERT INTO estudiantes(Nombres, Apellidos, Fecha_Nacimiento, Correo_Institucional, Correo_Personal, Telefono_Celular, Telefono_fijo, Programa) VALUES (?,?,?,?,?,?,?,?)";

        try {
            conexion.EstableciendoConexion();
            ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, nombres);
            ps.setString(2, apellidos);
            ps.setString(3, fechaNacimiento);
            ps.setString(4, correoInstitucional);
            ps.setString(5, correoPersonal);
            ps.setLong(6, celular);
            ps.setLong(7, fijo);
            ps.setString(8, programa);
            int contador = ps.executeUpdate();
            if (contador > 0) {
                conexion.cerrandoConexion();
                return true;
            } else {
                conexion.cerrandoConexion();
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

 
   public Estudiante buscarEstudiante(String correoInstitucional) {
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT Nombres, Apellidos, Fecha_Nacimiento,  Correo_Institucional, Correo_Personal, Telefono_Celular, Telefono_fijo, Programa FROM estudiantes where Correo_Institucional = ?";
        Estudiante encontrado = null;
        try {
            conexion.EstableciendoConexion();
            ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, correoInstitucional);
            rs = ps.executeQuery();
            if (rs.next()) {
                String n = rs.getString(1);
                String a = rs.getString(2);
                String fn = rs.getString(3);
                String ci = rs.getString(4);
                String cp = rs.getString(5);
                long cel = Long.parseLong(rs.getString(6));
                long f = Long.parseLong(rs.getString(7));
                String pr = rs.getString(8);
                encontrado = new Estudiante(n, a, fn, ci, cp, cel, f, pr);
            }
            conexion.cerrandoConexion();
        } catch (Exception e) {
            encontrado = null;
        }
        return encontrado;
    }


   
     public boolean eliminarEstudiante(String correoInstitucional) {
        PreparedStatement ps;
        String sql = "DELETE FROM estudiantes where Correo_Institucional = ?";

        try {
            conexion.EstableciendoConexion();
            ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, correoInstitucional);
            int contador = ps.executeUpdate();
            if (contador > 0) {
                conexion.cerrandoConexion();
                return true;
            } else {
                conexion.cerrandoConexion();
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }


   public boolean modificarEstudiante(  String correoInstitucional, String  correoPersonal, long celular, long fijo, String programa) {
        PreparedStatement ps;
        String sql = "UPDATE estudiantes SET Correo_Personal=?, Telefono_Celular=?, Telefono_fijo =?, Programa =? where Correo_Institucional = ?";

        try {
            conexion.EstableciendoConexion();
            ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(1, correoPersonal);
            ps.setLong(2,celular );
            ps.setLong(3, fijo );
            ps.setString(4, programa);
            ps.setString(5, correoInstitucional);
           
            int contador = ps.executeUpdate();
            if (contador > 0) {
                conexion.cerrandoConexion();
                return true;
            } else {
                conexion.cerrandoConexion();
                return false;
            }
        } catch (Exception e) {
            return false;
        }
  
   
   }
  
   

public String verEstudiantes() {
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
        
        
        PreparedStatement ps;
        ResultSet rs = null;
        String sql = "SELECT * FROM estudiantes";
        String listado = "";
        try {
            conexion.EstableciendoConexion();
            ps = conexion.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String nombres = rs.getString(1);
                String apellidos = rs.getString(2);
                String fechaNacimiento = rs.getString(3);
                String correoInstitucional = rs.getString(4);
                String correoPersonal = rs.getString(5);
                long celular = Long.parseLong(rs.getString(6));
                long fijo = Long.parseLong(rs.getString(7));
                String programa = rs.getString(8);
                Estudiante aux = new Estudiante(nombres, apellidos, fechaNacimiento, correoInstitucional, correoPersonal, celular, fijo, programa);
                listaEstudiantes.add(aux);
            }

            for (Estudiante estudiante : listaEstudiantes) {
                listado = listado.concat(estudiante.toString() + "\n");
            }
            conexion.cerrandoConexion();
        } catch (Exception e) {
            listado = "";
        }
        return listado;
    }

}

