package my.game.infinite.shop;

import my.game.constants.Constants;
import my.game.game_state.GameState;
import my.game.menuState.SlideEnterMenu;
import my.game.menuState.SlidingOption;

public class Shop extends SlideEnterMenu
{
    private int credits;

    public Shop(GameState state)
    {
        super(state);
        setOptions();
    }

    public void tick()
    {
        for (int i = 0; i < options.size(); i++)
        {
            ((SlidingOption) options.get(i)).setHighlighted(i == highlightedOption);
        }
    }

    protected void select()
    {
        if (!super.optionMoving())
        {
            switch (highlightedOption)
            {
                case 0:


                case 1:
            }
        }
    }

    private void setOptions()
    {

        options.add(new SlidingOption(10, 10, 20, "Health", new Constants().nameColor, new Constants().boxColor, 0));
        options.add(new SlidingOption(80, 10, 20, "Boost", new Constants().nameColor, new Constants().boxColor, 0));
        for (int i = 0; i < options.size(); i++)
        {
            options.get(i).setWidth(60);
        }
    }
}
