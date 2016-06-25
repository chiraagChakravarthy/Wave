package my.game.infinite.menu;

import my.game.engine.Game;
import my.game.game_state.GameState;
import my.game.game_state.InfiniteState;
import my.game.menu.*;
import my.game.menu.Label;
import my.game.menu.Menu;

import java.awt.*;
import java.util.ArrayList;


public class GameSelectionMenu extends SlideEnterMenu
{

    public GameSelectionMenu(GameState state)
    {
        super(state);
    }

    public void tick()
    {
        if(highlightedOption > options.size() - 1)
            highlightedOption = 0;
        if(highlightedOption < 0)
            highlightedOption = options.size() - 1;
        for(int i = 0; i < options.size(); i++)
        {
            ((SlidingOption) options.get(i)).setHighlighted(i == highlightedOption);
        }
        setLabelPositions();
        super.tick();
        Label label = options.get(highlightedOption);
        if(label.getY() + label.getHeight() > Game.HEIGHT)
            slide(0, -100);
        if(label.getY() < 0)
            slide(0, 100);
    }

    protected void select()
    {
        if(!optionMoving())
        {
            setRelativeCoordinates(-1000, 0);
            if (highlightedOption == options.size() - 2)
            {
                ((InfiniteState) state).newGame();
                setOptions(((InfiniteState) state).getGameNumber());
                Game.window.setTitle("Wave Infinite");
            }
            else if (highlightedOption == options.size() - 1)
            {
                state.getGsm().setGameState(0);
                Game.window.setTitle("GameMode");
            }
            else
                ((InfiniteState) state).setGame(highlightedOption);
        }
    }

    public void setOptions(int games)
    {
        options = new ArrayList<>();
        int i;
        for(i = 0; i < games; i++)
        {
            options.add(new SlidingOption(i * 100 + 10, 50, "Game " + (i + 1), new Color(0, 255, 0), new Color(0, 128, 0), i));
        }
        options.add(new SlidingOption((i) * 100 + 10, 50, "New Game", new Color(0, 255, 0), new Color(0, 128, 0), i + 1));
        options.add(new SlidingOption((i) * 100 + 110, 50, "Back", new Color(0, 255, 0), new Color(0, 128, 0), i + 2));
        setRelativeCoordinates(-1000, 0);
    }
}
