

package Servicio;

import java.util.Map;
import java.util.Scanner;


//@author Facundo Cruz

public class Service {
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public void agregarProductos(Map<String,Integer> almacen){
            System.out.println("Ingrese el nombre del producto");
            String nombreP = leer.next();
            System.out.println("Ingrese el precio del producto");
            int precioP = leer.nextInt();
            almacen.put(nombreP, precioP);
            System.out.println("Producto agregado con éxito");
    }
    
    public void modificarPrecio(Map<String,Integer> almacen){
        System.out.println("Ingrese el nombre del producto a modificar su precio");
        String nombreP = leer.next();
        boolean var = almacen.containsKey(nombreP);
        if (var) {
            System.out.println("Ingrese el nuevo precio");
            int precioN = leer.nextInt();
            almacen.replace(nombreP, precioN);
            System.out.println("Producto modificado con éxito");
        }else{
            System.out.println("Ese producto no existe");
        }
    }
    
    public void eliminarProducto(Map<String, Integer> almacen){
        System.out.println("Ingrese el nombre del producto a eliminar");
        String nombreP = leer.next();
        boolean var = almacen.containsKey(nombreP);
        if (var) {
            almacen.remove(nombreP);
            System.out.println("Producto eliminado con éxito");
        }else{
            System.out.println("El producto ingresado no existe");
        }
    }
    public void mostrarAlmacen(Map<String,Integer> almacen){
        System.out.println("\tAlmacen");
        for (Map.Entry<String, Integer> entry : almacen.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " -->" + " $"+value );
        }
    }
        
}
