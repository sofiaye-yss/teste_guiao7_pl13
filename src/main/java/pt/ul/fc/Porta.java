package pt.ul.fc;

import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

/** Abrir e fechar uma porta com fechadura. */
@StateSet({"trancada", "fechada", "aberta", "partida"})
public class Porta {

    @StateRefinement(to="trancada()")
    public Porta() {}

    /** Arromba a porta (definitivo). */
    @StateRefinement(from="trancada() || fechada()", to="partida()")
    public void arrombar() {}

    /** Destranca a porta; fica fechada. */
    @StateRefinement(from="trancada()", to="fechada()")
    public void destrancar() {}

    /** Tranca a porta. */
    @StateRefinement(from="fechada()", to="trancada()")
    public void trancar() {}

    /** Abre a porta. */
    @StateRefinement(from="fechada()", to="aberta()")
    public void abrir() {}

    /** Fecha a porta. */
    @StateRefinement(from="aberta()", to="fechada()")
    public void fechar() {}
}
