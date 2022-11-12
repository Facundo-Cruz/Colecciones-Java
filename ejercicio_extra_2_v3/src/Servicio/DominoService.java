/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Domino;
import Entidad.Ficha;
import java.util.ArrayList;
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

    public int numMaxIzq(List<Ficha> aux) {
        return aux.get(0).getNumIzq();
    }

    public int numMaxDer(List<Ficha> aux) {
        return aux.get(aux.size() - 1).getNumDer();
    }

    public int calcularIndiceDerecha(List<Ficha> mano, int maxDerecha) {
        int aux = -1;
        for (Ficha ficha : mano) {
            if (ficha.getNumIzq() == maxDerecha) {
                aux = mano.indexOf(ficha);
                break;
            }
            ficha = sv.girarFicha(ficha);
            if (ficha.getNumIzq() == maxDerecha) {
                aux = mano.indexOf(ficha);
                break;
            }
            ficha = sv.girarFicha(ficha);
        }
        
        return aux;
    }

    public int calcularIndiceIzquierda(List<Ficha> mano, int maxIzquierda) {
        int aux = -1;
        for (Ficha ficha : mano) {
            if (ficha.getNumDer() == maxIzquierda) {
                aux = mano.indexOf(ficha);
                break;
            }
            ficha = sv.girarFicha(ficha);
            if (ficha.getNumDer() == maxIzquierda) {
                aux = mano.indexOf(ficha);
                break;
            }
            ficha = sv.girarFicha(ficha);
        }
        return aux;
    }

    public int busquedaIzq(List<Ficha> mano, List<Ficha> mesa) {
        int aux = -1;
        if (mano.size() > 1) {
            int maxIzq = numMaxIzq(mesa);
            aux = calcularIndiceIzquierda(mano, maxIzq);
            if (aux != -1) {
                List<Ficha> mano2 = new ArrayList(mano);
                List<Ficha> mesa2 = new ArrayList(mesa);
                mesa2.add(0, mano2.get(aux));
                mano2.remove(aux);
                int maxIzq2 = numMaxIzq(mesa2);
                int aux2 = calcularIndiceIzquierda(mano2, maxIzq2);
                if (aux2 == -1) {
                    int maxDer = numMaxDer(mesa2);
                    aux2 = calcularIndiceDerecha(mano2, maxDer);
                }
                if (aux2 == -1) {
                    aux = -1;
                }

            }
        }
        return aux;
    }

    public int busquedaDer(List<Ficha> mano, List<Ficha> mesa) {
        int aux = -1;
        if (mano.size() > 1) {
            int maxDer = numMaxDer(mesa);
            aux = calcularIndiceDerecha(mano, maxDer);
            if (aux != -1) {
                List<Ficha> mano2 = new ArrayList(mano);
                List<Ficha> mesa2 = new ArrayList(mesa);
                mesa2.add(mano2.get(aux));
                mano2.remove(aux);
                int maxDer2 = numMaxDer(mesa2);
                int aux2 = calcularIndiceDerecha(mano2, maxDer2);
                if (aux2 == -1) {
                    int maxIzq = numMaxIzq(mano2);
                    aux2 = calcularIndiceIzquierda(mano2, maxIzq);

                }
                if (aux2 == -1) {
                    aux = -1;
                }

            }
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
            int index = busquedaIzq(d1.getMano(), d1.getMesa());
            if (index != -1) {
                d1.getMesa().add(0, d1.getMano().get(index));
                d1.getMano().remove(index);
                verif = true;
            }
            if (!verif) {
                index = busquedaDer(d1.getMano(), d1.getMesa());
                if (index != -1) {
                    d1.getMesa().add(d1.getMano().get(index));
                    d1.getMano().remove(index);
                    verif = true;
                }
            }
            if (index == -1) {
                index = calcularIndiceDerecha(d1.getMano(), numMaxDer(d1.getMesa()));
                if (index == -1) {
                    index = calcularIndiceIzquierda(d1.getMano(), numMaxIzq(d1.getMesa()));
                    if (index != -1) {
                        d1.getMesa().add(0, d1.getMano().get(index));
                        d1.getMano().remove(index);
                        verif = true;
                    }
                } else {
                    d1.getMesa().add(d1.getMano().get(index));
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
