package my.game.object;

import java.awt.*;

public class Position
{
    private double x;
    private double y;
    private static double xOffset;
    private static double yOffset;

    public Position(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Position(Point p)
    {
        x = p.getX();
        y = p.getY();
    }

    public void setPosition(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getScrX()
    {
        return x - xOffset;
    }

    public double getScrY()
    {
        return y - yOffset;
    }

    public static void setXOffset(double xOffset)
    {
        Position.xOffset = xOffset;
    }

    public static void setYOffset(double yOffset)
    {
        Position.yOffset = yOffset;
    }


    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public static double getScrX(float x)
    {
        return x - xOffset;
    }

    public static double getScrY(float y)
    {
        return y - yOffset;
    }

    public Position getWorldPosition(double scrX, double scrY)
    {
        return new Position(scrX + xOffset, scrY + yOffset);
    }

    public void align()
    {
        x += xOffset;
        y += yOffset;
    }
}
