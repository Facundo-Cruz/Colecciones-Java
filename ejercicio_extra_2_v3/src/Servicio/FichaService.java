/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Ficha;

//@author Facundo Cruz
public class FichaService {

    public Ficha girarFicha(Ficha f1) {
        int aux = f1.getNumDer();
        f1.setNumDer(f1.getNumIzq());
        f1.setNumIzq(aux);
        return f1;
    }
    
    public Ficha crearFichaInvertida(Ficha f1){
        return new Ficha(f1.getNumDer(), f1.getNumIzq());
    }
    public boolean esUnDoble(Ficha f1) {
        return f1.getNumDer() == f1.getNumIzq();
    }
}
