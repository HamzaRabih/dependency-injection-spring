package ma.enset.iibdcc.extension;

import ma.enset.iibdcc.dao.IDoa;
import org.springframework.stereotype.Component;

@Component("d2")
public class DaoImplV2 implements IDoa {
    @Override
    public double getData() {
        System.out.println("Version capteur: ");
        double t=12;
        return t;
    }
}
