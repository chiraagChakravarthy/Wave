package my.game.menu;

import my.game.constants.Constants;
import my.game.engine.Game;
import my.game.game_state.MenuState;

public class HelpMenu extends SlideEnterMenu
{
    public HelpMenu(MenuState menuState)
    {
        super(menuState);
        Constants constants = new Constants();
        options.add(new SlidingLabel(10, 20, "Dodge enemies flying at you until the timer ends to advance levels.", constants.nameColor, constants.boxColor, 0));
        options.add(new SlidingOption(50, 50, "Back", constants.nameColor, constants.boxColor, 1));
        ((SlidingOption) options.get(1)).setHighlighted(true);
        setRelativeCoordinates(-1000, 0);
    }

    public void tick()
    {
        setLabelPositions();
        super.tick();
    }

    protected void select()
    {
        if(!optionMoving())
        {
            ((MenuState) state).setMenu(0);
            Game.window.setTitle("Wave");
                setRelativeCoordinates(-1000, 0);
        }
    }
}
