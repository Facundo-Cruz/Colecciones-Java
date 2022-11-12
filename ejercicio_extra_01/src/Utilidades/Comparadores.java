/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Entidad.Alumno;
import java.util.Comparator;

//@author Facundo Cruz
public class Comparadores {

    public static Comparator<Alumno> ordenarAsc = new Comparator<Alumno>() {
        @Override
        public int compare(Alumno o1, Alumno o2) {
            return o1.getApellido().compareToIgnoreCase(o2.getApellido());
        }
    };
    public static Comparator<Alumno> ordenarDesc = new Comparator<Alumno>() {
        @Override
        public int compare(Alumno o1, Alumno o2) {
            return o2.getApellido().compareToIgnoreCase(o1.getApellido());
        }
    };
}
