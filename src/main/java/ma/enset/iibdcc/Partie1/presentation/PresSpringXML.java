package ma.enset.iibdcc.Partie1.presentation;

import ma.enset.iibdcc.Partie1.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresSpringXML {
    public static void main(String[] args) {
        ApplicationContext SpringContext =
                new ClassPathXmlApplicationContext("config.xml");
        IMetier metier = (IMetier) SpringContext.getBean("metier");
        System.out.println(metier.calcul());
    }
}
