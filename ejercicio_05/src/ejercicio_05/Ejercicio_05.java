//Se requiere un programa que lea y guarde países, y para evitar que se ingresen repetidos
//usaremos un conjunto. El programa pedirá un país en un bucle, se guardará el país en el
//conjunto y después se le preguntará al usuario si quiere guardar otro país o si quiere salir,
//si decide salir, se mostrará todos los países guardados en el conjunto. (Recordemos hacer
//los servicios en la clase correspondiente)
//Después deberemos mostrar el conjunto ordenado alfabéticamente: para esto recordar
//cómo se ordena un conjunto.
//Por último, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator, se
//buscará el país en el conjunto y si está en el conjunto se eliminará el país que ingresó el
//usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto se le informará
//al usuario.
package ejercicio_05;

//@author Facundo Cruz
import Entidad.Pais;
import Servicio.PaisService;
import java.util.*;

public class Ejercicio_05 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        PaisService sv = new PaisService();
        Set<Pais> paises = new HashSet();
        sv.crearPais(paises);
        System.out.println("Paises ingresados: ");
        sv.mostrarPaises(paises);
        List<Pais> listPaises = new ArrayList(paises);
        Collections.sort(listPaises, sv.ordendarAlfabeticamente);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Países ordenados alfabeticamente: ");
        sv.mostrarPaises(listPaises);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Ingrese un país a eliminar");
        String eliminar = leer.next();
        if (sv.eliminarPais(paises, eliminar)) {
            System.out.println(eliminar + " ha sido eliminado con éxito del conjunto...");
        } else {
            System.out.println(eliminar + " no ha sido encontrado en el conjunto...");
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Lista final de países: ");
        sv.mostrarPaises(paises);
    }

}
