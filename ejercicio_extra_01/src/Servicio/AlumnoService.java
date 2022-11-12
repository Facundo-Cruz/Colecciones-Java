/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Alumno;
import Utilidades.Comparadores;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//@author Facundo Cruz
public class AlumnoService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void A(ArrayList<Alumno> listaAlumnos) {

//ArrayList<Alumno> listaNueva
//        for (Alumno aux : listaNueva) {
//            listaAlumnos.add(aux);
//        }
        listaAlumnos.add(new Alumno("Pepe", "Argento", "Argentina", LocalDate.of(1990, 1, 1)));
        listaAlumnos.add(new Alumno("Luana", "Moreno", "Chilena", LocalDate.of(1980, 2, 14)));
        listaAlumnos.add(new Alumno("GISELA", "Paquilan", "Venezolana", LocalDate.of(1960, 7, 24)));
        listaAlumnos.add(new Alumno("FLORENCIA", "Matta", "Argentina", LocalDate.of(1995, 5, 5)));
        listaAlumnos.add(new Alumno("Laura", "Rezinovsky", "Venezolana", LocalDate.of(2000, 9, 1)));
        listaAlumnos.add(new Alumno("Lucas", "ZARATE", "Chilena", LocalDate.of(2010, 10, 8)));
        listaAlumnos.add(new Alumno("Irma", "GONZALEZ", "Venezolana", LocalDate.of(2002, 1, 16)));
        listaAlumnos.add(new Alumno("Ariel", "LASTRO", "Argentina", LocalDate.of(1994, 7, 11)));
        listaAlumnos.add(new Alumno("LUISA", "CAYLA", "Venezolana", LocalDate.of(1969, 4, 3)));
        listaAlumnos.add(new Alumno("MARTINA", "Rosales", "Argentina", LocalDate.of(1995, 2, 26)));
        listaAlumnos.add(new Alumno("FABIAN", "Gomez", "Argentina", LocalDate.of(1983, 8, 28)));
        listaAlumnos.add(new Alumno("ROSA", "LORIA", "Venezolana", LocalDate.of(1979, 12, 14)));
        listaAlumnos.add(new Alumno("Jonathan", "BARROS", "Argentina", LocalDate.of(1985, 1, 4)));
        listaAlumnos.add(new Alumno("Ruben", "ROJAS", "Chilena", LocalDate.of(1991, 2, 1)));
        listaAlumnos.add(new Alumno("Natalia", "VIDELA", "Venezolana", LocalDate.of(2003, 5, 19)));
        listaAlumnos.add(new Alumno("Delfin", "Ingliso", "Chilena", LocalDate.of(1999, 10, 5)));
        listaAlumnos.add(new Alumno("Elizabeth", "Caceres", "Argentina", LocalDate.of(1950, 1, 21)));
        listaAlumnos.add(new Alumno("Nahir", "Quintero", "Argentina", LocalDate.of(1995, 3, 27)));
        listaAlumnos.add(new Alumno("Emmanuel", "Ramirez", "Venezolana", LocalDate.of(1976, 4, 28)));
        listaAlumnos.add(new Alumno("Antonella", "Pliva", "Chilena", LocalDate.of(2002, 9, 4)));

    }

    public void mostrarLista(ArrayList<Alumno> listaAlumnos) {
        for (Alumno aux : listaAlumnos) {
            System.out.println(aux);
        }
    }

    public void ordenarListaAsc(ArrayList<Alumno> listaAlumnos) {
        Collections.sort(listaAlumnos, Comparadores.ordenarAsc);
        mostrarLista(listaAlumnos);

    }

    public void ordenarListaDesc(ArrayList<Alumno> listaAlumnos) {
        Collections.sort(listaAlumnos, Comparadores.ordenarDesc);
        mostrarLista(listaAlumnos);

    }

    public void mostrarAlumno(ArrayList<Alumno> listaAlumnos) {
        System.out.println("Ingrese el nombre del alumno");
        String nombre = leer.next();
        System.out.println("Ingrese el apellido");
        String apellido = leer.next();
        boolean var = false;
        for (Alumno aux : listaAlumnos) {
            if (aux.getNombre().equalsIgnoreCase(nombre) && aux.getApellido().equalsIgnoreCase(apellido)) {
                LocalDate fNacimiento = aux.getFechaNacimiento();
                System.out.println("La edad del alumno es: " + calcularEdad(fNacimiento));
                var = true;
                break;
            }
        }
        // if("si esta expresión es verdadera se ejecuta el primer bloque") -->
        // if (var) -->
        // if (!var) -->
        if (!var) {
            System.out.println("El alumno no ha sido encontrado");
        }
    }
    public int calcularEdad(LocalDate fechaN){
        LocalDate fActual = LocalDate.now();
        Period periodo = Period.between(fechaN, fActual);
        return periodo.getYears();
    }

    public void listarNacionalidad(ArrayList<Alumno> listaAlumno) {

        ArrayList<Alumno> alumnosArg = new ArrayList();

        for (Alumno aux : listaAlumno) {
            if (aux.getNacionalidad().equalsIgnoreCase("Argentina")) {
                alumnosArg.add(aux);

            }
        }
        ArrayList<Alumno> alumnosVen = new ArrayList();
        for (Alumno aux : listaAlumno) {
            if (aux.getNacionalidad().equalsIgnoreCase("Venezolana")) {
                alumnosVen.add(aux);
            }
        }
        ArrayList<Alumno> alumnosCh = new ArrayList();
        for (Alumno aux : listaAlumno) {
            if (aux.getNacionalidad().equalsIgnoreCase("Chilena")) {
                alumnosCh.add(aux);
            }
        }
        int contM = 0, contInicial = 0;
        for (Alumno aux : listaAlumno) {
            if (calcularEdad(aux.getFechaNacimiento())>25) {
                contM++;
            }
            if (aux.getApellido().charAt(0)=='L' || aux.getApellido().charAt(0)=='P') {
                contInicial++;
            }
            
        }

        System.out.println("REPORTE: ");
        System.out.println("Hay "+contM+" alumnos mayores a 25 años");
        System.out.println("Hay "+contInicial+ " alumnos con apellido incial de letra \"L\" y/o \"P\"");
        System.out.println("Hay "+alumnosArg.size()+" alumnos Argentinos");
        System.out.println("Hay "+alumnosVen.size()+" alumnos Venezolanos");
        System.out.println("Hay "+alumnosCh.size()+" alumnos Chilenos");
      //  mostrarLista(alumnosArg);
       // mostrarLista(alumnosVen);
       // mostrarLista(alumnosCh);
            
    }

    public void B(ArrayList<Alumno> listaAlumnos) {
        System.out.println("Ingrese el nombre del alumno a eliminar");
        String nombre = leer.next();
        System.out.println("Ingrese el apellido");
        String apellido = leer.next();
        boolean var = false;
        for (Alumno aux : listaAlumnos) {
            if (aux.getNombre().equalsIgnoreCase(nombre) && aux.getApellido().equalsIgnoreCase(apellido)) {
                listaAlumnos.remove(aux);
                var = true;
                System.out.println("Alumno eliminado con éxito");
                break;
            }
        }
      
        if (!var) {
            System.out.println("El alumno no ha sido encontrado");
        }
    }

    public void M(ArrayList<Alumno> listaAlumnos) {
        System.out.println("Ingrese el nombre del alumno a modificar");
        String nombre = leer.next();
        System.out.println("Ingrese el apellido");
        String apellido = leer.next();
        boolean var = false;
        for (Alumno aux : listaAlumnos) {
            if (aux.getNombre().equalsIgnoreCase(nombre) && aux.getApellido().equalsIgnoreCase(apellido)) {
                var = true;
                int opcion;
                do {
                    System.out.println("\t.:Menu:.");
                    System.out.println("1 - Editar nombre");
                    System.out.println("2 - Editar apellido");
                    System.out.println("3 - Editar nacionalidad");
                    System.out.println("4 - Editar fecha de nacimiento");
                    System.out.println("5 - Salir");
                    System.out.println("Elija su opcion:");
                    opcion = leer.nextInt();
                    
                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese el nuevo nombre");
                            aux.setNombre(leer.next());
                            break;
                        case 2:
                            System.out.println("Ingrese el nuevo apellido");
                            aux.setApellido(leer.next());
                            break;
                        case 3:
                            System.out.println("Ingrese la nueva nacionalidad");
                            aux.setNacionalidad(leer.next());
                            break;
                        case 4:
                            System.out.println("Ingrese la nueva fecha de nacimiento(año/mes/dia)");
                            aux.setFechaNacimiento(LocalDate.of(leer.nextInt(), leer.nextInt(), leer.nextInt()));
                            break;
                        case 5:
                            System.out.println("Hasta Luego...");
                            break;
                        default:
                            System.out.println("Esa no es una opcion valida, vuelva a intentar...");
                            break;
                    }
                } while (opcion != 5);
                break;
            }
        }
      
        if (var) {
            System.out.println("El alumno no ha sido encontrado");
        }
    }
}
