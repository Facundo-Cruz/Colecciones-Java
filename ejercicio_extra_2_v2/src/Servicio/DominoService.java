/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Domino;
import Entidad.Ficha;
import java.util.List;

//@author Facundo Cruz
public class DominoService {

    FichaService sv = new FichaService();

    public void crearFichas(List<Ficha> mano, List<Ficha> mesa) {
        for (int i = 0; i <= Domino.getMAX_NUM(); i++) {
            for (int j = 0; j <= Domino.getMAX_NUM(); j++) {
                // 0:1 1:0 
                Ficha f1 = new Ficha(i, j);
                if (i == j && j == Domino.getMAX_NUM()) {
                    mesa.add(f1);
                    break;
                }
                Ficha fAux = sv.crearFichaInvertida(f1);
                boolean var = buscarFicha(mano, fAux);
                if (!var) {
                    mano.add(f1);
                }
            }
        }

    }

    public boolean buscarFicha(List<Ficha> totalFichas, Ficha f1) {
        boolean var = false;
        for (Ficha aux : totalFichas) {
            if (aux.getNumDer() == f1.getNumDer() && aux.getNumIzq() == f1.getNumIzq()) {
                var = true;
                break;
            }
        }
        return var;
    }

    public void imprimirFichas(List<Ficha> fichas) {
        for (Ficha ficha : fichas) {
            System.out.print(ficha);
        }
        System.out.println("");
    }

    public int busquedaIzq(List<Ficha> mano, int maxIzq) {
        int aux = -1;
        for (Ficha ficha : mano) {
            if (ficha.getNumDer() == maxIzq) {
                aux = mano.indexOf(ficha);
                break;
            }
            ficha = sv.girarFicha(ficha);
            if (ficha.getNumDer() == maxIzq) {
                aux = mano.indexOf(ficha);
                break;
            }
            ficha = sv.girarFicha(ficha);
        }
        return aux;
    }

    public int busquedaDer(List<Ficha> mano, int maxDer) {
        int aux = -1;
        for (Ficha ficha : mano) {
            if (ficha.getNumIzq() == maxDer) {
                aux = mano.indexOf(ficha);
                break;
            }
            ficha = sv.girarFicha(ficha);
            if (ficha.getNumIzq() == maxDer) {
                aux = mano.indexOf(ficha);
                break;
            }
            ficha = sv.girarFicha(ficha);
        }
        return aux;
    }

    public void jugar(Domino d1) {
        
        boolean gameOver = false;
        System.out.println("run: (MAX_NUM = " + Domino.getMAX_NUM() + ")");
        while (!gameOver) {
            System.out.print("mano(" + d1.getMano().size() + "): ");
            imprimirFichas(d1.getMano());
            System.out.print("mesa(" + d1.getMesa().size() + "): ");
            imprimirFichas(d1.getMesa());
            boolean verif = false;
            int maxIzq = d1.getMesa().getFirst().getNumIzq();
            int maxDer = d1.getMesa().getLast().getNumDer();
            int index = busquedaIzq(d1.getMano(), maxIzq);
            if (index != -1) {
                d1.getMesa().addFirst(d1.getMano().get(index));
                d1.getMano().remove(index);
                verif = true;
            }
            if (!verif) {
                index = busquedaDer(d1.getMano(), maxDer);
                if (index != -1) {
                    d1.getMesa().addLast(d1.getMano().get(index));
                    d1.getMano().remove(index);
                    verif = true;
                }
            }
            if (!verif) {
                gameOver = true;
            }

        }

    }
}
