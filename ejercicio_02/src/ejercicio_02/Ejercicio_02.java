//Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá
//un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro
//está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista
//ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará
//la lista ordenada.
package ejercicio_02;

//@author Facundo Cruz
import java.util.*;

public class Ejercicio_02 {

    public static void main(String[] args) {
        List<String> nombreMascotas = new ArrayList();
        Scanner leer = new Scanner(System.in);
        char resp = 's';
        while (resp != 'n') {
            System.out.println("Ingrese el nombre de la mascota");
            String name = leer.next();
            nombreMascotas.add(name);
            System.out.println("¿Desea ingresar otro nombre?(S/N)");
            resp = leer.next().toLowerCase().charAt(0);
        }
        System.out.println("--------------");
        System.out.println("Lista de mascotas:");
        for (String a : nombreMascotas) {
            System.out.println("#"+a);
        }
        System.out.println("Ingrese un perro a eliminar");
        String dogDelete = leer.next();
        int dim = nombreMascotas.size();
        Iterator<String> it = nombreMascotas.iterator();
        while (it.hasNext()) {
            if (it.next().equals(dogDelete)) {
                it.remove();
            }
        }
        if (dim==nombreMascotas.size()) {
            System.out.println("No se ha encontrado la mascota");
        }else{
            System.out.println("El perro " + dogDelete + " ha sido eliminado exitosamente....");
        }
        System.out.println("--------------");
        System.out.println("Lista de mascotas:");
        for (String a : nombreMascotas) {
            System.out.println("#"+a);
        }
    }
    

}
