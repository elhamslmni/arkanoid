package Graphic;

import Logic.Loop;
import Logic.loader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouse implements MouseListener {
    Loop loop;
    boolean isstoped=false;
    boolean isrunnig=false;
    JLabel jLabel;
    JLabel jLabel2;
    JFrame jFrame;
    public mouse(Loop loop, JLabel label,JFrame jFrame){
        this.loop=loop;
        jLabel=label;


        //score board
        JLabel jButton=new JLabel();
        jButton.setBackground(Color.yellow);
        jButton.setVisible(false);
        jButton.setOpaque(true);
        jButton.setBounds(200,400,300,300);
        jButton.setForeground(Color.red);
        jButton.setFont(new Font("", Font.PLAIN, 20));
        jButton.setText(loader.scoreboard());
        jLabel2=jButton;
        jFrame.add(jButton);
        this.jFrame=jFrame;

    }
    @Override
    public void mouseClicked(MouseEvent e) {




        if(isrunnig==false)
        {
            isrunnig=true;
            jLabel.setText("stop");
            loop.start();
            //score board
           // jFrame.remove(jLabel2);
        }
        else {


           if (!isstoped) {
                loop.stop();
                isstoped = true;
                jLabel.setText(" restart");
                jLabel2.setOpaque(true);
                jLabel2.setBackground(Color.black);
                jLabel2.setText(loader.scoreboard());
               jLabel2.setVisible(true);
               jFrame.setLayout(null);
             //  jFrame.add(jLabel2);
            } else {
            //   jFrame.remove(jLabel2);
               jLabel2.setVisible(false);
                loop.restart();
                isstoped = false;
                jLabel.setText(" stop");

            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
