package my.game.campaign.hud;

import java.awt.*;

public class HealthBar
{
    private int x;
    private int y;
    private double maxHealth;
    private double width;
    private double health = 0;
    private int height;

    public HealthBar(int x, int y, int maxHealth, int width, int height)
    {
        this.x = x;
        this.y = y;
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
        g.fillRect(x, y, (int) width, height);
        g.setColor(new Color(0, 255, 0));
        double healthWidth = (this.width - 20) * (health / maxHealth);
        g.fillRect((int) (x + 10), y + 10, (int) healthWidth, height - 20);
    }

    public double getMaxHealth()
    {
        return maxHealth;
    }
}
