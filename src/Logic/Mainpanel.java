package Logic;

import Brick.Brick;
import Gift.Gift;
import model.Ball;
import model.Player;

import javax.management.StringValueExp;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Mainpanel extends JPanel {
    Takhte takhte=new Takhte();
    ArrayList<Ball> balls=new ArrayList<>();
    ArrayList<Brick> bricks=new ArrayList<>();
    ArrayList<Gift> gifts=new ArrayList<>();
    Timemanager timeManager;
    Player player;
    JLabel jLabel;
    int id;
    String gamename;
    saver saver=new saver();
    Mainpanel(String name) {

        player=new Player(name);
        player.setScore(0);

        //first ball
        Ball  ball1 = new Ball(8);
        ball1.setX(200);
        ball1.setY(600);
        ball1.setSpeedX(-0.00000009);
        ball1.setSpeedY(-0.0000002);
        setBackground(Color.BLACK);
        timeManager = new Timemanager();
        balls.add(ball1);


        // takhte
        takhte.setX(300);
        takhte.setY(600);
        takhte.setHeight(20);
        takhte.setWidth(80);





        //score board
        jLabel=new JLabel();
        jLabel.setBounds(300,200,200,200);
        jLabel.setBackground(Color.black);
        jLabel.setVisible(true);
        this.setLayout(null);
        jLabel.setForeground(Color.white);
        jLabel.setFont(new Font("", Font.PLAIN, 120));
        jLabel.setText("0");
        this.add(jLabel);


    }

    Mainpanel(ArrayList<Brick> bricks, ArrayList<Ball> balls, Player player, Takhte takhte, ArrayList<Gift> gifts)
    {
        this.bricks=bricks;
        this.player=player;
        this.balls=balls;
        this.takhte=takhte;
        this.gifts=gifts;
        setBackground(Color.gray);
        timeManager = new Timemanager();



        ///scor board
        jLabel=new JLabel();
        jLabel.setBounds(300,200,200,200);
        jLabel.setBackground(Color.black);
        jLabel.setVisible(true);
        this.setLayout(null);
        jLabel.setForeground(Color.white);
        jLabel.setFont(new Font("", Font.PLAIN, 120));


        if(player.getPower()==0)
            jLabel.setText("game over!!");
        else {
            jLabel.setText(String.valueOf(player.getScore()));
            if(balls.size()==0)
            {
                //new ball
                Ball  ball1 = new Ball(8);
                ball1.setX(300);
                ball1.setY(300);
                ball1.setSpeedX(-0.00000009);
                ball1.setSpeedY(-0.0000005);
                this.balls.add(ball1);

            }

        }
        this.add(jLabel);





    }

    public ArrayList<Gift> getGifts() {
        return gifts;
    }

    public Takhte getTakhte() {
        return takhte;
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public Timemanager getTimeManager() { return timeManager; }

    public model.Player getPlayer() { return player; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
    public String getGamename() { return gamename; }

    public void setGamename(String gamename) { this.gamename = gamename; }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        saver.savegame(this);
       ImageIcon imageIcon = new ImageIcon("giftsimages/bob1.png");
        g.drawImage(imageIcon.getImage(), 0, 0,800,800,null, null);
        if (!player.getDied())
            timeManager.updateBallandBricks(this);
        else {
            jLabel.setFont(new Font("", Font.PLAIN, 20));
            jLabel.setText("game over");
        }
        g.setColor(new Color(255,59,0));


        //draw balls
        for (int i = 0; i < balls.size(); i++) {
            Ball ball = balls.get(i);
            if (ball.isAtashin())
                g.setColor(new Color(200,50,115));
            g.fillOval((int) ball.getX(), (int) ball.getY(), 2 * ball.getR(), 2 * ball.getR());
        }
        g.setColor(Color.CYAN);


        //draw bricks
        for (int i = 0; i < bricks.size(); i++) {
            int p = 0;
            Brick brick3 = bricks.get(i);
            if(brick3.type()==5)
                p=1;
            if (brick3.type() == 1)
                g.setColor(Color.yellow);
            if (brick3.type() == 2)
                g.setColor(new Color(50,250,255));
            if (brick3.type() == 3) {
                g.setColor(new Color(102,0,153));

                if (brick3.getTime() > 200) {
                    brick3.setIsvisible(false);
                    if (brick3.getTime() > 400) {
                        brick3.setTime(0);
                        brick3.setIsvisible(true);
                    }
                    p = 1;
                }
                brick3.setTime(brick3.getTime() + 1);
            }
            if (brick3.type() == 4)
                g.setColor(new Color(255,102,130));
            if (p == 0)
                g.fillRect((int) brick3.getX(), (int) brick3.getY(), brick3.getWidth(), brick3.getHeight());
        }


        //draw gifts
        for (int i = 0; i < gifts.size(); i++) {
            Gift gift = gifts.get(i);
            ImageIcon imageIcon1=null;
            if (gift.getType() == 1) {
                 imageIcon1=new ImageIcon("giftsimages/1.png");
                 g.setColor(Color.white);
            }
            if (gift.getType() == 2) {
                g.setColor(Color.magenta);
                imageIcon1=new ImageIcon("giftsimages/2.png");
            }
            if (gift.getType() == 3) {
                g.setColor(Color.pink);
                imageIcon1=new ImageIcon("giftsimages/3.png");
            }
            if (gift.getType() == 4) {
                g.setColor(Color.yellow);
                imageIcon1 = new ImageIcon("giftsimages/4.png");
            }
            if (gift.getType() == 5) {
                g.setColor(Color.orange);
                imageIcon1 = new ImageIcon("giftsimages/5.png");
            }

                if (gift.getType() == 6)
                {
                    g.setColor(Color.CYAN);
                    imageIcon1 = new ImageIcon("giftsimages/6.png");
            }
            if (gift.getType() == 7) {
                g.setColor(Color.gray);
                imageIcon1 = new ImageIcon("giftsimages/7.png");
            }

            if (gift.getType() == 8) {
                g.setColor(Color.darkGray);
                imageIcon1 = new ImageIcon("giftsimages/1.png");
            }
            g.drawImage(imageIcon1.getImage(),(int) gift.getX(), (int) gift.getY(),30,30,Color.BLUE,null);


        }


        //draw takhte
        g.setColor(new Color(255,102,0));
        ImageIcon imageIcon1=new ImageIcon("giftsimages/wood.png");
        g.drawImage(imageIcon1.getImage(),(int) takhte.getX(), (int) takhte.getY(),takhte.width,takhte.height,Color.BLUE,null);
        g.fillRect((int) takhte.getX(), (int) takhte.getY(),takhte.width,takhte.height);


        //update score board
        StringBuilder stringBuilder = new StringBuilder();
        if (!player.getDied()) {
            stringBuilder.append(player.getScore());
            jLabel.setText(stringBuilder.toString());
        }









    }
    }
