package Gift;

import Logic.Mainpanel;
import model.Ball;

import java.util.ArrayList;

public class toopkond extends Gift{


    public toopkond() {
        super();
        type=7;

    }

    @Override
    public void function(Mainpanel jPanel1) {
        ArrayList<Ball> balls=jPanel1.getBalls();
        for(int i=0;i<balls.size();i++){
            balls.get(i).setSpeedY(balls.get(i).getSpeedY()/2);
        }
        long now=System.currentTimeMillis();
        jPanel1.getTimeManager().setLastgiftforball(now);

    }
}
