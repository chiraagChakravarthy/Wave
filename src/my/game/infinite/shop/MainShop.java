package my.game.infinite.shop;

import my.game.constants.Constants;
import my.game.game_state.GameState;
import my.game.infinite.InfiniteGame;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.abilities.AbilityShop;
import my.game.infinite.shop.appearence.AppearanceShop;
import my.game.infinite.shop.attacks.AttackShop;
import my.game.infinite.shop.health.HealthShop;
import my.game.infinite.shop.movement.MovementShop;
import my.game.infinite.shop.utilities.UtilitiesShop;
import my.game.menu.Label;
import my.game.menu.SlidingOption;

import java.awt.*;

public class MainShop extends Shop
{
    private Label creditsLabel;
    private double credits;
    private InfiniteGame game;

    public MainShop(GameState state, InfiniteGame game, InfinitePlayer player)
    {
        super(state);
        setOptions(player);
        this.game = game;
        creditsLabel = new Label(40, 400, 20, "Credits: " + 1, new Color(0, 255, 0), new Color(0, 128, 0));
        setCredits(20);
        setRelativeCoordinates(-1000, 0);
    }

    public void render(Graphics g)
    {
        creditsLabel.render(g);
        super.render(g);
    }

    private void setOptions(InfinitePlayer player)
    {
        addShop(new HealthShop(this, state, player), new SlidingOption(10, 20, "Health", new Constants().nameColor, new Constants().boxColor, 0));
        addShop(new AbilityShop(this, state, player), new SlidingOption(40, 20, "Abilities", new Constants().nameColor, new Constants().boxColor, 1));
        addShop(new MovementShop(this,state, player), new SlidingOption(70, 20, "Movement", new Constants().nameColor, new Constants().boxColor, 2));
        addShop(new AttackShop(this, state, player), new SlidingOption(100, 20, "Attacks", new Constants().nameColor, new Constants().boxColor, 3));
        addShop(new AppearanceShop(this, state), new SlidingOption(130, 20, "Appearence", new Constants().nameColor, new Constants().boxColor, 4));
        addShop(new UtilitiesShop(this, state), new SlidingOption(160, 20, "Utilities", new Constants().nameColor, new Constants().boxColor, 5));
        options.add(new SlidingOption(200, 50, "Back", new Constants().nameColor, new Constants().boxColor, 6));
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
        if(!super.optionMoving())
        {
            setRelativeCoordinates(-1000, 0);
            if (highlightedOption < options.size() - 1)
                setMenu(highlightedOption + 1);
            else
                game.setGameState(0);
        }
    }
}