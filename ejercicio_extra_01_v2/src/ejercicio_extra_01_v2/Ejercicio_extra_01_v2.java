package ejercicio_extra_01_v2;

//@author Facundo Cruz
import Entidad.Alumno;
import Servicio.AlumnoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio_extra_01_v2 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        AlumnoService sv = new AlumnoService();
        List<Alumno> listStudents = new ArrayList();
        sv.loadInitialList(listStudents);
        List<Alumno> listArg = new ArrayList();
        List<Alumno> listCh = new ArrayList();
        List<Alumno> listVza = new ArrayList();
        int opcion;
        boolean var = false;
        do {
            System.out.println("\t.:Menu:.");
            System.out.println("1 - Alta");
            System.out.println("2 - Baja");
            System.out.println("3 - Modificar alumno");
            System.out.println("4 - Ordenar y mostrar lista según apellido de manera ascedente");
            System.out.println("5 - Ordenar y mostrar lista según apellido de manera descendente");
            System.out.println("6 - Calcular edad de un alumno");
            System.out.println("7 - Cargar listas paralelas segun nacionalidad");
            System.out.println("8 - Mostrar reporte final");
            System.out.println("9 - Salir");
            System.out.println("Elija su opcion:");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    sv.A(listStudents);
                    break;
                case 2:
                    sv.B(listStudents);
                    break;
                case 3:
                    sv.M(listStudents);
                    break;
                case 4:
                    sv.sortListAsc(listStudents);
                    break;
                case 5:
                    sv.sortListDesc(listStudents);
                    break;
                case 6:
                    sv.showStudentAge(listStudents);
                    break;
                case 7:
                    sv.nacionalityList(listStudents, listArg, listCh, listVza);
                    var = true;
                    break;
                case 8:
                    if (!var) {
                        System.out.println("Antes de mostrar el reporte final debes crear las listas paralelas segun su nacionalidad");
                        System.out.println("------------------------------------------------------------------------------------------");
                    }else{
                        sv.finalReport(listStudents, listArg.size(), listCh.size(), listVza.size());
                        
                    }
                    break;
                case 9:
                    System.out.println("Hasta Luego...");
                    break;
                default:
                    System.out.println("Esa no es una opcion valida, vuelva a intentar...");
                    break;
            }
        } while (opcion != 9);
    }

}
