/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Entidad.Pelicula;
import java.util.Comparator;

//@author Facundo Cruz
public class Comparadores {

    public static Comparator<Pelicula> duracionMayorAMenor = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula o1, Pelicula o2) {
            return o2.getDuracion().compareTo(o1.getDuracion());
        }

    };
    public static Comparator<Pelicula> duracionMenorAMayor = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula o1, Pelicula o2) {
            return o1.getDuracion().compareTo(o2.getDuracion());
        }

    };
    public static Comparator<Pelicula> tituloAlfabeticamente = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula o1, Pelicula o2) {
            return o1.getTitulo().toLowerCase().compareTo(o2.getTitulo().toLowerCase());
        }

    };
    public static Comparator<Pelicula> directorAlfabeticamente = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula o1, Pelicula o2) {
            return o1.getDirector().toLowerCase().compareTo(o2.getDirector().toLowerCase());
        }

    };

}
