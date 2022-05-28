package Gift;

import Logic.Mainpanel;
import model.Ball;

public class atashin extends Gift{


    public atashin() {
        super();
        type=1;

    }

    @Override
    public void function(Mainpanel jPanel1) {
        Ball ball1=new Ball(8);
        ball1.setX(300);
        ball1.setY(300);
        ball1.setSpeedX(-0.00000009);
        ball1.setSpeedY(-0.0000002);
        ball1.setAtashin(true);
        jPanel1.getBalls().add(ball1);

    }
}
