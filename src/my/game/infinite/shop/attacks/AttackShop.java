package my.game.infinite.shop.attacks;

import my.game.constants.Constants;
import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.MainShop;
import my.game.infinite.shop.Shop;
import my.game.infinite.shop.attacks.bullets.BulletShop;
import my.game.infinite.shop.attacks.darts.DartShop;
import my.game.menu.Option;
import my.game.menu.SlidingOption;

import java.awt.*;

public class AttackShop extends Shop
{
    private Shop shop;
    public AttackShop(MainShop shop, GameState state, InfinitePlayer player)
    {
        super(state);
        this.shop = shop;
        addShop(new DartShop(state, this, player), new SlidingOption(10, 20, "Darts", new Constants().nameColor, new Constants().boxColor, 0));
        addShop(new BulletShop(state, this, player), new SlidingOption(40, 20, "Bullets", new Constants().nameColor, new Constants().boxColor, 1));
        options.add(new SlidingOption(200, 50, "Back", new Color(100, 255, 0), new Color(0, 128, 0), 2));
    }

    protected void select()
    {
        if(!super.optionMoving())
        {
            if (highlightedOption == 2)
                shop.setMenu(0);
            else
                setMenu(highlightedOption + 1);
        }
    }
}
