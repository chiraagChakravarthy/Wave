package my.game.infinite.level.object;

import my.game.infinite.level.object.abilities.BoostTracker;
import my.game.infinite.level.object.abilities.CloakTracker;
import my.game.infinite.level.object.abilities.WarpTracker;
import my.game.object.Entity;
import my.game.object.tail.Tail;

public class InfiniteEntity extends Entity {
    protected BoostTracker booster;
    protected WarpTracker warper;
    protected CloakTracker cloaker;

    public InfiniteEntity(double x, double y, double acc, double dcc, double maxSpeed, Tail tail, int heath) {
        super(x, y, acc, dcc, maxSpeed, tail);
        booster = new BoostTracker(this);
        warper = new WarpTracker(this);
        cloaker = new CloakTracker(this);
    }

    public void tick() {
        if (!booster.isBoosting()) {
            super.tick();
        }
        booster.tick();
        warper.tick();
        cloaker.tick();
    }

    public BoostTracker getBooster() {
        return booster;
    }

    public WarpTracker getWarper() {
        return warper;
    }

    public CloakTracker getCloaker() {
        return cloaker;
    }


}