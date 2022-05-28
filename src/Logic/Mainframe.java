package Logic;

import Graphic.keyboard;
import Graphic.mouse;
import com.sun.jdi.IntegerValue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class Mainframe extends JFrame {
    Mainpanel mainpanel;
    Loop loop;
    boolean bool=false;
    public Mainframe(String name) throws HeadlessException {
        setSize(800,800);
        setLayout(null);



        File[] file=loader.loadplayer(name);
        if(!(file ==null)) {
            int num = file.length;
            String ans = JOptionPane.showInputDialog("you have " + num + " game do you want to playe one of them?");
            if (ans.equalsIgnoreCase("yes")) {
                String s = "";
                int i = 0;
                for (File g :
                        file) {
                    s += i;
                    s += ": ";
                    s += g.getName();
                    s += "\n";

                }
                ans = JOptionPane.showInputDialog("which one?" + s);
                int x = Integer.parseInt(ans);
                Mainpanel mainpanel = loader.loadgame(file[x]);
                this.mainpanel = mainpanel;


            } else {
                mainpanel = new Mainpanel(name);
                String a = JOptionPane.showInputDialog("choose a name for your game");
                mainpanel.setId(file.length);
                mainpanel.setGamename(a);
            }
        }
        else  {
            mainpanel=new Mainpanel(name);
            String a = JOptionPane.showInputDialog("choose a name for your game");
            mainpanel.setId(0);
            mainpanel.setGamename(a);
        }














        setContentPane(mainpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        loop = new Loop(55, new Runnable() {
            @Override
            public void run() {
                revalidate();
                repaint();
            }
        });


        JLabel jButton=new JLabel();
        jButton.setVisible(true);
        jButton.setBackground(Color.yellow);
        jButton.setOpaque(true);
        jButton.setBounds(600,700,60,60);
        this.setLayout(null);
        jButton.setForeground(Color.red);
        jButton.setText("  start");
        mouse mouse=new mouse(loop,jButton,this);
        jButton.addMouseListener(mouse);
        this.add(jButton);
        this.addKeyListener(new keyboard(mainpanel));
    }




}
