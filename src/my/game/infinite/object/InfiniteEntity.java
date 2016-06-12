package my.game.infinite.object;

import my.game.object.Entity;
import my.game.object.tail.Tail;

public class InfiniteEntity extends Entity
{
    private BoostTracker booster;

    public InfiniteEntity(float x, float y, float acc, float dcc, float maxSpeed, Tail tail)
    {
        super(x, y, acc, dcc, maxSpeed, tail);
    }

    public InfiniteEntity(InfiniteEntity infiniteEntity)
    {
        super(infiniteEntity);
    }
}
