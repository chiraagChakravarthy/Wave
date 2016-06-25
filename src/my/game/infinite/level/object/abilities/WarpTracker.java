package my.game.infinite.level.object.abilities;

import my.game.infinite.level.object.InfiniteEntity;
import my.game.object.Position;

public class WarpTracker
{
    private double chargePercent;
    private double chargePercentRate;
    private double warpMaxDistance;
    private InfiniteEntity entity;

    public WarpTracker(InfiniteEntity entity)
    {
        this.entity = entity;
        warpMaxDistance = 50;
        chargePercentRate = 100;
    }

    public boolean canWarp()
    {
        return chargePercent == 100;
    }

    public void tick()
    {
        if(chargePercent < 100)
            chargePercent += chargePercentRate / 60;
        else
            chargePercent = 100;
    }

    public void warp(Position target)
    {
        if(chargePercent == 100)
        {
            target.align();
            double xDistance = target.getX() - entity.getX();
            double yDistance = target.getY() - entity.getY();
            double distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
            if(distance <= warpMaxDistance)
                entity.setLocation(target.getX(), target.getY());
            else
            {
                double ratioNum = warpMaxDistance / distance;
                entity.setLocation(entity.getX() + xDistance * ratioNum, entity.getY() + yDistance * ratioNum);
            }
            chargePercent = 0;
        }
    }

    public void addToChargeRate(double addend)
    {
        chargePercentRate += addend;
    }

    public double getChargePercentRate()
    {
        return chargePercentRate;
    }

    public void addToMaxDistance(double addend)
    {
        warpMaxDistance += addend;
    }

    public double getWarpMaxDistance()
    {
        return warpMaxDistance;
    }
}