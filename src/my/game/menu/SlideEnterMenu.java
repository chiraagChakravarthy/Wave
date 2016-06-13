package my.game.menu;

import my.game.game_state.GameState;

public abstract class SlideEnterMenu extends Menu
{
    protected int timer;
    protected double velX;
    protected double velY;

    public SlideEnterMenu(GameState state)
    {
        super(state);
    }

    protected void setRelativeCoordinates(double relativeX, double relativeY)
    {
        for (int i = 0; i < options.size(); i++)
        {
            ((SlidingOption) options.get(i)).setRelativeCoordinates(relativeX, relativeY);
        }
        velX = relativeX / 10;
        velY = relativeY / 10;
        timer = 0;
    }

    protected void setLabelPositions()
    {
        for (int i = 0; i < options.size(); i++)
        {
            if (((SlidingOption) options.get(i)).shouldMove(timer))
            {
                ((SlidingOption) options.get(i)).move(velX, velY);
            }
        }
        timer++;
    }

    public boolean optionMoving()
    {
        for (int i = 0; i < options.size(); i++)
        {
            if (((SlidingOption) options.get(i)).shouldMove(timer))
                return true;
        }
        return false;
    }
}
