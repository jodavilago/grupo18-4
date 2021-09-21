package modelo;

public class Estudiante {
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String correoInstitucional;
    private String correoPersonal;
    private long celular;
    private long fijo;
    private String programa;

    public Estudiante (String nombres, String apellidos, String fechaNacimiento, String correoInstitucional, String correoPersonal, long celular, long fijo, String programa){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correoInstitucional = correoInstitucional;
        this.correoPersonal = correoPersonal;
        this.celular = celular;
        this.fijo = fijo;
        this.programa = programa;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNaciemiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public long getFijo() {
        return fijo;
    }

    public void setFijo(long fijo) {
        this.fijo = fijo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @Override
    public String toString() {
        return  "Nombres:" + nombres + "\n" +
                "Apellidos:" + apellidos + "\n" +
                "FechaNacimiento:" + fechaNacimiento + "\n" +
                "Correo Institucional:" + correoInstitucional + "\n" +
                "Correo Personal:" + correoPersonal + "\n" +
                "Celular:" + celular + "\n" +
                "Fijo:" + fijo + "\n" +
                "Programa:" + programa + "\n";
    }
}

