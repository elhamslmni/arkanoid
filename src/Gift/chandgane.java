package Gift;

import Logic.Mainpanel;
import model.Ball;

public class chandgane extends Gift{

    public chandgane() {

        type=2;
    }

    @Override
    public void function(Mainpanel jPanel1) {
        Ball ball1=new Ball(8);
        ball1.setX(300);
        ball1.setY(300);
        ball1.setSpeedX(0.00000003);
        ball1.setSpeedY(-0.0000002);
        Ball ball2=new Ball(8);
        ball2.setX(300);
        ball2.setY(300);
        ball2.setSpeedX(-0.00000003);
        ball2.setSpeedY(-0.0000002);
        jPanel1.getBalls().add(ball1);
        jPanel1.getBalls().add(ball2);
    }
}
