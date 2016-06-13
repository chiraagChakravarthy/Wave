package my.game.infinite;

import my.game.constants.Constants;
import my.game.engine.Game;
import my.game.game_state.GameState;
import my.game.infinite.hud.InfiniteTimer;
import my.game.object.Entity;
import my.game.object.Player;
import my.game.object.Position;

import java.awt.*;

public class InfiniteLevel
{
    private Player player;
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


        if (player.getHealth() <= 0)
        {

        }
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
        player = new Player(new Constants().player);
        timer = new InfiniteTimer(10, 10);
    }

    public Rectangle getLevelBounds()
    {
        return levelBounds;
    }
}