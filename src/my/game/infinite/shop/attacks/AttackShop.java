package my.game.infinite.shop.attacks;

import my.game.constants.Constants;
import my.game.game_state.GameState;
import my.game.infinite.shop.MainShop;
import my.game.infinite.shop.Shop;
import my.game.infinite.shop.attacks.bullets.BulletShop;
import my.game.infinite.shop.attacks.darts.DartShop;
import my.game.menu.Option;

import java.awt.*;

public class AttackShop extends Shop
{
    private Shop shop;
    public AttackShop(MainShop shop, GameState state)
    {
        super(state);
        this.shop = shop;
        addShop(new DartShop(state, this), new Option(10, 20, "Darts", new Constants().nameColor, new Constants().boxColor));
        addShop(new BulletShop(state, this), new Option(40, 20, "Bullets", new Constants().nameColor, new Constants().boxColor));
        options.add(new Option(200, 50, "Back", new Color(100, 255, 0), new Color(0, 128, 0)));
    }

    protected void select()
    {
        if(highlightedOption == 2)
            shop.setMenu(0);
        else
            setMenu(highlightedOption + 1);
    }
}
