package ma.enset.iibdcc.Partie1.presentation;

import ma.enset.iibdcc.Partie1.dao.IDoa;
import ma.enset.iibdcc.Partie1.metier.IMetier;

import java.io.File;
import java.util.Scanner;
/**
 *  Instantiation Dynamique
 */
public class Presentation2 {
    //FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("config.txt"));

        String daoClassName = sc.nextLine();//Lire la 1er ligne
        Class cDao=Class.forName(daoClassName);//Pour créer une Classe à partir de ce nom

        /**
         * C'est comme IDoa d = new DaoImpl();
         * pour utiliser les implementation de la class DaoImpl
         */
        IDoa dao = (IDoa) cDao.newInstance();
        System.out.println(dao.getData());

        String metierClassName = sc.nextLine();//Lire la 1er ligne
        Class cMetier=Class.forName(metierClassName);//Pour créer une Classe à partir de ce nom
        IMetier metier = (IMetier) cMetier.getConstructor(IDoa.class).newInstance(dao);
        System.out.println("Résultat:  "+metier.calcul());
    }
}
