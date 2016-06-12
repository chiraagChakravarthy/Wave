package my.game.game_state;

import java.awt.*;
import java.util.ArrayList;

public class GameStateManager
{
    private int gameState;
    private ArrayList<GameState> gameStates = new ArrayList<GameState>();

    public GameStateManager(int gameState)
    {
        this.gameState = gameState;
        gameStates.add(new MenuState(this));
        gameStates.add(new CampaignState(this));
        gameStates.add(new InfiniteState(this));
    }

    public void setGameState(int gameState)
    {
        this.gameState = gameState;
    }

    public void tick(double delta)
    {
        gameStates.get(gameState).tick(delta);
    }

    public void render(Graphics g)
    {
        gameStates.get(gameState).render(g);
    }

    public void keyPressed(int k)
    {
        gameStates.get(gameState).keyPressed(k);
    }

    public void keyReleased(int k)
    {
        gameStates.get(gameState).keyReleased(k);
    }

    public GameState getGameState(int gameState)
    {
        return gameStates.get(gameState);
    }
}
