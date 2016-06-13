package my.game.infinite.menu;

import my.game.engine.Game;
import my.game.game_state.GameState;
import my.game.game_state.InfiniteState;
import my.game.infinite.InfiniteGame;
import my.game.menu.Menu;
import my.game.menu.Option;

import java.awt.*;

public class GameMenu extends Menu
{
    private InfiniteGame game;
    public GameMenu(GameState state, InfiniteGame game)
    {
        super(state);
        this.game = game;
        options.add(new Option(10, 50, "Play", new Color(0, 255, 0), new Color(0, 128, 0)));
        options.add(new Option(100, 50, "Shop", new Color(0, 255, 0), new Color(0, 128, 0)));
        options.add(new Option(200, 50, "Exit", new Color(0, 255, 0), new Color(0, 128, 0)));
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
