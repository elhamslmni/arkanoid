package Gift;

import Logic.Mainpanel;

import java.util.ArrayList;
import java.util.Random;

public class random extends Gift{
    ArrayList<Gift> gifts=new ArrayList<>();
    public random() {
        super();
        type=3;
        atashin atshin=new atashin();
        chandgane chandgane=new chandgane();
        takhtekuchak takhtekuchak=new takhtekuchak();
        takhtegij takhtegij=new takhtegij();
        takhtebzrg takhtebzrg=new takhtebzrg();
        toopsari toopsari=new toopsari();
        toopkond toopkond=new toopkond();
        gifts.add(atshin);
        gifts.add(toopkond);
        gifts.add(toopsari);
        gifts.add(takhtebzrg);
        gifts.add(takhtekuchak);
        gifts.add(takhtegij);
        gifts.add(chandgane);
    }

    @Override
    public void function(Mainpanel mainpanel) {
        Random random=new Random();
        int i=random.nextInt(7);
        gifts.get(i).function(mainpanel);
    }
}
