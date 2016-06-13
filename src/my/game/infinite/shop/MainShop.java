package my.game.infinite.shop;

import my.game.constants.Constants;
import my.game.engine.Game;
import my.game.game_state.GameState;
import my.game.infinite.InfiniteGame;
import my.game.infinite.shop.health.BSMaxHealth;
import my.game.infinite.shop.health.HealthShop;
import my.game.menu.Label;
import my.game.menu.Menu;
import my.game.menu.Option;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MainShop extends Shop
{
    private Label creditsLabel;
    private int credits;
    private InfiniteGame game;

    public MainShop(GameState state, InfiniteGame game)
    {
        super(state);
        setOptions();
        this.game = game;
        creditsLabel = new Label(40, 400, 20, "Credits: " + 1, new Color(0, 255, 0), new Color(0, 128, 0));
        setCredits(20);
    }

    public void render(Graphics g)
    {
        creditsLabel.render(g);
        super.render(g);
    }

    private void setOptions()
    {

        addShop(new HealthShop(this, state), new Option(15, 10, 20, "Health", new Constants().nameColor, new Constants().boxColor));
        addShop(null, new Option(145, 10, 20, "Abilities", new Constants().nameColor, new Constants().boxColor));
        addShop(null, new Option(265, 10, 20, "Movement", new Constants().nameColor, new Constants().boxColor));
        addShop(null, new Option(385, 10, 20, "Attacks", new Constants().nameColor, new Constants().boxColor));
        addShop(null, new Option(515, 10, 20, "Appearence", new Constants().nameColor, new Constants().boxColor));
        options.add(new Option(300, 50, "Back", new Constants().nameColor, new Constants().boxColor));
        for (int i = 0; i < options.size() - 2; i++)
        {
            options.get(i).setWidth(100);
        }
    }

    public void setCredits(int credits)
    {
        this.credits = credits;
        creditsLabel.setName("Credits: " + credits);
    }


    public int getCredits()
    {
        return credits;
    }

    protected void select()
    {
        if(highlightedOption < options.size() - 1)
            setMenu(highlightedOption + 1);
        else
            game.setGameState(0);
    }
}