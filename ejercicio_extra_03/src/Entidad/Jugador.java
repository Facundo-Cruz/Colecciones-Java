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
package Entidad;

import java.util.Objects;


public class Jugador {
    private String jugador;

    public Jugador() {
    }

    public Jugador(String jugador) {
        this.jugador = jugador.toUpperCase();
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador.toUpperCase();
    }

    @Override
    public String toString() {
        return "jugador: " + jugador ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.jugador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        if (!Objects.equals(this.jugador, other.jugador)) {
            return false;
        }
        return true;
    }
    
}
