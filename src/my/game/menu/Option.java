package my.game.menu;

import java.awt.*;

public class Option
        extends Label
{
    private boolean highlighted = false;

    public Option(int y, int scale, String name, Color nameColor, Color boxColor)
    {
        super(y, scale, name, nameColor, boxColor);
    }

    public Option(int x, int y, int scale, String name, Color nameColor, Color boxColor)
    {
        super(y, scale, name, nameColor, boxColor);
        this.x = x;
    }


    public void render(Graphics g)
    {
        g.setFont(new Font("Arial", 0, this.scale));
        if (this.highlighted)
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
}