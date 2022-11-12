/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidad;

import Servicio.DominoService;
import java.util.ArrayList;
import java.util.List;


//@author Facundo Cruz

public class Domino {
    List<Ficha> mano;
    List<Ficha> mesa;
    private static final int MAX_NUM = 3;

    public Domino() {
        DominoService sv = new DominoService();
        this.mano = new ArrayList();
        this.mesa = new ArrayList();
        sv.crearFichas(this.mano, this.mesa);
    }
    
    public List<Ficha> getMano() {
        return mano;
    }

    public void setMano(List<Ficha> mano) {
        this.mano = mano;
    }

    public List<Ficha> getMesa() {
        return mesa;
    }

    public void setMesa(List<Ficha> mesa) {
        this.mesa = mesa;
    }

    public static int getMAX_NUM() {
        return MAX_NUM;
    }
    
}
