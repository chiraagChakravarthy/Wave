package my.game.infinite.hud;

import my.game.object.Position;

import java.awt.*;

public class InfiniteHB
{
    private double health;
    private Position position;
    private double width;
    private double height;
    private double maxHealth;

    public InfiniteHB(Position position, int maxHealth, int width, int height)
    {
        this.position = position;
        this.maxHealth = maxHealth;
        this.width = width;
        this.height = height;
    }

    public void setHealth(double health)
    {
        this.health = health;
    }

    public void render(Graphics g)
    {
        g.setColor(new Color(0, 128, 0));
        g.fillRect((int) position.getScrX(), (int) position.getScrY(), (int) width, (int) height);
        g.setColor(new Color(0, 255, 0));
        double healthWidth = (width - 2) * (health / maxHealth);
        g.fillRect((int) (position.getScrX() + 1), (int) (position.getScrY() + 1), (int) healthWidth, (int) (height - 1));
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public double getMaxHealth()
    {
        return maxHealth;
    }
}
