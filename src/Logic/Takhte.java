package Logic;

public class Takhte {
    double x,y;
    int height;
    int width;
    double speedX;
    public boolean gij=false;
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }
    public int getHeight() { return height; }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedY) {
        this.speedX = speedY;
    }

    public boolean isGij() {
        return gij;
    }

    public void setGij(boolean gij) {
        this.gij = gij;
    }

    public void refresh()
    {
        this.setWidth(80);
        gij=false;
        //this.setSpeedX(Math.abs(this.getSpeedX()));
    }
}
