//Crear una clase llamada Alumno que mantenga información sobre las notas de distintos
//alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer
//con sus 3 notas.
//En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
//toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
//pregunta al usuario si quiere crear otro Alumno o no.
//Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
//Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
//final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
//del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
//promedio final, devuelto por el método y mostrado en el main.

package ejercicio_03;

//@author Facundo Cruz

import Entidad.Alumno;
import Servicio.AlumnoService;
import java.text.DecimalFormat;
import java.util.*;


public class Ejercicio_03 {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.##");
        List<Alumno> alumnos = new ArrayList();
        Scanner leer = new Scanner(System.in);
        AlumnoService sv = new AlumnoService();
        sv.crearAlumno(alumnos);
        System.out.println("Ingrese el nombre de un alumno para calcular su nota final");
        String name = leer.next();
        boolean var = false;
        double notaF = 0;
        for (Alumno aux : alumnos) {
            if (aux.getNombre().equalsIgnoreCase(name)) {
                var = true;
                notaF = sv.notaFinal(aux.getNotas());
                break;
            }
        }
        if (var) {
            System.out.println("La nota final del alumno " + name + " es: " + df.format(notaF));
        }else{
            System.out.println("Alumno no encontrado");
        }
    }

}
