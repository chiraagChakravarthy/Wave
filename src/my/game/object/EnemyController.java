package my.game.object;

import my.game.campaign.hud.Timer;

import java.awt.*;
import java.util.ArrayList;

public class EnemyController
{
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private ArrayList<Double> releaseTimes = new ArrayList<Double>();
    private Player player;
    private Timer timer;

    public void addEnemy(Enemy enemy, double releaseTime)
    {
        enemies.add(enemy);
        releaseTimes.add(releaseTime);
    }

    public void tick()
    {
        for (int i = 0; i < enemies.size(); i++)
        {
            if (releaseTimes.get(i) <= timer.getElapsedTime())
            {
                enemies.get(i).tick();
                collision(enemies.get(i));
            }
        }
    }

    public void render(Graphics g)
    {
        for (int i = 0; i < enemies.size(); i++)
        {
            if (releaseTimes.get(i) <= timer.getElapsedTime())
                enemies.get(i).render(g);
        }
    }

    private void collision(Enemy enemy)
    {
        if (enemy.getHitBox().intersects(player.getHitBox()) && !enemy.isSpawnProtected())
            player.damage(1);
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public void setTimer(Timer timer)
    {
        this.timer = timer;
    }
}
