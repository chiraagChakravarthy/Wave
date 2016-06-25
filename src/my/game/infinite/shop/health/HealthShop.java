package my.game.infinite.shop.health;

import my.game.engine.Game;
import my.game.game_state.GameState;
import my.game.infinite.InfiniteGame;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.BuySellMenu;
import my.game.infinite.shop.MainShop;
import my.game.infinite.shop.Shop;
import my.game.menu.Menu;
import my.game.menu.Option;
import my.game.menu.SlidingOption;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class HealthShop extends Shop
{
    private Shop shop;
    public HealthShop(MainShop shop, GameState state, InfinitePlayer player)
    {
        super(state);
        this.shop = shop;
        addShop(new BSMaxHealth(state, this, player), new SlidingOption(10, 20, "Max Health", new Color(0, 255, 0), new Color(0, 128, 0), 0));
        addShop(new BSInvulnerability(state, this, player), new SlidingOption(40, 20, "Invulnerability", new Color(0, 255, 0), new Color(0, 128, 0), 1));
        addShop(new BSRegeneration(state, this, player), new SlidingOption(70, 20, "Regeneration", new Color(0, 255, 0), new Color(0, 128, 0), 2));
        options.add(new SlidingOption(200, 50, "Back", new Color(100, 255, 0), new Color(0, 128, 0), 3));
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
