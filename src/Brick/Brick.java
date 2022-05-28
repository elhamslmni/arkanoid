package Brick;

import Logic.Mainpanel;
import model.Ball;

public class Brick {
    double x,y;
    int height;
    int width;
    double speedY;
    int type;
    int power;
    int time;
    boolean isvisible=true;
    public Brick()
    {

    }

    public boolean isIsvisible() {
        return isvisible;
    }

    public void setIsvisible(boolean isvisible) {
        this.isvisible = isvisible;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
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

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public int type()
    {
        return type;
    }
    public  void function(Mainpanel mainpanel, Ball ball)
    {




    }
}
