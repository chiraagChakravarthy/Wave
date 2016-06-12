package my.game.campaign;

import my.game.campaign.hud.HealthBar;
import my.game.campaign.hud.Timer;
import my.game.constants.Constants;
import my.game.engine.Game;
import my.game.game_state.CampaignState;
import my.game.game_state.GameState;
import my.game.object.Enemy;
import my.game.object.EnemyController;
import my.game.object.Entity;
import my.game.object.Player;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class GameLevel
{
    protected Player player;
    protected Timer timer;
    protected EnemyController enemies;
    protected GameState state;
    protected HealthBar healthBar;
    protected int initTime;

    public GameLevel(int time, GameState state)
    {
        this.state = state;
        player = new Player(new Constants().player);
        enemies = new EnemyController();
        timer = new Timer(500, 10, 50, String.valueOf(time));
        healthBar = new HealthBar(10, 10, player.getHealth(), 400, timer.getHeight());
        enemies.setTimer(timer);
        enemies.setPlayer(player);
        initTime = 0;
        init();
    }

    public void tick(double delta)
    {
        Entity.setLevelBounds(new Rectangle(Game.WIDTH, Game.HEIGHT));
        if (initTime < 180)
        {
            initTime++;
            healthBar.setHealth(healthBar.getMaxHealth() * initTime / 180);
            timer.setTime(Math.round((timer.getInitialTime() * initTime / 180) * 10.0) / 10.0);
        }
        else
        {
            healthBar.setHealth(player.getHealth());
            if (timer.getTime() < 0)
                ((CampaignState) state).setLevelEndScreen(true);
            if (player.getHealth() <= 0)
            {
                ((CampaignState) state).setDeathScreen(true);
            }
            timer.tick();
            player.tick();
            enemies.setTimer(timer);
            enemies.setPlayer(player);
            Enemy.setPlayer(player);
            enemies.tick();
        }
    }

    public void render(Graphics g)
    {
        timer.render(g);
        healthBar.render(g);
        player.render(g);
        if (initTime >= 180)
            enemies.render(g);
    }

    public void keyPressed(int k)
    {
        boolean debugMode = Game.debugMode;
        switch (k)
        {
            case KeyEvent.VK_E:
                if (debugMode)
                    timer.setTime(-1);
                break;
            case KeyEvent.VK_K:
                if (debugMode)
                    player.setHealth(0);
                break;

            case KeyEvent.VK_I:
                if (debugMode)
                    player.setInvulnerabilityTime(100000000);
                break;

            case KeyEvent.VK_ESCAPE:
                ((CampaignState) state).setPauseScreen(true);
                break;

            case KeyEvent.VK_1:
                if (debugMode)
                    timer.setTime(timer.getTime() - 1);
                break;

            case KeyEvent.VK_Q:
                if (debugMode)
                    timer.setTime(1);
                break;

            default:
                player.keyPressed(k);
        }
    }

    public void keyReleased(int k)
    {
        if (Game.debugMode)
        {
            switch (k)
            {
                case KeyEvent.VK_I:
                    player.setInvulnerabilityTime(0);
                    break;

                default:
                    player.keyReleased(k);
            }
        }
        else
            player.keyReleased(k);
    }

    public void reset()
    {
        player = new Player(new Constants().player);
        timer.reset();
        enemies = new EnemyController();
        enemies.setTimer(timer);
        enemies.setPlayer(player);
        healthBar = new HealthBar(10, 10, player.getHealth(), 400, timer.getHeight());
        initTime = 0;
        init();
    }

    public abstract void init();
}
