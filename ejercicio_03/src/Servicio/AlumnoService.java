//En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
//toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
//pregunta al usuario si quiere crear otro Alumno o no.
//Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
//Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
//final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
//del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
//promedio final, devuelto por el método y mostrado en el main.
package Servicio;

import Entidad.Alumno;
import java.util.*;
//@author Facundo Cruz

public class AlumnoService {

    public void crearAlumno(List<Alumno> alumnos) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        char resp = 'S';
        while (resp!='N') {
            Alumno a1 = new Alumno();
            System.out.println("Ingrese el nombre del alumno");
            a1.setNombre(leer.next());
            for (int i = 0; i < 3; i++) {
                System.out.println("Ingrese la nota " + (i + 1));
                Integer nota = leer.nextInt();
                if (nota < 0 || nota > 10) {
                    System.out.println("Nota no válida. Revise que el valor se encuentre entre 0 y 10");
                    i--;
                } else {
                    a1.setNotas(nota);
                }
            }
            alumnos.add(a1);
            System.out.println("¿Desea crear otro alumno?(S/N)");
            resp = leer.next().toUpperCase().charAt(0);
        }
    }
    
    public double notaFinal(List<Integer> notas){
        double suma = 0;
        for (Integer aux : notas) {
            suma += (double)aux;
        }
        return suma / notas.size();
    }
}
