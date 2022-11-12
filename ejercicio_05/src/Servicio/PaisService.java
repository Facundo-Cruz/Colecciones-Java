/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Pais;
import java.util.*;

//@author Facundo Cruz
public class PaisService {

    public void crearPais(Set<Pais> paises) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        char resp = 'S';
        while (resp != 'N') {
            Pais p1 = new Pais();
            System.out.println("Ingrese un país");
            p1.setNombre(leer.next());
            System.out.println("Ingrese su superficie");
            p1.setSuperficie(leer.nextDouble());
            System.out.println("Ingrese sus habitantes");
            p1.setPoblacion(leer.nextLong());
            paises.add(p1);
            System.out.println("¿Deseas ingresar otro país?(S/N)");
            resp = leer.next().toUpperCase().charAt(0);
        }
    }

    public void mostrarPaises(Collection<Pais> paises) {
        for (Pais aux : paises) {
            System.out.println(aux);
        }
    }
    
    public boolean eliminarPais(Set<Pais> paises, String nombreP){
        Iterator<Pais> it = paises.iterator();
        while (it.hasNext()) {
            if (it.next().getNombre().equalsIgnoreCase(nombreP)) {
                it.remove();
                return true;
            }
        }
        return false;
    }
    public static Comparator<Pais> ordendarAlfabeticamente = new Comparator<Pais>() {
        @Override
        public int compare(Pais o1, Pais o2) {
            return o1.getNombre().toLowerCase().compareTo(o2.getNombre().toLowerCase());
        }
    };
 
}
