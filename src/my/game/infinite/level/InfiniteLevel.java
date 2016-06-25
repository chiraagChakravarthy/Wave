package my.game.infinite.level;

import my.game.engine.Game;
import my.game.game_state.GameState;
import my.game.infinite.hud.InfiniteTimer;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.object.Entity;
import my.game.object.Position;

import java.awt.*;
import java.awt.event.MouseEvent;

public class InfiniteLevel
{
    private InfinitePlayer player;
    private Rectangle levelBounds = new Rectangle(1000, 1000);
    private InfiniteTimer timer;

    public InfiniteLevel(GameState state)
    {
        init();
        Entity.setLevelBounds(levelBounds);
    }

    public void tick()
    {
        player.tick();
        timer.tick();
        if (player.getY() + Game.HEIGHT / 2 < levelBounds.getHeight() && player.getY() - Game.HEIGHT / 2 > 0)
            Position.setYOffset(player.getY() - Game.HEIGHT / 2);

        if (player.getX() + Game.WIDTH / 2 < levelBounds.getWidth() && player.getX() - Game.WIDTH / 2 > 0)
            Position.setXOffset(player.getX() - Game.WIDTH / 2);
    }

    public void render(Graphics g)
    {
        timer.render(g);
        player.render(g);
    }

    public void keyPressed(int k)
    {
        player.keyPressed(k);
    }

    public void keyReleased(int k)
    {
        player.keyReleased(k);
    }

    public void init()
    {
        player = new InfinitePlayer(levelBounds.getWidth() / 2 - 16, levelBounds.getHeight() / 2 - 16);
        timer = new InfiniteTimer(10, 10);
    }

    public Rectangle getLevelBounds()
    {
        return levelBounds;
    }

    public void mousePressed(MouseEvent e)
    {
        player.mousePressed(e);
    }

    public void mouseReleased(MouseEvent e)
    {
        player.mouseReleased(e);
    }
}