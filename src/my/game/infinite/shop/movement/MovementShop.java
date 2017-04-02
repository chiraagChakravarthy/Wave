package my.game.infinite.shop.movement;

import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.MainShop;
import my.game.infinite.shop.Shop;
import my.game.infinite.shop.health.BSInvulnerability;
import my.game.infinite.shop.health.BSMaxHealth;
import my.game.infinite.shop.health.BSRegeneration;
import my.game.menu.LabelColor;
import my.game.menu.Option;
import my.game.menu.SlidingOption;

import java.awt.*;

public class MovementShop extends Shop
{
    private Shop shop;
    public MovementShop(MainShop shop, GameState state, InfinitePlayer player)
    {
        super(state);
        this.shop = shop;
        addShop(new BSAcceleration(state, this, player), new SlidingOption(10, 20, "Acceleration", LabelColor.GREEN, 0));
        addShop(new BSDeceleration(state, this, player), new SlidingOption(40, 20, "Deceleration", LabelColor.GREEN, 1));
        addShop(new BSMaximumSpeed(state, this, player), new SlidingOption(70, 20, "Maximum Speed", LabelColor.GREEN, 2));
        options.add(new SlidingOption(200, 50, "Back", LabelColor.GREEN, 4));
        setRelativeCoordinates(-1000, 0);
    }

    protected void select()
    {
        if(!super.optionMoving())
        {
            setRelativeCoordinates(-1000, 0);
            if (highlightedOption == 3)
                shop.setMenu(0);
            else
                setMenu(highlightedOption + 1);
        }
    }
}