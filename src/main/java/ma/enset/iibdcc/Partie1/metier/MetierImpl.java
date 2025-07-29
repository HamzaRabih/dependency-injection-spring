package ma.enset.iibdcc.Partie1.metier;

import ma.enset.iibdcc.Partie1.dao.IDoa;

public class MetierImpl implements IMetier {

    private IDoa doa;

    /**
     * Pour injecter dans l'attribut dao
     * un objet d'une class qui implémente l'interface IDao
     * au moment de l'instantiation de l'objet MetierImpl
     */
    public MetierImpl(IDoa doa) {
        this.doa = doa;
    }

    public MetierImpl() {
    }

    @Override
    public double calcul() {
        double t=doa.getData();
        double resultat=t*12*Math.PI/2*Math.cos(t);
        return resultat;
    }

    /**
     * !! Mauvaise Pratique
     * Pour injecter dans l'attribut dao
     * un objet d'une class qui implémente l'interface IDao
     * après l'instantiation de l'objet MetierImpl
     */

    public void setDoa(IDoa doa) {
        this.doa = doa;
    }
}
