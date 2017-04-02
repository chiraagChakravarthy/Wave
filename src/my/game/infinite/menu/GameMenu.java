package my.game.infinite.menu;

import my.game.engine.Game;
import my.game.game_state.GameState;
import my.game.game_state.InfiniteState;
import my.game.infinite.InfiniteGame;
import my.game.menu.LabelColor;
import my.game.menu.SlideEnterMenu;
import my.game.menu.SlidingOption;

import java.awt.*;

public class GameMenu extends SlideEnterMenu
{
    private InfiniteGame game;
    public GameMenu(GameState state, InfiniteGame game)
    {
        super(state);
        this.game = game;
        options.add(new SlidingOption(10, 50, "Play", LabelColor.GREEN, 0));
        options.add(new SlidingOption(100, 50, "Shop", LabelColor.GREEN, 1));
        options.add(new SlidingOption(200, 50, "Exit", LabelColor.GREEN, 2));
        setRelativeCoordinates(-1000, 0);
    }

    public void tick()
    {
        super.tick();
        setLabelPositions();
        for(int i = 0; i < options.size(); i++)
        {
            ((SlidingOption) options.get(i)).setHighlighted(i == highlightedOption);
        }
    }

    protected void select()
    {
        setRelativeCoordinates(-1000, 0);
        switch(highlightedOption)
        {
            case 0:
                game.setGameState(1);
                break;
            case 1:
                game.setGameState(2);
                break;

            case 2:
                ((InfiniteState)state).setInMenu(true);
                Game.window.setTitle("Game Selection");
                break;
        }
    }
}
