package my.game.infinite.object.abilities;

import my.game.object.Entity;

import java.awt.*;

public class BoostTracker
{
    private double maxCharge;
    private double charge;
    private double boostSpeedMultiplier;

    public BoostTracker()
    {
        maxCharge = 0;
        charge = 0;
        boostSpeedMultiplier = 1;
    }

    public void charge(Entity entity)
    {
        Point.distance(1, 1, 1, 1);
    }
}