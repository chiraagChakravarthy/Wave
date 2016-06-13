package my.game.infinite.object;

import my.game.infinite.object.abilities.BoostTracker;
import my.game.object.tail.Tail;

import java.awt.*;

public class InfinitePlayer extends InfiniteEntity
{
    public InfinitePlayer(float x, float y)
    {
        super(x, y, 0.1F, 0.05F, 1, new Tail(5, Color.white), new BoostTracker());
    }

    public InfinitePlayer(InfinitePlayer player)
    {
        super(player);
    }
}