/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

//@author Facundo Cruz

import java.util.Objects;



public class Pais{

    private String nombre;
    private double superficie;
    private long poblacion;

    public Pais() {
    }

    public Pais(String nombre, double superficie, long poblacion) {
        this.nombre = nombre;
        this.superficie = superficie;
        this.poblacion = poblacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public long getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(long poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.superficie) ^ (Double.doubleToLongBits(this.superficie) >>> 32));
        hash = 89 * hash + (int) (this.poblacion ^ (this.poblacion >>> 32));
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
        final Pais other = (Pais) obj;
        if (Double.doubleToLongBits(this.superficie) != Double.doubleToLongBits(other.superficie)) {
            return false;
        }
        if (this.poblacion != other.poblacion) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return "Pais: " + nombre + ", Superficie: " + superficie + ", Poblacion: " + poblacion;
    }


    
    
}
