package ma.enset.iibdcc.Partie1.presentation;

import ma.enset.iibdcc.Partie1.dao.DaoImpl;
import ma.enset.iibdcc.Partie1.dao.IDoa;
import ma.enset.iibdcc.Partie1.metier.MetierImpl;

/**
 *  Instantiation Statique
 *  Cette Couche n'est pas fermé à la modification
 */
public class Presentation1 {

    public static void main(String[] args) {

        DaoImpl dao = new DaoImpl();
        //IDoa dao = new DaoImpl();
        MetierImpl metier=new MetierImpl(dao);//Injection des dépendances via le constructeur
        //metier.setDoa(dao);//Injection des dépendances via le Setter
        System.out.println("Résultat= "+metier.calcul());
    }

}
