package my.game.infinite;

import my.game.game_state.GameState;
import my.game.infinite.menu.GameMenu;
import my.game.infinite.object.InfinitePlayer;
import my.game.infinite.shop.MainShop;
import my.game.infinite.shop.Shop;

import java.awt.*;

public class InfiniteGame
{
    private InfinitePlayer player;
    private MainShop shop;
    private InfiniteLevel level;
    private GameMenu gameMenu;
    private GameState state;
    private int gameState;

    public InfiniteGame(GameState state)
    {
        gameState = 0;
        this.state = state;
        level = new InfiniteLevel(state);
        player = new InfinitePlayer((float) level.getLevelBounds().getWidth() / 2 - 16, (float) level.getLevelBounds().getHeight() / 2 - 16);
        shop = new MainShop(state, this);
        gameMenu = new GameMenu(state, this);
    }

    public void tick()
    {
        switch(gameState)
        {
            case 0:
                gameMenu.tick();
                break;
            case 1:
                level.tick();
                break;
            case 2:
                shop.tick();
        }
    }

    public void render(Graphics g)
    {
        switch(gameState)
        {
            case 0:
                gameMenu.render(g);
                break;
            case 1:
                level.render(g);
                break;
            case 2:
                shop.render(g);
        }
    }

    public void keyPressed(int k)
    {
        switch(gameState)
        {
            case 0:
                gameMenu.keyPressed(k);
                break;
            case 1:
                level.keyPressed(k);
                break;
            case 2:
                shop.keyPressed(k);
        }
    }

    public void keyReleased(int k)
    {
        switch(gameState)
        {
            case 0:
                gameMenu.keyReleased(k);
                break;
            case 1:
                level.keyReleased(k);
                break;
            case 2:
                shop.keyReleased(k);
        }
    }

    public void setGameState(int gameState)
    {
        this.gameState = gameState;
    }

    public void setCredits(double credits)
    {
        shop.setCredits(credits);
    }

    public double getCredits()
    {
        return shop.getCredits();
    }

    public Shop getShop()
    {
        return shop;
    }
}
