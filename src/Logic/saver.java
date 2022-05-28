package Logic;

import Brick.Brick;
import Gift.Gift;
import model.Ball;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Scanner;

public class saver {


    public  void  savegame(Mainpanel mainpanel)
    {

        File file = new File("gamesarchive/"+mainpanel.getPlayer().getName());
        if(!file.exists())
            file.mkdirs();
        File file1=new File(file.getPath()+"/"+mainpanel.getId()+"...."+mainpanel.getGamename());
        if(!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            PrintStream printStream=new PrintStream(new FileOutputStream(file1,false));
            printStream.println(mainpanel.getPlayer().getName());
            printStream.println("playerscore:  "+mainpanel.getPlayer().getScore());
            printStream.println("playerpower:   "+mainpanel.getPlayer().getPower());
            printStream.println(mainpanel.getPlayer().getDied());
            printStream.println("Bricksnum:  "+mainpanel.getBricks().size());
            for(int g=0;g<mainpanel.getBricks().size();g++) {
                 Brick b=mainpanel.getBricks().get(g);
                printStream.println(b.getX()+" "+b.getY()+" "+b.getHeight()+" "+b.getWidth()+" "+b.getSpeedY()+" "+b.type()+" "+b.getPower());
            }
            printStream.println("Balls: "+mainpanel.getBalls().size());
            for(int g=0;g<mainpanel.getBalls().size();g++)
            {
                Ball b=mainpanel.getBalls().get(g);
                printStream.println(b.getX()+" "+b.getY()+" "+b.getR()+" "+b.getSpeedX()+" "+b.getSpeedY()+" "+b.isAtashin());
            }
            printStream.println("Gifts:  "+mainpanel.getGifts().size());
            for(int g=0;g<mainpanel.getGifts().size();g++)
            {
                Gift gift=mainpanel.getGifts().get(g);
                printStream.println(gift.getType()+" "+gift.getX()+" "+ gift.getY());
            }
            Takhte t=mainpanel.getTakhte();
            printStream.println("abouttakhte");
            printStream.println(t.getX()+" "+t.getY()+" "+t.getHeight()+" "+t.getWidth()+" "+t.getSpeedX());

            printStream.println(mainpanel.getId());
            printStream.println(mainpanel.getGamename());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


    public static void savebestscore(String name,int s)
    {
        File file =new File("bestscores/"+name);
        if(!file.exists())
        {

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                PrintStream printStream = new PrintStream(new FileOutputStream(file, false));
                printStream.println(s);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }
        else
        {
         int t=0;
            try {
                Scanner scanner=new Scanner(file);
                t=scanner.nextInt();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            PrintStream printStream = null;
            try {
                printStream = new PrintStream(new FileOutputStream(file, false));
                printStream.println(Math.max(s,t));

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }


}
