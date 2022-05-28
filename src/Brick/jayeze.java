package Brick;

import Gift.Gift;
import Logic.Mainpanel;
import model.Ball;

import java.util.ArrayList;
import java.util.Random;

import Gift.atashin;
import Gift.takhtebzrg;
import Gift.takhtegij;
import Gift.takhtekuchak;
import Gift.toopkond;
import Gift.toopsari;
import Gift.chandgane;

public class jayeze extends Brick{
    int power=1;
    ArrayList<Gift> gifts=new ArrayList<>();
    Gift gift;
    public jayeze()
    {
        super();
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
        Random random=new Random();
        int i=random.nextInt(7);
        gift = gifts.get(i);

    }
    @Override
    public int type() {
        return 2;
    }

    @Override
    public void function(Mainpanel mainpanel, Ball ball) {
        if(!ball.isAtashin())
            ball.setSpeedY(ball.getSpeedY()*-1);
        mainpanel.getBricks().remove(this);
        gift.setX(this.x);
        gift.setY(this.y);
        mainpanel.getGifts().add(gift);
        System.out.println(x+"   "+y);
    }
}
