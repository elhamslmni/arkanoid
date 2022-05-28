package Brick;

import Logic.Mainpanel;
import model.Ball;

public class fullnamarE extends Brick{
    public fullnamarE() {
        super();
    }

    @Override
    public int type() {
        return 5;
    }
    int power=1;

    @Override
    public void function(Mainpanel mainpanel, Ball ball) {
        if(!ball.isAtashin())
            ball.setSpeedY(ball.getSpeedY()*-1);
        mainpanel.getBricks().remove(this);

    }


}
