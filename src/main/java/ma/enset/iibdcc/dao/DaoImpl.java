package ma.enset.iibdcc.dao;

import org.springframework.stereotype.Component;

@Component("d")
public class DaoImpl implements IDoa{
    @Override
    public double getData() {
        System.out.println("Version BDD: ");
        double t=37;
        return t;
    }
}
