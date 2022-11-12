/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Alumno;
import Utilidad.Comparadores;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//@author Facundo Cruz
public class AlumnoService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void A(List<Alumno> listStudent) {
        char resp = 'S';
        while (resp == 'S') {
            Alumno a1 = new Alumno();
            System.out.println("Ingrese el nombre");
            a1.setName(leer.next());
            System.out.println("Ingrese el apellido");
            a1.setSurname(leer.next());
            modifyNacionality(a1);
            System.out.println("Ingrese la fecha de nacimiento(AA/MM/DD)");
            a1.setDateBorn(LocalDate.of(leer.nextInt(), leer.nextInt(), leer.nextInt()));
            listStudent.add(a1);
            System.out.println("¿Desea cargar otro alumno?(S/N)");
            resp = leer.next().toUpperCase().charAt(0);
        }
        System.out.println("------------------------------------------------------------------------------------------");
    }

    public void B(List<Alumno> listStudents) {

        char resp = 'S';
        while (resp == 'S') {
            boolean var = false;
            Alumno a1 = new Alumno();
            int index = searchStudent(listStudents);
            if (index == -1) {
                System.out.println("El alumno no ha sido encontrado. ¿Deseas intentarlo de nuevo?(S/N)");
                resp = leer.next().toUpperCase().charAt(0);
            } else {
                listStudents.remove(index);
                System.out.println("Alumno eliminado con éxito...");
                System.out.println("¿Deseas eliminar otro alumno?(S/N)");
                resp = leer.next().toUpperCase().charAt(0);
            }

        }
    }

    public void M(List<Alumno> listStudents) {
        int opcion;
        boolean var = false;
        int index = searchStudent(listStudents);
        if (index == -1) {
            System.out.println("El alumno no ha sido encontrado");
        } else {
            Alumno aux = listStudents.get(index);
            do {

                System.out.println("1 - Modificar nombre");
                System.out.println("2 - Modificar apellido");
                System.out.println("3 - Modificar nacionalidad");
                System.out.println("4 - Modificar fecha de nacimiento");
                System.out.println("5 - Salir");
                System.out.println("Elija su opcion:");
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nuevo nombre");
                        aux.setName(leer.next());
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo apellido");
                        aux.setSurname(leer.next());
                        break;
                    case 3:
                        modifyNacionality(aux);
                        break;
                    case 4:
                        System.out.println("Ingrese la fecha de nacimiento(AA/MM/DD)");
                        aux.setDateBorn(LocalDate.of(leer.nextInt(), leer.nextInt(), leer.nextInt()));
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

    public void loadInitialList(List<Alumno> listStudents) {
        listStudents.add(new Alumno("Pepe", "Argento", "Argentina", LocalDate.of(1990, 1, 1)));
        listStudents.add(new Alumno("Luana", "Moreno", "Chilena", LocalDate.of(1980, 2, 14)));
        listStudents.add(new Alumno("GISELA", "Paquilan", "Venezolana", LocalDate.of(1960, 7, 24)));
        listStudents.add(new Alumno("FLORENCIA", "Matta", "Argentina", LocalDate.of(1995, 5, 5)));
        listStudents.add(new Alumno("Laura", "Rezinovsky", "Venezolana", LocalDate.of(2000, 9, 1)));
        listStudents.add(new Alumno("Lucas", "ZARATE", "Chilena", LocalDate.of(2010, 10, 8)));
        listStudents.add(new Alumno("Irma", "GONZALEZ", "Venezolana", LocalDate.of(2002, 1, 16)));
        listStudents.add(new Alumno("Ariel", "LASTRO", "Argentina", LocalDate.of(1994, 7, 11)));
        listStudents.add(new Alumno("LUISA", "CAYLA", "Venezolana", LocalDate.of(1969, 4, 3)));
        listStudents.add(new Alumno("MARTINA", "Rosales", "Argentina", LocalDate.of(1995, 2, 26)));
        listStudents.add(new Alumno("FABIAN", "Gomez", "Argentina", LocalDate.of(1983, 8, 28)));
        listStudents.add(new Alumno("ROSA", "LORIA", "Venezolana", LocalDate.of(1979, 12, 14)));
        listStudents.add(new Alumno("Jonathan", "BARROS", "Argentina", LocalDate.of(1985, 1, 4)));
        listStudents.add(new Alumno("Ruben", "ROJAS", "Chilena", LocalDate.of(1991, 2, 1)));
        listStudents.add(new Alumno("Natalia", "VIDELA", "Venezolana", LocalDate.of(2003, 5, 19)));
        listStudents.add(new Alumno("Delfin", "Ingliso", "Chilena", LocalDate.of(1999, 10, 5)));
        listStudents.add(new Alumno("Elizabeth", "Caceres", "Argentina", LocalDate.of(1950, 1, 21)));
        listStudents.add(new Alumno("Nahir", "Quintero", "Argentina", LocalDate.of(1995, 3, 27)));
        listStudents.add(new Alumno("Emmanuel", "Ramirez", "Venezolana", LocalDate.of(1976, 4, 28)));
        listStudents.add(new Alumno("Antonella", "Pliva", "Chilena", LocalDate.of(2002, 9, 4)));
    }

    private int searchStudent(List<Alumno> listStudents) {
        System.out.println("Ingrese el nombre");
        String name = leer.next();
        System.out.println("Ingrese el apellido");
        String surname = leer.next();
        for (Alumno aux : listStudents) {
            if (aux.getName().equalsIgnoreCase(name) && aux.getSurname().equalsIgnoreCase(surname)) {
                return listStudents.indexOf(aux);
            }
        }
        return -1;
    }

    private void modifyNacionality(Alumno a1) {
        System.out.println("Ingrese la nacionalidad: \n 1-Argentina\n 2-Chilena\n 3-Venezolana");
        int opc = leer.nextInt();
        while (opc > 3 || opc < 1) {
            System.out.println("Error, ingrese una nacionalidad valida.");
            opc = leer.nextInt();
        }
        switch (opc) {
            case 1:
                a1.setNacinality("Argentina");
                break;
            case 2:
                a1.setNacinality("Chilena");
                break;
            case 3:
                a1.setNacinality("Venezolana");
                break;

        }
    }

    private void showList(List<Alumno> listStudent) {
        for (Alumno aux : listStudent) {
            System.out.println(aux);
        }
        System.out.println("------------------------------------------------------------------------------------------");
    }

    public void sortListAsc(List<Alumno> listStudent) {
        Collections.sort(listStudent, Comparadores.ordenarApellidoAsc);
        showList(listStudent);
    }

    public void sortListDesc(List<Alumno> listStudent) {
        Collections.sort(listStudent, Comparadores.ordenarApellidoDesc);
        showList(listStudent);
    }

    public void showStudentAge(List<Alumno> listStudent) {
        int index = searchStudent(listStudent);
        if (index == -1) {
            System.out.println("El alumno no ha sido encontrado");
            System.out.println("------------------------------------------------------------------------------------------");
        } else {
            int edad = calculateAge(listStudent.get(index).getDateBorn());
            System.out.println("El alumno tiene una edad de " + edad + " años");
            System.out.println("------------------------------------------------------------------------------------------");
        }
    }

    private int calculateAge(LocalDate fechaN) {
        LocalDate fActual = LocalDate.now();
        Period periodo = Period.between(fechaN, fActual);
        return periodo.getYears();
    }

    public void nacionalityList(List<Alumno> listStudents, List<Alumno> listArg, List<Alumno> listCh, List<Alumno> listVza) {

        for (Alumno aux : listStudents) {
            if (aux.getNacinality().equals("Argentina")) {
                listArg.add(aux);
            }
            if (aux.getNacinality().equals("Chilena")) {
                listCh.add(aux);
            }
            if (aux.getNacinality().equals("Venezolana")) {
                listVza.add(aux);
            }
        }
        System.out.println("Lista de argentinos:");
        showList(listArg);

        System.out.println("Lista de chilenos:");
        showList(listCh);

        System.out.println("Lista de venezolanos:");
        showList(listVza);

    }

    public void finalReport(List<Alumno> listStudents, int a, int c, int v) {
        int countAge = 0, countSurname = 0;
        for (Alumno aux : listStudents) {
            int age = calculateAge(aux.getDateBorn());
            if (age > 25) {
                countAge++;
            }
            if (aux.getSurname().charAt(0) == 'L' || aux.getSurname().charAt(0) == 'P') {
                countSurname++;
            }
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("\t«««INFORME FINAL»»»");
        System.out.println(" ¤ Hay " + countAge + " alumnos mayores a 25 años");
        System.out.println(" ¤ Hay " + countSurname + " alumnos con apellido inicial en \"P\" y/o \"L\"");
        System.out.println(" ¤ Hay " + a + " alumnos argentinos");
        System.out.println(" ¤ Hay " + c + " alumnos chilenos");
        System.out.println(" ¤ Hay " + v + " alumnos venezolanos");
        System.out.println("------------------------------------------------------------------------------------------");
    }
}
