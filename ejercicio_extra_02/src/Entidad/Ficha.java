/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

//@author Facundo Cruz
public class Ficha {

    private int numIzq;
    private int numDer;

    public Ficha() {
    }

    public Ficha(int numIzq, int numDer) {
        this.numIzq = numIzq;
        this.numDer = numDer;
    }

    public int getNumIzq() {
        return numIzq;
    }

    public void setNumIzq(int numIzq) {
        this.numIzq = numIzq;
    }

    public int getNumDer() {
        return numDer;
    }

    public void setNumDer(int numDer) {
        this.numDer = numDer;
    }

    public Ficha girarFicha(Ficha f1) {
        return new Ficha(f1.getNumDer(), f1.getNumIzq());
    }

    public boolean esUnDoble(Ficha f1) {
        return f1.getNumDer() == f1.getNumIzq();
    }

    @Override
    public String toString() {
        return this.numIzq + ":" + this.numDer + "|";
    }

}
