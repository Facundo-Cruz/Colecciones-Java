//Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El
//programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
//después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide
//salir, se mostrará todos los perros guardados en el ArrayList.

package ejercicio_01;

//@author Facundo Cruz

import java.util.*;


public class Ejercicio_01 {

    public static void main(String[] args) {
        List<String> nombreMascotas = new ArrayList();
        Scanner leer = new Scanner(System.in);
        char resp='s';
        while (resp!='n') {
            System.out.println("Ingrese el nombre de la mascota");
            String name = leer.next();
            nombreMascotas.add(name);
            System.out.println("¿Desea ingresar otro nombre?(S/N)");
            resp = leer.next().toLowerCase().charAt(0);
        }
        for (String aux : nombreMascotas) {
            System.out.println(aux);
        }
    }

}
