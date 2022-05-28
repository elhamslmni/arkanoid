package Gift;

import Logic.Mainpanel;

public class takhtegij extends Gift{

    public takhtegij() {
        super();
        type=5;
    }

    @Override
    public void function(Mainpanel jPanel1) {
        jPanel1.getTakhte().setGij(true);
        long now=System.currentTimeMillis();
        jPanel1.getTimeManager().setLastgiftfortkhte(now);
    }
}
