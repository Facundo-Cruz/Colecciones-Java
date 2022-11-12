//En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
//todos sus datos y guardándolos en el objeto Pelicula.
//Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
//crear otra Pelicula o no.

package Servicio;

import Entidad.Pelicula;
import java.util.*;


//@author Facundo Cruz

public class PeliculaService {
    public void crearPelicula(List<Pelicula> peliculas){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        char resp = 'S';
        while (resp!='N') {
            Pelicula p1 = new Pelicula();
            System.out.println("Ingrese el titulo");
            p1.setTitulo(leer.next());
            System.out.println("Ingrese el director");
            p1.setDirector(leer.next());
            System.out.println("Ingrese la duracion en horas");
            p1.setDuracion(leer.nextDouble());
            peliculas.add(p1);
            System.out.println("¿Desea ingresar otra pelicula?(S/N)");
            resp = leer.next().toUpperCase().charAt(0);
           
        }
    }
}
