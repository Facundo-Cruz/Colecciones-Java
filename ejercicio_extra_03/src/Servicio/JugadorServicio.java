/*
Crea un conjunto al que se le va a llamar jugadores. Inserta en el conjunto los jugadores del FC 
Barcelona.
Realiza un bucle sobre los jugadores del conjunto y muestra sus nombres.
Consulta si en el conjunto existe el jugador «Neymar JR». Avisa si existe o no.
Crea un segundo conjunto jugadores2 con los jugadores «Piqué» y «Busquets».
Consulta si todos los elementos de jugadores2 existen en jugadores.
Realiza una unión de los conjuntos jugadores y jugadores2.
Elimina todos los jugadores del conjunto jugadores2 y muestra el número de jugadores que tiene 
el conjunto jugadores2 (debería ahora ser cero
 */
package Servicio;

import Entidad.Jugador;
import java.util.HashSet;
import java.util.Scanner;

public class JugadorServicio {

    HashSet<Jugador> j2 = new HashSet();
    HashSet<Jugador> j1 = new HashSet();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void cargar() {

        String opc = "";
        do {
            System.out.println("Ingrese el jugador");
            Jugador j = new Jugador();
            j.setJugador(leer.next());
            j1.add(j);
            System.out.println("Desea ingresar otro jugador(Si/No)");
            opc = leer.next();
        } while (!opc.equalsIgnoreCase("no"));

    }

    public void mostrarJugadores() {
        int cont = 0;
        for (Jugador aux : j1) {
            System.out.println(aux);
            if (aux.getJugador().equalsIgnoreCase("Neymar Jr")) {
                cont++;
            }
        }
        if (cont != 0) {
            System.out.println("Neymar Jr esta en cancha!!!");
        } else {
            System.out.println("Neymar Jr se quedo afuera");
        }

    }

    public void segundoSet() {
        Jugador j = new Jugador();
        j.setJugador("Pique");
        j2.add(j);
        Jugador h = new Jugador();
        h.setJugador("Busquets");
        j2.add(h);
        if (j1.containsAll(j2)) {
            System.out.println("Los jugadores de la lista dos se encuentran tambien en lista uno");
        } else {
            System.out.println("Los jugadores de lista dos no estan en lista uno tal vez no todos tal vez ninguno saludos" );

        }

    }

    public void unirList() {
        j1.addAll(j2);
        j2.removeAll(j1);
        System.out.println(j2.size());
    }
}
