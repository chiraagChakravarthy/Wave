package my.game.object;

import my.game.object.tail.Tail;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity
{
    private int health;
    private int invilnerabilityTimer;

    public Player(float x, float y, int health)
    {
        super(x, y, 0.1F, 0.05F, 2, new Tail(10, Color.white));
        this.health = health;
        invilnerabilityTimer = 60;
    }

    public Player(Player player)
    {
        super(player);
        this.health = player.getHealth();
        invilnerabilityTimer = 60;
    }

    public void tick()
    {
        super.tick();
        if (invilnerabilityTimer > 0)
        {
            invilnerabilityTimer--;
            invisible = !invisible;
        }
        else
            invisible = false;
    }

    public boolean isInvulnerable()
    {
        return invilnerabilityTimer > 0;
    }

    public void damage(int damage)
    {
        if (!(invilnerabilityTimer > 0))
        {
            health -= damage;
            invilnerabilityTimer = 60;
        }
    }

    public int getHealth()
    {
        return health;
    }


    public void keyPressed(int k)
    {
        switch (k)
        {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
        }
    }

    public void keyReleased(int k)
    {
        switch (k)
        {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                right = false;
        }
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public void setInvulnerabilityTime(int invulnerability)
    {
        this.invilnerabilityTimer = invulnerability;
    }
}
