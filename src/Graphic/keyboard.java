package Graphic;

import Logic.Loop;
import Logic.Mainpanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class keyboard implements KeyListener {
    Mainpanel mainpanel;
    public keyboard(Mainpanel mainpanel)
    {
        this.mainpanel=mainpanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar()=='a') {
            if(mainpanel.getTakhte().gij)
                mainpanel.getTakhte().setX(mainpanel.getTakhte().getX()+20);
            else
                mainpanel.getTakhte().setX(mainpanel.getTakhte().getX()-20);
        }
        if(e.getKeyChar()=='d') {

            if(mainpanel.getTakhte().gij)
                mainpanel.getTakhte().setX(mainpanel.getTakhte().getX()-20);
            else
                mainpanel.getTakhte().setX(mainpanel.getTakhte().getX()+20);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
