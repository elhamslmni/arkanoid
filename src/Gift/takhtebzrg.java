package Gift;

import Logic.Mainpanel;

public class takhtebzrg extends Gift{

    public takhtebzrg() {
        super();
        type=4;
    }

    @Override
    public void function(Mainpanel jPanel1) {
        jPanel1.getTakhte().setX(jPanel1.getTakhte().getX()-10);
        jPanel1.getTakhte().setWidth(jPanel1.getTakhte().getWidth()+20);
        long now=System.currentTimeMillis();
        jPanel1.getTimeManager().setLastgiftfortkhte(now);
    }
}
