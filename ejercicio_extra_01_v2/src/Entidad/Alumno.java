//Crea una clase Alumnos, donde tendrá como Atributos el nombre, apellido, la nacionalidad y 
//su fecha de nacimiento. La nacionalidad podrá ser ARGENTINA – CHILENA – VENEZOLANA
//solamente.


package Entidad;

import java.time.LocalDate;
import java.util.Objects;


//@author Facundo Cruz

public class Alumno {
    private String name;
    private String surname;
    private String nacinality;
    private LocalDate dateBorn;

    public Alumno() {
    }

    
    public Alumno(String name, String surname, String nacinality, LocalDate dateBorn) {
        this.name = name;
        this.surname = surname;
        this.nacinality = nacinality;
        this.dateBorn = dateBorn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNacinality() {
        return nacinality;
    }

    public void setNacinality(String nacinality) {
        this.nacinality = nacinality;
    }

    public LocalDate getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(LocalDate dateBorn) {
        this.dateBorn = dateBorn;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Surname: " + surname + ", Nacinality: " + nacinality + ", Date Born: " + dateBorn;
    }
    
    
    
}
