/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilidad;

import Entidad.Alumno;
import java.util.Comparator;


//@author Facundo Cruz

public class Comparadores {
    public static Comparator<Alumno> ordenarApellidoAsc = new Comparator<Alumno>(){
        @Override
        public int compare(Alumno o1, Alumno o2) {
            return o1.getSurname().compareToIgnoreCase(o2.getSurname());
        }
        
    };
    public static Comparator<Alumno> ordenarApellidoDesc = new Comparator<Alumno>(){
        @Override
        public int compare(Alumno o1, Alumno o2) {
            return o2.getSurname().compareToIgnoreCase(o1.getSurname());
        }
        
    };
}
