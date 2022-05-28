package Brick;

import Logic.Mainpanel;
import model.Ball;

public class choobi extends Brick{
    public choobi() {
        super();

    }

    @Override
    public int type() {
        return 1;
    }
    int power1=2;

    @Override
    public void function(Mainpanel mainpanel, Ball ball) {
        if(!ball.isAtashin())
            ball.setSpeedY(ball.getSpeedY()*-1);
        this.power1--;
        if(power1==0||ball.isAtashin())
            mainpanel.getBricks().remove(this);

    }
}
