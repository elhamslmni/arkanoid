package Logic;

import Brick.Brick;
import Gift.Gift;
import model.Ball;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import Brick.Brick;
import Brick.choobi;
import Brick.shishei;
import Brick.jayeze;
import Brick.namarE;
import Brick.fullnamarE;

public class Timemanager {
    long lastTime;
    long lasttime2;
    long lastgiftforball;
    long lastgiftfortkhte;
    int i=0;
    int num=0;

    public Timemanager() {
        this.lastTime = System.nanoTime();
        this.lasttime2 = System.currentTimeMillis();

    }

    public void setLastgiftforball(long lastgiftforball) {
        this.lastgiftforball = lastgiftforball;
    }

    public void setLastgiftfortkhte(long lastgiftfortkhte) {
        this.lastgiftfortkhte = lastgiftfortkhte;
    }

    public void updateBallandBricks(Mainpanel jPanel) {
        ArrayList<Brick> bricks=jPanel.getBricks();
        ArrayList<Ball> balls=jPanel.getBalls();
        ArrayList<Gift> gifts=jPanel.getGifts();
        Takhte takhte=jPanel.getTakhte();
        long now = System.nanoTime();
        long now1=System.currentTimeMillis();
        double a = 0.00000001;


        ///update balls
        for(int g=0;g<balls.size();g++) {
            Ball ball=balls.get(g);
            ball.setX(ball.getX() + ball.getSpeedX() * (now - lastTime));
            ball.setY(ball.getY() + ball.getSpeedY() * (now - lastTime));
          //  ball.setSpeedY(ball.getSpeedY() + a * a * (now - lastTime));
            if(ball.getX()>700) {
                ball.setSpeedX(-1 * Math.abs(ball.getSpeedX()));
            }
            else if(ball.getX()<=10)
                ball.setSpeedX(Math.abs(ball.getSpeedX()));
            if(ball.getY()>700) {
                //    ball.setSpeedY(-1 * Math.abs(ball.getSpeedY()));
                balls.remove(ball);
                if(balls.size()==0)
                    jPanel.getPlayer().setPower(jPanel.getPlayer().getPower()-1);
                if(jPanel.getPlayer().getPower()>0&&balls.size()==0)
                {

                    Ball ball1=new Ball(8);
                    ball1.setX(300);
                    ball1.setY(300);
                    ball1.setSpeedX(-0.00000009);
                    ball1.setSpeedY(-0.0000005);
                    balls.add(ball1);
                }
                if(jPanel.getPlayer().getPower()==0)
                    jPanel.getPlayer().setDied(true);
                //////////////////////if pwr==0 finish game
            }
            else if(ball.getY()<=10)
                ball.setSpeedY(Math.abs(ball.getSpeedY()));

        }




        // update gifts
        if(balls.size()>0)
            for(int g=0;g<gifts.size();g++) {
                Gift gift=gifts.get(g);
                gift.setY(gift.getY() + 0.0000002 * (now - lastTime));
            }


        // update bricks
        if(now1-lasttime2>=20000||num==0) {
            num=1;
            updatebricks(bricks);
            lasttime2=now1;
        }

        ///refersh gifts efect for balls
        if(now1-lastgiftforball>20000&&now1-lastgiftforball<20050)
            refreshballs(balls);
        ///refersh gifts efect for takhte
        if(now1-lastgiftfortkhte>20000&&now1-lastgiftfortkhte<20050)
            refreshtkhte(takhte);
        updategame(jPanel);
        lastTime = now;
    }
    public void updategame(Mainpanel jPanel)
    {
        ArrayList<Brick> bricks=jPanel.getBricks();
        ArrayList<Ball> balls=jPanel.getBalls();
        ArrayList<Gift> gifts=jPanel.getGifts();
        Takhte takhte=jPanel.getTakhte();
        //takhte
        Rectangle2D shapet = new Rectangle2D.Float((float) takhte.getX(),(float) takhte.getY(),takhte.getWidth(),takhte.getHeight());



        for(int g=0;g<balls.size();g++) {
            //ball
            Ellipse2D shape1 = new Ellipse2D.Float((float) balls.get(g).getX(), (float) balls.get(g).getY(), 24, 24);
            for (int k = 0; k < bricks.size(); k++) {
                //brick
                Rectangle2D shape = new Rectangle2D.Float((float) bricks.get(k).getX(), (float) bricks.get(k).getY(), bricks.get(k).getWidth(), bricks.get(k).getHeight());
                //check ball and brick brkhrd
                boolean b = checkintersect(shape, shape1);
                if (b == true) {
                    if(bricks.get(k).isIsvisible()) {
                        bricks.get(k).function(jPanel, balls.get(g));
                        jPanel.getPlayer().setScore(jPanel.getPlayer().getScore() + 1);
                        saver.savebestscore(jPanel.getPlayer().getName(), jPanel.getPlayer().getScore());
                    }
                }
            }
            //check ball and tkhte brkhrd
            if(checkintersect(shapet, shape1)) {
               chekvertex(takhte,balls.get(g));
            }
        }


        //check gifts and tkhte brkhrd
        for(int g=0;g<gifts.size();g++)
        {
            Ellipse2D shapea=new Ellipse2D.Float((float)gifts.get(g).getX(),(float)gifts.get(g).getY(),20,10);
            if(checkintersect(shapet,shapea))
            {
                gifts.get(g).function(jPanel);
                gifts.remove(gifts.get(g));
            }

        }


    }
    public boolean checkintersect(Shape a, Shape b){
        return  a.getBounds2D().intersects(b.getBounds2D());
    }
    public  void refreshballs(ArrayList<Ball> balls)
    {
        for(int g=0;g<balls.size();g++)
            balls.get(g).refresh();
    }
    public void refreshtkhte(Takhte takhte)
    {
        takhte.refresh();
    }
    public void updatebricks(ArrayList<Brick> bricks)
    {

        for (int g = 0; g < bricks.size(); g++) {
            Brick brick = bricks.get(g);
            brick.setY(brick.getY()+20);
        }
        int x=0;
        for (int k = 0; k < 15; k++) {
            Random random=new Random();
            int type=random.nextInt(5);
            //    System.out.println(type);
            if (type == 1) {
                jayeze brick1 = new jayeze();
                brick1.setX(x);
                brick1.setY(0);
                brick1.setHeight(10);
                brick1.setWidth(40);
                bricks.add(brick1);
            }
            if (type == 2) {
                namarE brick1 = new namarE();
                brick1.setX(x);
                brick1.setY(0);
                brick1.setHeight(10);
                brick1.setWidth(40);
                bricks.add(brick1);
            }
            if (type == 3) {
                shishei brick1 = new shishei();
                brick1.setX(x);
                brick1.setY(0);
                brick1.setHeight(10);
                brick1.setWidth(40);
                bricks.add(brick1);

            }
            if(type==4)
            {
                fullnamarE brick1=new fullnamarE();
                brick1.setX(x);
                brick1.setY(0);
                brick1.setHeight(10);
                brick1.setWidth(40);
                bricks.add(brick1);
            }
            if (type == 0) {
                choobi brick1 = new choobi();
                brick1.setX(x);
                brick1.setY(0);
                brick1.setHeight(10);
                brick1.setWidth(40);
                bricks.add(brick1);
            }
            x+=52;
        }



    }



    public void chekvertex(Takhte takhte,Ball ball)
    {
        double x=takhte.getX();
        double y=takhte.getY();

        double x2=takhte.getX()+80;

        if(ball.getX()<x&&ball.getY()<y)
        {
            ball.setSpeedX(-1*(Math.abs(ball.getSpeedX())));
            ball.setSpeedY(-1*(Math.abs(ball.getSpeedY())));
        }
        else {

            if(ball.getX()>x2&&ball.getY()<y)
            {
                ball.setSpeedX((Math.abs(ball.getSpeedX())));
                ball.setSpeedY(-1*(Math.abs(ball.getSpeedY())));
            }
            else
                ball.setSpeedY(Math.abs(ball.getSpeedY()) * -1);

        }

    }






}
