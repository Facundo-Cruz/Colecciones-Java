//Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos
//productos que venderemos y el precio que tendrán. Además, se necesita que la
//aplicación cuente con las funciones básicas.
//Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio,
//eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
//Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
//Realizar un menú para lograr todas las acciones previamente mencionadas.

package ejercicio_06;

//@author Facundo Cruz

import Servicio.Service;
import java.util.*;


public class Ejercicio_06 {

    public static void main(String[] args) {
        Map<String, Integer> almacen = new HashMap();
        Scanner leer = new Scanner(System.in);
        Service sv = new Service();
        int opcion;
        do {
            System.out.println("\t.:Menu:.");
            System.out.println("1 - Agregar producto");
            System.out.println("2 - Modificar precio");
            System.out.println("3 - Eliminar producto");
            System.out.println("4 - Mostrar almacen");
            System.out.println("5 - Salir");
            System.out.println("Elija su opcion:");
            opcion = leer.nextInt();
            
            switch (opcion) {
                case 1:
                    sv.agregarProductos(almacen);
                    break;
                case 2:
                    sv.modificarPrecio(almacen);
                    break;
                case 3:
                    sv.eliminarProducto(almacen);
                    break;
                case 4:
                    sv.mostrarAlmacen(almacen);
                    break;
                case 5:
                    System.out.println("Hasta Luego...");
                    break;
                default:
                    System.out.println("Esa no es una opcion valida, vuelva a intentar...");
                    break;
            }
        } while (opcion != 5);
     
    }

}
