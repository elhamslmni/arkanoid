package Logic;

import Brick.*;
import Gift.Gift;
import model.Ball;
import model.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import Gift.chandgane;
import Gift.atashin;
import Gift.toopsari;
import Gift.toopkond;
import Gift.takhtekuchak;
import Gift.takhtegij;
import Gift.takhtebzrg;
import Gift.random;
import model.help;

public class loader {

    public static   Mainpanel loadgame(File file)
    {
        try {
            Scanner scanner=new Scanner(file);
            ////load player
            String name=scanner.nextLine();
           System.out.println(name);
            System.out.println( scanner.next());
            int score=scanner.nextInt();
            scanner.next();
            int power=scanner.nextInt();
            Player player=new Player(name);
            player.setScore(score);
            player.setPower(power);
            player.setDied(scanner.nextBoolean());


            //load bricks
            scanner.next();
            int bnum=scanner.nextInt();
            System.out.println(bnum);
            ArrayList<Brick> bricks=new ArrayList<>();
            double x,y,s;
            int p,t,w,h;
            for(int g=0;g<bnum;g++)
            {
               // System.out.println(scanner.next());
                x=Double.parseDouble(scanner.next());
                y=Double.parseDouble(scanner.next());
                h=Integer.parseInt(scanner.next());
                w=Integer.parseInt(scanner.next());
                s=Double.parseDouble(scanner.next());
                t=Integer.parseInt(scanner.next());
                p=Integer.parseInt(scanner.next());
             //   System.out.println(x+"  "+y);

               if(t==1) {
                   choobi b = new choobi();
                   b.setHeight((int)h);
                   b.setWidth((int)w);
                   b.setX(x);
                   b.setY(y);
                   b.setPower(p);
                   b.setSpeedY(s);
                   bricks.add(b);

               }
                if(t==2)
                {
                    jayeze b=new jayeze();
                    b.setHeight((int)h);
                    b.setWidth((int)w);
                    b.setX(x);
                    b.setY(y);
                    b.setPower(p);
                    b.setSpeedY(s);
                    bricks.add(b);
                }
                if(t==3)
                {
                    namarE b=new namarE();
                    b.setHeight((int)h);
                    b.setWidth((int)w);
                    b.setX(x);
                    b.setY(y);
                    b.setPower(p);
                    b.setSpeedY(s);
                    bricks.add(b);
                }
                if(t==4)
                {
                    shishei b=new shishei();
                    b.setHeight((int)h);
                    b.setWidth((int)w);
                    b.setX(x);
                    b.setY(y);
                    b.setPower(p);
                    b.setSpeedY(s);
                    bricks.add(b);
                }

            }


            /// load balls
            scanner.next();
            int ballnum=scanner.nextInt();
            ArrayList<Ball> balls=new ArrayList<>();
            double x1,y1,r,speedx,speedy;
            boolean isatshin;
            for(int g=0;g<ballnum;g++)
            {
                x1=Double.parseDouble(scanner.next());
                y1=Double.parseDouble(scanner.next());
                r=scanner.nextInt();
                speedx=Double.parseDouble(scanner.next());
                speedy=Double.parseDouble(scanner.next());
                isatshin=scanner.nextBoolean();

                Ball ball=new Ball((int)r);
                ball.setSpeedY(speedy);
                ball.setSpeedX(speedx);
                ball.setAtashin(isatshin);
                ball.setY(y1);
                ball.setX(x1);
                balls.add(ball);
            }


            ///load gifts
           scanner.next();
            int giftnum=scanner.nextInt();
            ArrayList<Gift> gifts=new ArrayList<>();
            int x2,y2,typ;
            for(int g=0;g<giftnum;g++)
            {
                typ=Integer.parseInt(scanner.next());
                x=Double.parseDouble(scanner.next());
                y=Double.parseDouble(scanner.next());
                if(typ==1)
                {
                    atashin  atashin=new atashin();
                    atashin.setX(x);
                    atashin.setY(y);
                    gifts.add(atashin);
                }
                if(typ==2)
                {
                    chandgane  atashin=new chandgane();
                    atashin.setX(x);
                    atashin.setY(y);
                    gifts.add(atashin);
                }
                if(typ==3)
                {
                    random  atashin=new random();
                    atashin.setX(x);
                    atashin.setY(y);
                    gifts.add(atashin);
                }
                if(typ==4)
                {
                    takhtebzrg  atashin=new takhtebzrg();
                    atashin.setX(x);
                    atashin.setY(y);
                    gifts.add(atashin);
                }
                if(typ==5)
                {
                    takhtegij  atashin=new takhtegij();
                    atashin.setX(x);
                    atashin.setY(y);
                    gifts.add(atashin);
                }
                if(typ==6)
                {
                    takhtekuchak  atashin=new takhtekuchak();
                    atashin.setX(x);
                    atashin.setY(y);
                    gifts.add(atashin);
                }
                if(typ==7)
                {
                    toopkond  atashin=new toopkond();
                    atashin.setX(x);
                    atashin.setY(y);
                    gifts.add(atashin);
                }
                if(typ==8)
                {
                    toopsari  atashin=new toopsari();
                    atashin.setX(x);
                    atashin.setY(y);
                    gifts.add(atashin);
                }
            }



          ///load takhte
          scanner.next();
            double xt,yt,ht,wt,st;
            xt=Double.parseDouble(scanner.next());
            yt=Double.parseDouble(scanner.next());
            ht=Double.parseDouble(scanner.next());
            wt=Double.parseDouble(scanner.next());
            st=Double.parseDouble(scanner.next());
            Takhte takhte=new Takhte();
            takhte.setHeight((int)ht);
            takhte.setWidth((int)wt);
            takhte.setX(xt);
            takhte.setY(yt);
            takhte.setSpeedX(st);


    Mainpanel mainpanel=new Mainpanel(bricks,balls,player,takhte,gifts);
             mainpanel.setId(scanner.nextInt());
             mainpanel.setGamename(scanner.next());
             return mainpanel;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return null;

    }
    public static File[] loadplayer(String name)
    {

        File file=new File("gamesarchive/"+name);
        if(!file.exists())
            return null;
        File[] file1=file.listFiles();
        if(file1.length==0)
            return null;
        return file1;
    }
    public  boolean isnewusername(String u)
    {
        File file=new File("gamesarchive/"+u);
        if(!file.exists())
            return true;

        return false;
    }


    public void deletgame(String uname,int id)
    {
        File file=new File("gamesarchive/"+uname);
        File[] file1=file.listFiles();
        for (File f:
             file1) {
            if(f.getName().equals(id))
                f.delete();

        }





    }
     public static String  scoreboard()
     {
         Scanner scanner;
         ArrayList<help> helps=new ArrayList<>();
         File file=new File("bestscores");
         for (File file1:
              file.listFiles()) {

             try {
                 scanner=new Scanner(file1);
                 int x=scanner.nextInt();
                 help help=new help();
                 help.setScore(x);
                 help.setName(file1.getName());
                 helps.add(help);

             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             }

         }


         for(int g=0;g<helps.size();g++) {
             for (int i = g + 1; i < helps.size(); i++)
             {
                 String name1=helps.get(g).getName();
                 String name2=helps.get(i).getName();
                 int score1=helps.get(g).getScore();
                 int score2=helps.get(i).getScore();

                 if(score2>score1)
                 {
                     helps.get(g).setName(name2);
                     helps.get(g).setScore(score2);
                     helps.get(i).setName(name1);
                     helps.get(i).setScore(score1);
                 }

             }

         }


         String s="";
         for(int g=0;g<helps.size();g++)
         {
             s+=(g+1);
             s+="_";
             s+=helps.get(g).getName();
             s+="   :";
             s+=helps.get(g).getScore();
             s+="......\n";
         }


         return s;

     }




}
