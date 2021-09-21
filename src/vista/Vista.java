
package vista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vista {
    private Scanner leer;
    public Vista(){
        leer = new Scanner(System.in);
    }

    public void menu(){
        System.out.println("INSTITUTO LA FLORESTA");
        System.out.println("Seleccione tarea a realizar:");
        System.out.println(" 1. Ingresar estudiante");
        System.out.println(" 2. Buscar estudiante");
        System.out.println(" 3. Modificar estudiante");
        System.out.println(" 4. Eliminar estudiante");
        System.out.println(" 5. Ver directorio de estudiantes");
        System.out.println(" 6. Salir");
        System.out.println("Opción:");
    }

    public void mostrarInformacion(String mensaje){
        System.out.println(mensaje);
    }

    public String leerDatoString(String mensaje){
        System.out.println(mensaje);
        String dato = leer.nextLine();
        return dato;
    }

    public int leerDatoEntero(){
        int dato = 0;
        try{
            menu();
            dato = leer.nextInt();
            leer.nextLine();
        }catch (Exception e){
            leer.nextLine();
            System.out.println("El dato ingresado no es un número");
            dato = 0;
        }
        return dato;
    }

    public long leerDatoLong(String mensaje){
        long dato = 0;
        try{
            System.out.println(mensaje);
            dato = leer.nextLong();
            leer.nextLine();
        }catch (Exception e){
            leer.nextLine();
            System.out.println("El dato ingresado no es un número");
            dato = 0;
        }finally {
            return dato;
        }

    }
}
