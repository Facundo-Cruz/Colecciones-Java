//Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto,
//tendremos una clase Pelicula con el título, director y duración de la película (en horas).
//Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo
//que se pide a continuación:
//En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
//todos sus datos y guardándolos en el objeto Pelicula.
//Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
//crear otra Pelicula o no.
package ejercicio_04;

//@author Facundo Cruz
import Entidad.Pelicula;
import Servicio.PeliculaService;
import Utilidades.Comparadores;
import java.util.*;

public class Ejercicio_04 {

    public static void main(String[] args) {
        PeliculaService sv = new PeliculaService();
        TreeSet<Pelicula> pelis = new TreeSet<Pelicula>();
        Pelicula ob = new Pelicula();
        pelis.add(ob);
        List<Pelicula> peliculas = new ArrayList();
        sv.crearPelicula(peliculas);
        System.out.println("Todas las peliculas: ");
        for (Pelicula aux : peliculas) {
            System.out.println(aux);
        }
        System.out.println("-----------------------------");
        System.out.println("Las peliculas con duración mayor a una hora son: ");
        for (Pelicula aux : peliculas) {
            if (aux.getDuracion() >= 1) {
                System.out.println(aux.getTitulo());
            }
        }
        System.out.println("-----------------------------");
        System.out.println("Las peliculas con duración de mayor a menor son:  ");
        Collections.sort(peliculas, Comparadores.duracionMayorAMenor);
        for (Pelicula aux : peliculas) {
            System.out.println(aux.getTitulo() + " ---> " + aux.getDuracion());
        }
         System.out.println("-----------------------------");
        System.out.println("Las peliculas con duración de menor a mayor son:  ");
        Collections.sort(peliculas, Comparadores.duracionMenorAMayor);
        for (Pelicula aux : peliculas) {
            System.out.println(aux.getTitulo() + " ---> " + aux.getDuracion());
        }
        System.out.println("-----------------------------");
        System.out.println("Las peliculas ordenadas por título alfabeticamente son: ");
        Collections.sort(peliculas, Comparadores.tituloAlfabeticamente);
        for (Pelicula aux : peliculas) {
            System.out.println(aux.getTitulo());
        }
        System.out.println("-----------------------------");
        System.out.println("Las peliculas ordenadas por director alfabeticamente son: ");
        Collections.sort(peliculas, Comparadores.directorAlfabeticamente);
        for (Pelicula aux : peliculas) {
            System.out.println(aux.getTitulo() + " ---> " + aux.getDirector());
        }
    }

}
