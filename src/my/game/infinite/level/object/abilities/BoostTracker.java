package my.game.infinite.level.object.abilities;

import my.game.infinite.level.object.InfiniteEntity;

public class BoostTracker
{
    private double boostChargePercent;
    private double boostMaxDistance;
    private double boostSpeedMultiplier;
    private double currentDistance;
    private boolean boosting;
    private InfiniteEntity entity;
    public BoostTracker(InfiniteEntity entity)
    {
        this.entity = entity;
        boostChargePercent = 10;
        boostMaxDistance = 1000;
        boostSpeedMultiplier = 2;
    }

    public void tick()
    {
        if(boosting)
        {
            entity.updateLocation();
            entity.checkCollision();
            currentDistance -= entity.getMaxSpeed() * boostSpeedMultiplier;
            if(currentDistance <= 0)
                boosting = false;
        }
        else
        {
            if(currentDistance < boostMaxDistance)
            {
                currentDistance += (boostMaxDistance * boostChargePercent / 6000);
            }
            else
                currentDistance = boostMaxDistance;
        }
    }

    public void boost()
    {
        if(!boosting && currentDistance > boostMaxDistance / 4)
        {
            boosting = true;
            if (Math.abs(entity.getVelX()) > Math.abs(entity.getVelY()))
            {
                double velXQuotient = Math.abs((entity.getMaxSpeed() * boostSpeedMultiplier) / entity.getVelX());
                entity.setVelX(entity.getVelX() * velXQuotient);
                entity.setVelY(entity.getVelY() * velXQuotient);
            }
            else
            {
                double velYQuotient = Math.abs((entity.getMaxSpeed() * boostSpeedMultiplier) / entity.getVelY());
                entity.setVelX(entity.getVelX() * velYQuotient);
                entity.setVelY(entity.getVelY() * velYQuotient);
            }
        }
    }

    public boolean isBoosting()
    {
        return boosting;
    }

    public void setBoostChargePercent(double boostChargePercent)
    {
        this.boostChargePercent = boostChargePercent;
    }

    public void setBoostMaxDistance(double boostMaxDistance)
    {
        this.boostMaxDistance = boostMaxDistance;
    }

    public void setBoostSpeedMultiplier(double boostSpeedMultiplier)
    {
        this.boostSpeedMultiplier = boostSpeedMultiplier;
    }

    public void stop()
    {
        boosting = false;
    }

    public double getChargeRate()
    {
        return boostChargePercent;
    }

    public void addToChargeRate(double addend)
    {
        boostChargePercent += addend;
    }

    public double getBoostMaxDistance()
    {
        return boostMaxDistance;
    }

    public  void addToMaxDistance(double addend)
    {
        boostMaxDistance += addend;
    }

    public double getBoostSpeedMultiplier()
    {
        return boostSpeedMultiplier;
    }

    public void addToSpeedMultiplier(double addend)
    {
        boostSpeedMultiplier += addend;
    }
}