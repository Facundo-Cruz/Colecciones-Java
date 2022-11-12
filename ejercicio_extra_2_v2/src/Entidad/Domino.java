/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;

import Servicio.DominoService;
import java.util.LinkedList;


//@author Facundo Cruz

public class Domino {
    LinkedList<Ficha> mano;
    LinkedList<Ficha> mesa;
    private static final int MAX_NUM = 5;

    public Domino() {
        DominoService sv = new DominoService();
        this.mano = new LinkedList();
        this.mesa = new LinkedList();
        sv.crearFichas(this.mano, this.mesa);
    }
    
    public LinkedList<Ficha> getMano() {
        return mano;
    }

    public void setMano(LinkedList<Ficha> mano) {
        this.mano = mano;
    }

    public LinkedList<Ficha> getMesa() {
        return mesa;
    }

    public void setMesa(LinkedList<Ficha> mesa) {
        this.mesa = mesa;
    }

    public static int getMAX_NUM() {
        return MAX_NUM;
    }
    
}
