package my.game.infinite.shop.health;

import my.game.engine.Game;
import my.game.game_state.GameState;
import my.game.infinite.shop.BuySellMenu;
import my.game.infinite.shop.MainShop;
import my.game.infinite.shop.Shop;
import my.game.menu.Menu;
import my.game.menu.Option;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class HealthShop extends Shop
{
    private Shop shop;
    public HealthShop(MainShop shop, GameState state)
    {
        super(state);
        this.shop = shop;
        addShop(new BSMaxHealth(state, this), new Option(10, 20, "Max Health", new Color(0, 255, 0), new Color(0, 128, 0)));
        addShop(new BSInvulnerability(state, this), new Option(40, 20, "Invulnerability", new Color(0, 255, 0), new Color(0, 128, 0)));
        addShop(new BSRegeneration(state, this), new Option(70, 20, "Regeneration", new Color(0, 255, 0), new Color(0, 128, 0)));
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
