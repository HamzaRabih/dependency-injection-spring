package ma.enset.iibdcc.Partie1.extension;

import ma.enset.iibdcc.Partie1.dao.IDoa;

public class DaoImplV2 implements IDoa {
    @Override
    public double getData() {
        System.out.println("Version capteur: ");
        double t=12;
        return t;
    }
}
