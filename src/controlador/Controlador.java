
package controlador;

import modelo.Estudiante;
import modelo.EstudianteDTO;
import vista.Vista;

public class Controlador {
    private Vista vista;
    private EstudianteDTO instituto;

    public Controlador(){
        vista = new Vista();
        instituto = new EstudianteDTO();
        inits();
    }

    public void inits(){
        String n = "", a = "", fn = "", ci = "", cp = "", pr="";
        long cel = 0, f = 0;
        
        int opcion;
        do {
            opcion = vista.leerDatoEntero();
            switch (opcion){
                case 1:
                    ingresarEstudiante();

                    break;
                case 2:
                    buscarEstudiante();
                    break;
                case 3:
                    modificarEstudiante();
                    break;
                case 4:
                    eliminarEstudiante();
                    break;
                case 5:
                    mostrarDirectorio();
                    break;
                case 6:
                    vista.mostrarInformacion("Hasta pronto");
                    break;
                default:
                    vista.mostrarInformacion("Opción no valida");
            }
        }while (opcion !=6);


    }

    
    
    
    public void ingresarEstudiante(){
        String n = "", a = "", fn = "", ci = "", cp = "", pr="";
        long cel = 0, f = 0;
        vista.mostrarInformacion("Ingresar estudiante");
        n = vista.leerDatoString("Ingresar nombres");
        a = vista.leerDatoString("Ingresar apellidos");
        fn = vista.leerDatoString("Ingresar fecha de nacimiento");
        ci = vista.leerDatoString("Ingresar correo institucional");
        cp = vista.leerDatoString("Ingresar correo personal");
        cel = vista.leerDatoLong("ingresar telefono celular");
        f = vista.leerDatoLong("Ingresar telefono fijo");
        pr = vista.leerDatoString("Ingresar programa");

        
        if (instituto.getEstudiante_dao().agregarEstudiante(n,a,fn,ci,cp,cel,f,pr)) {
            vista.mostrarInformacion("Se agregó el estudiante");
        } else {
            vista.mostrarInformacion("No fue posible agregar el estudiante");
        }
    }
       

    public void mostrarDirectorio(){
        String rta = instituto.getEstudiante_dao().verEstudiantes();
        vista.mostrarInformacion(rta);
    }

    
    public void buscarEstudiante(){
        String ci = "";
        vista.mostrarInformacion("Buscar Estudiante");
        ci = vista.leerDatoString("Ingresar correo institucional:");
        Estudiante rta = instituto.getEstudiante_dao().buscarEstudiante(ci);
             
        if (rta != null) {
            vista.mostrarInformacion(rta.toString());
        } else {
            vista.mostrarInformacion("El estudiante no está en nuestra base de datos");
        }
    }
        
       

    public void modificarEstudiante() {
	vista.mostrarInformacion("Modificar estudiante");
        String ci = vista.leerDatoString("Ingresar el correo institucional: ");
        if (instituto.getEstudiante_dao().buscarEstudiante(ci) != null) {
            String cp = vista.leerDatoString("Ingresar correo personal");
            long cel= vista.leerDatoLong("ingresar telefono celular");
            long f = vista.leerDatoLong("Ingresar telefono fijo");
            String  pr  = vista.leerDatoString("Ingresar programa");
            if (instituto.getEstudiante_dao().modificarEstudiante( ci,cp,cel, f, pr)) {
                vista.mostrarInformacion("Se actualizó registro");
            } else {
                vista.mostrarInformacion("Se modificó el estudiante");
            }
        } else {
            vista.mostrarInformacion("El estudiante no se encuentra registrado");
        }
    }
    

    
    public void eliminarEstudiante(){
        String ci = "";
        vista.mostrarInformacion("Eliminar estudiante");
        ci = vista.leerDatoString("Ingresar correo institucional");
        if (instituto.getEstudiante_dao().eliminarEstudiante(ci)){
            vista.mostrarInformacion("Se eliminó el estudiante");
        }else {
            vista.mostrarInformacion("El estudiante no se encuentra en la base de datos");
        }
    }
}
