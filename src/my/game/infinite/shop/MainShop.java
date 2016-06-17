package my.game.infinite.shop;

import my.game.constants.Constants;
import my.game.game_state.GameState;
import my.game.infinite.InfiniteGame;
import my.game.infinite.shop.abilities.AbilityShop;
import my.game.infinite.shop.health.HealthShop;
import my.game.infinite.shop.movement.MovementShop;
import my.game.menu.Label;
import my.game.menu.Option;

import java.awt.*;

public class MainShop extends Shop
{
    private Label creditsLabel;
    private double credits;
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
        addShop(new HealthShop(this, state), new Option(10, 20, "Health", new Constants().nameColor, new Constants().boxColor));
        addShop(new AbilityShop(this, state), new Option(40, 20, "Abilities", new Constants().nameColor, new Constants().boxColor));
        addShop(new MovementShop(this,state), new Option(70, 20, "Movement", new Constants().nameColor, new Constants().boxColor));
        addShop(null, new Option(100, 20, "Attacks", new Constants().nameColor, new Constants().boxColor));
        addShop(null, new Option(130, 20, "Appearence", new Constants().nameColor, new Constants().boxColor));
        addShop(null, new Option(160, 20, "Utilities", new Constants().nameColor, new Constants().boxColor));
        options.add(new Option(200, 50, "Back", new Constants().nameColor, new Constants().boxColor));
    }

    public void setCredits(double credits)
    {
        this.credits = credits;
        creditsLabel.setName("Credits: " + (int)credits);
    }


    public double getCredits()
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