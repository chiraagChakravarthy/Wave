package my.game.infinite.shop.movement;

import my.game.game_state.GameState;
import my.game.infinite.shop.MainShop;
import my.game.infinite.shop.Shop;
import my.game.infinite.shop.health.BSInvulnerability;
import my.game.infinite.shop.health.BSMaxHealth;
import my.game.infinite.shop.health.BSRegeneration;
import my.game.menu.Option;

import java.awt.*;

public class MovementShop extends Shop
{
    private Shop shop;
    public MovementShop(MainShop shop, GameState state)
    {
        super(state);
        this.shop = shop;
        addShop(new BSAcceleration(state, this), new Option(10, 20, "Acceleration", new Color(0, 255, 0), new Color(0, 128, 0)));
        addShop(new BSDeceleration(state, this), new Option(40, 20, "Deceleration", new Color(0, 255, 0), new Color(0, 128, 0)));
        addShop(new BSMaximumSpeed(state, this), new Option(70, 20, "Maximum Speed", new Color(0, 255, 0), new Color(0, 128, 0)));
        options.add(new Option(200, 50, "Back", new Color(100, 255, 0), new Color(0, 128, 0)));
    }

    protected void select()
    {
        if(highlightedOption == 3)
            shop.setMenu(0);
        else
            setMenu(highlightedOption + 1);
    }
}
