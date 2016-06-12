package my.game.object;

import my.game.object.tail.Tail;

import java.awt.*;
import java.util.Random;

public class Enemy extends Entity
{
    private int difficulty;
    private int spawnProtectionTimer;
    private static Player player;
    private Random random;

    public Enemy(int x, int y, float acc, float dcc, float maxSpeed, Tail tail, int difficulty)
    {
        super(x, y, dcc, acc, maxSpeed, tail);
        this.difficulty = difficulty;
        spawnProtectionTimer = 30;
        random = new Random();
    }

    public Enemy(Enemy enemy)
    {
        super(enemy);
        this.difficulty = getDifficultyLevel();
        spawnProtectionTimer = 30;
    }

    public void tick()
    {
        if (getY() > player.getY())
        {
            if (random.nextInt(getDifficulty()) + 1 == 1)
                setUp(true);
        }
        else
        {
            setUp(false);
        }

        if (getY() < player.getY())
        {
            if (random.nextInt(getDifficulty()) + 1 == 1)
                setDown(true);
        }
        else
        {
            setDown(false);
        }

        if (getX() > player.getX())
        {
            if (random.nextInt(getDifficulty()) + 1 == 1)
                setLeft(true);
        }
        else
        {
            setLeft(false);
        }

        if (getX() < player.getX())
        {
            if (random.nextInt(getDifficulty()) + 1 == 1)
                setRight(true);
        }
        else
        {
            setRight(false);
        }

        super.tick();
        if (spawnProtectionTimer > 0)
        {
            spawnProtectionTimer--;
            invisible = !invisible;
        }
        else
        {
            invisible = false;
        }
    }

    public boolean isSpawnProtected()
    {
        return spawnProtectionTimer > 0;
    }

    public void render(Graphics g)
    {
        super.render(g);
    }

    public int getDifficulty()
    {
        return 101 - difficulty;
    }

    public int getDifficultyLevel()
    {
        return difficulty;
    }

    public static void setPlayer(Player player)
    {
        Enemy.player = player;
    }
}
