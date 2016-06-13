package my.game.game_state;

import my.game.infinite.InfiniteGame;
import my.game.infinite.menu.GameSelectionMenu;

import java.awt.*;
import java.util.ArrayList;

public class InfiniteState extends GameState
{
    private ArrayList<InfiniteGame> games;
    private int game;
    private GameSelectionMenu gameMenu;
    private boolean inMenu;
    public InfiniteState(GameStateManager gsm)
    {
        super(gsm);
        games = new ArrayList<InfiniteGame>();
        gameMenu = new GameSelectionMenu(this);
        gameMenu.setOptions(games.size());
        inMenu = true;
    }

    public void tick(double delta)
    {
        if(inMenu)
            gameMenu.tick();
        else
        {
            games.get(game).tick();
        }
    }

    public void render(Graphics g)
    {
        if(inMenu)
            gameMenu.render(g);
        else
            games.get(game).render(g);
    }

    public void keyPressed(int k)
    {
        if(inMenu)
            gameMenu.keyPressed(k);
        else
            games.get(game).keyPressed(k);
    }

    public void keyReleased(int k)
    {
        if(inMenu)
            gameMenu.keyReleased(k);
        else
            games.get(game).keyReleased(k);
    }

    public void newGame()
    {
        games.add(new InfiniteGame(this));
        game = games.size() - 1;
        inMenu = false;
    }

    public void setGame(int game)
    {
        this.game = game;
        inMenu = false;
    }

    public void setInMenu(boolean inMenu)
    {
        this.inMenu = inMenu;
        gameMenu.setOptions(games.size());
    }

    public int getGameNumber()
    {
        return game;
    }
    public InfiniteGame getGame()
    {
        return games.get(game);
    }
}
