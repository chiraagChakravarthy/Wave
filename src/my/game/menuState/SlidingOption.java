package my.game.menuState;

import java.awt.*;

public class SlidingOption extends SlidingLabel
{
    private boolean highlighted;

    public SlidingOption(int x, int y, int scale, String name, Color nameColor, Color boxColor, int startTime)
    {
        super(x, y, scale, name, nameColor, boxColor, startTime);
    }

    public SlidingOption(int y, int scale, String name, Color nameColor, Color boxColor, int startTime)
    {
        super(y, scale, name, nameColor, boxColor, startTime);
    }

    public void render(Graphics g)
    {
        g.setFont(new Font("Arial", Font.PLAIN, scale));
        if (highlighted)
        {
            g.setColor(this.nameColor);
            g.fillRect((int) x, (int) y, this.width, this.height);
            g.setColor(this.boxColor);
            g.drawString(this.name, (int) x + this.width / 2 - this.stringWidth / 2, (int) y + this.height - this.height / 4);
        }
        else
        {
            super.render(g);
        }
    }

    public void setHighlighted(boolean highlighted)
    {
        this.highlighted = highlighted;
    }

    public double getFinalX()
    {
        return finalX;
    }
}