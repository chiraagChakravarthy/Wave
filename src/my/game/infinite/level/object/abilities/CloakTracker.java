package my.game.infinite.level.object.abilities;

import my.game.infinite.level.object.InfiniteEntity;

public class CloakTracker
{
    private double maxCloakTime;
    private double currentTime;
    private double percentChargeRate;
    private boolean cloaked;
    private InfiniteEntity entity;
    public CloakTracker(InfiniteEntity entity)
    {
        maxCloakTime = 0;
        currentTime = 0;
        percentChargeRate = 0;
        this.entity = entity;
    }

    public void tick()
    {
        if(cloaked)
        {
            currentTime -= 1/60;
            if(currentTime <= 0)
                deCloak();

        }
        else
        {
            if(currentTime < maxCloakTime)
                currentTime += (percentChargeRate / 60) * maxCloakTime;
            else
                currentTime = maxCloakTime;
        }
    }

    public void cloak()
    {
        if(currentTime > maxCloakTime / 4)
        {
            cloaked = true;
            entity.setInvisible(true);
        }
    }

    public void deCloak()
    {
        cloaked = false;
        entity.setInvisible(false);
    }

    public double getMaxCloakTime()
    {
        return maxCloakTime;
    }

    public double getPercentChargeRate()
    {
        return percentChargeRate;
    }

    public void addToChargeRate(double addend)
    {
        percentChargeRate += addend;
    }

    public void addToMaximumTime(double addend)
    {
        maxCloakTime += addend;
    }
}