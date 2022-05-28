package Graphic;

import Logic.loader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class scoremouse implements MouseListener {

    JLabel jLabel;
    scoremouse(JLabel jLabel)
    {
        this.jLabel=jLabel;
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        jLabel.setText(loader.scoreboard());
       // jFrame.add(jLabel);
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
