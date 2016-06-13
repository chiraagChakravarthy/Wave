package my.game.infinite.menu;

import my.game.engine.Game;
import my.game.game_state.GameState;
import my.game.game_state.InfiniteState;
import my.game.menu.*;
import my.game.menu.Label;
import my.game.menu.Menu;

import java.awt.*;
import java.util.ArrayList;


public class GameSelectionMenu extends Menu
{

    public GameSelectionMenu(GameState state)
    {
        super(state);
    }

    public void tick()
    {
        for(int i = 0; i < options.size(); i++)
        {
            ((Option) options.get(i)).setHighlighted(i == highlightedOption);
        }
    }

    protected void select()
    {
        Game.window.setTitle("Wave Infinite");
        if (highlightedOption == options.size() - 2)
        {
            ((InfiniteState) state).newGame();
            this.setOptions(((InfiniteState) state).getGameNumber());
        }
        else if (highlightedOption == options.size() - 1)
        {
            state.getGsm().setGameState(0);
        }
        else
        {
            ((InfiniteState) state).setGame(highlightedOption);
        }
    }

    public void setOptions(int games)
    {
        options = new ArrayList<>();
        int i;
        for(i = 0; i < games; i++)
        {
            options.add(new Option(i * 100 + 10, 50, "Game " + (i + 1), new Color(0, 255, 0), new Color(0, 128, 0)));
        }
        options.add(new Option((i) * 100 + 10, 50, "New Game", new Color(0, 255, 0), new Color(0, 128, 0)));
        options.add(new Option((i) * 100 + 110, 50, "Back", new Color(0, 255, 0), new Color(0, 128, 0)));
    }
}
