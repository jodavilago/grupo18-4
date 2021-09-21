package modelo;

import java.io.File;
import java.util.ArrayList;

public class EstudianteDTO {
   private EstudianteDAO estudiante_dao;
    private Conexion conexion;

    public EstudianteDTO(){
        conexion = new Conexion();
        estudiante_dao = new EstudianteDAO(conexion);
         String n = "", a = "", fn = "", ci = "", cp = "", pr="";
        long cel = 0, f = 0;
    }

    public EstudianteDAO getEstudiante_dao() {
        return estudiante_dao;
    }

   
    
    public void setEstudiante_dao(EstudianteDAO estudiante_dao) {
        this.estudiante_dao = estudiante_dao;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }
    
}