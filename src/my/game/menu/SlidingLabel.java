package my.game.menu;

import java.awt.*;

public class SlidingLabel extends Label
{
    private int startTime;
    protected double finalX;
    private double finalY;

    public SlidingLabel(int x, int y, int scale, String name, Color nameColor, Color boxColor, int startTime)
    {
        super(x, y, scale, name, nameColor, boxColor);
        this.finalX = x;
        this.finalY = y;
        this.startTime = startTime;
    }

    public SlidingLabel(int y, int scale, String name, Color nameColor, Color boxColor, int startTime)
    {
        super(y, scale, name, nameColor, boxColor);
        finalX = x;
        finalY = y;
        this.startTime = startTime;
    }

    public void setRelativeCoordinates(double relativeX, double relativeY)
    {
        x -= relativeX;
        y -= relativeY;
    }

    public void move(double velX, double velY)
    {
        x += velX;
        y += velY;
    }

    public boolean shouldMove(int timer)
    {
        if (timer >= startTime)
        {
            if (x != finalX)
                return true;
            if (y != finalY)
                return true;
        }
        return false;
    }

    public void setFinalX(double finalX)
    {
        this.finalX = finalX;
        this.x = finalX;
    }

    public void setFinalY(double finalY)
    {
        this.finalY = finalY;
        this.y = finalY;
    }

    public double getFinalX()
    {
        return finalX;
    }

    public double getFinalY()
    {
        return finalY;
    }
}
