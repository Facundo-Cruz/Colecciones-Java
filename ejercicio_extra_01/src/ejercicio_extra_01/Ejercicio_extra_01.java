package ejercicio_extra_01;

//@author Facundo Cruz
import Entidad.Alumno;
import Servicio.AlumnoService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Ejercicio_extra_01 {

    public static void main(String[] args) {
//        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate fechaNac = LocalDate.parse("15/08/1993", fmt);
        AlumnoService sv = new AlumnoService();
        ArrayList<Alumno> listaAlumnos = new ArrayList(20);
        sv.A(listaAlumnos);
        sv.ordenarListaAsc(listaAlumnos);
        System.out.println("------------------");
        sv.ordenarListaDesc(listaAlumnos);
        //sv.mostrarAlumno(listaAlumnos);
        System.out.println("--------------------");
        sv.listarNacionalidad(listaAlumnos);
    }

}
