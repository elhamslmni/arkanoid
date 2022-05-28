package Brick;

import Logic.Mainpanel;
import model.Ball;

public class shishei extends Brick{

    public shishei() {
        super();
    }

    @Override
    public int type() {
        return 4;
    }
    int power=1;

    @Override
    public void function(Mainpanel mainpanel, Ball ball) {
        if(!ball.isAtashin())
            ball.setSpeedY(ball.getSpeedY()*-1);
        mainpanel.getBricks().remove(this);

    }
}
