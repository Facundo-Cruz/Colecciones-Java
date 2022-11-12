

package ejercicio_extra_2_v3;

//@author Facundo Cruz

import Entidad.Domino;
import Servicio.DominoService;


public class Ejercicio_extra_2_v2 {

    public static void main(String[] args) {
        Domino d1 = new Domino();
        DominoService sv = new DominoService();
        sv.jugar(d1);
    }

}
