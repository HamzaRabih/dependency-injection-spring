package ma.enset.iibdcc.presentation;

import ma.enset.iibdcc.metier.IMetier;
import ma.enset.iibdcc.metier.MetierImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class presSpringAnnotation {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ma.enset.iibdcc");

        IMetier metier = context.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}
