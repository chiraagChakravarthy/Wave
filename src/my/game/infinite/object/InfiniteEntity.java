package my.game.infinite.object;

import my.game.infinite.object.abilities.BoostTracker;
import my.game.object.Entity;
import my.game.object.tail.Tail;

public class InfiniteEntity extends Entity
{
    private BoostTracker booster;

    public InfiniteEntity(float x, float y, float acc, float dcc, float maxSpeed, Tail tail, BoostTracker booster)
    {
        super(x, y, acc, dcc, maxSpeed, tail);
        this.booster = booster;
    }

    public InfiniteEntity(InfiniteEntity infiniteEntity)
    {
        super(infiniteEntity);
    }
    public BoostTracker getBooster()
    {
        return booster;
    }
}
