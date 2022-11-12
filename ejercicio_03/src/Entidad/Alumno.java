//Crear una clase llamada Alumno que mantenga información sobre las notas de distintos
//alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer
//con sus 3 notas.

package Entidad;

import java.util.*;


//@author Facundo Cruz

public class Alumno {
    private String nombre;
    private List<Integer> notas;

    public Alumno() {
        this.notas = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Integer> getNotas() {
        return notas;
    }

    public void setNotas(Integer nota) {
        this.notas.add(nota);
    }
    
    
}
