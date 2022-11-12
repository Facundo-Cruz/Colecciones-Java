package Entidad;

import java.util.ArrayList;
import java.util.List;

//@author Facundo Cruz
public class Domino {

    private List<Ficha> mano;
    private List<Ficha> mesa;
    private static final int MAX_NUM = 3;

    public Domino() {
        this.mano = new ArrayList();
        this.mesa = new ArrayList();
        for (int i = 0; i <= MAX_NUM; i++) {
            for (int j = 0; j <= MAX_NUM; j++) {
                Ficha f1 = new Ficha(i, j);
                Ficha f2 = f1.girarFicha(f1);
                boolean aux = true;
                if (i == MAX_NUM && i == j) {
                    mesa.add(f1);
                    break;
                }
                for (Ficha ficha : mano) {
                    if (ficha.getNumIzq() == f2.getNumIzq() && ficha.getNumDer() == f2.getNumDer()) {
                        aux = false;
                    }
                }
                if (aux) {
                    this.mano.add(f1);
                }

            }
        }
    }

    public void jugar() {
        System.out.println("run:(MAX_NUM = " + MAX_NUM + ")");
        boolean var = true;
        int pos = 1;
        while (pos == 1) {
            var = false;
            System.out.print("mano(" + mano.size() + "): ");
            for (Ficha ficha : mano) {
                System.out.print(ficha);
            }
            System.out.println("");
            System.out.print("mesa(" + mesa.size() + "): ");
            for (Ficha ficha : mesa) {
                System.out.print(ficha);
            }
            System.out.println("");
            int index = -1;
            int izqMax = mesa.get(0).getNumIzq();
            int derMax = mesa.get(mesa.size() - 1).getNumDer();
            for (Ficha aux : mano) {
                if (izqMax == aux.getNumDer()) {
                    var = true;
                    index = mano.indexOf(aux);
                    break;
                }

                Ficha aux2 = aux.girarFicha(aux);
                if (izqMax == aux2.getNumDer()) {
                    var = true;
                    index = mano.indexOf(aux);
                    int help = aux.getNumDer();
                    aux.setNumDer(aux.getNumIzq());
                    aux.setNumIzq(help);
                    break;
                }

            }
            if (!var) {
                for (Ficha aux : mano) {
                    if (derMax == aux.getNumIzq()) {
                        var = false;
                        index = mano.indexOf(aux);
                        break;
                    }
                    Ficha aux2 = aux.girarFicha(aux);
                    if (derMax == aux2.getNumIzq()) {
                        var = false;
                        index = mano.indexOf(aux);
                        int help = aux.getNumDer();
                        aux.setNumDer(aux.getNumIzq());
                        aux.setNumIzq(help);
                        break;
                    }
                }
            }
            if (index == -1) {
                pos = 0;
            } else if (var) {
                mesa.add(0, mano.get(index));
                mano.remove(index);
            } else {
                mesa.add(mano.get(index));
                mano.remove(index);
            }
        }
    }

    public static int getMAX_NUM() {
        return MAX_NUM;
    }

    public List<Ficha> getListaFichas() {
        return mano;
    }

}
