import Logic.Mainframe;

import javax.swing.*;

public class Main {

    public static void main(String[] args)
    {
        String name= JOptionPane.showInputDialog("whats your name?");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Mainframe mainframe=new Mainframe(name);
               mainframe.revalidate();
             mainframe.repaint();
            }
        });
        //   Mainframe mainframe=new Mainframe(name);
        //    String name2= JOptionPane.showInputDialog("whats your name?");
    }
}
