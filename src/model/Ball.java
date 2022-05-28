package model;

public class Ball { double x,y;
    double speedX,speedY; // pixel / nano
    final int r;
    boolean atashin=false;

    public Ball(int r) {
        this.r = r;
    }

    public boolean isAtashin() {
        return atashin;
    }

    public void setAtashin(boolean atashin) {
        this.atashin = atashin;
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }
    public void refresh()
    {
        this.setSpeedY(-0.0000005);
    }
}
