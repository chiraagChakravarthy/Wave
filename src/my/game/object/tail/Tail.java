package my.game.object.tail;

import my.game.object.Position;

import java.awt.*;
import java.util.ArrayList;

public class Tail
{
    private ArrayList<Point> pastPoints = new ArrayList<Point>();
    private ArrayList<Color> colors = new ArrayList<Color>();
    private Color baseColor;
    private int length;

    public Tail(int length, Color color)
    {
        this.baseColor = color;
        this.length = length;
        for (double i = 1; i < length + 1; i++)
        {
            colors.add(new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)(i * (255 / length))));
        }
    }

    public void setLocation(Position position)
    {
        pastPoints.add(new Point((int) position.getX(), (int) position.getY()));
        while (pastPoints.size() > length)
            pastPoints.remove(0);
    }

    public void render(Graphics g)
    {
        for (int i = 0; i < pastPoints.size(); i++)
        {
            g.setColor(colors.get(i));
            g.fillRect((int) Position.getScrX((float) pastPoints.get(i).getX()), (int) Position.getScrY((float) pastPoints.get(i).getY()), 32, 32);
        }
    }

    public ArrayList<Color> getColors()
    {
        return colors;
    }

    public void setColors(ArrayList<Color> colors)
    {
        this.colors = colors;
    }

    public Color getBaseColor()
    {
        return baseColor;
    }
}
