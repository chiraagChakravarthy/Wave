package my.game.menuState;

import my.game.constants.Constants;
import my.game.engine.Game;
import my.game.game_state.MenuState;

public class HelpMenu extends Menu
{
    public HelpMenu(MenuState menuState)
    {
        super(menuState);
        Constants constants = new Constants();
        options.add(new Label(10, 20, "Dodge enemies flying at you until the timer ends to advance levels.", constants.nameColor, constants.boxColor));
        options.add(new Option(50, 50, "Back", constants.nameColor, constants.boxColor));
        ((Option) options.get(1)).setHighlighted(true);
    }

    public void tick()
    {
        super.tick();
    }

    protected void select()
    {
        ((MenuState) state).setMenu(0);
        Game.window.setTitle("Wave");
    }
}
