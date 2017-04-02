package my.game.infinite.shop.attacks;

import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.MainShop;
import my.game.infinite.shop.Shop;
import my.game.infinite.shop.attacks.bullets.BulletShop;
import my.game.infinite.shop.attacks.darts.DartShop;
import my.game.menu.LabelColor;
import my.game.menu.SlidingOption;

import java.awt.*;

public class AttackShop extends Shop
{//begin class
    private Shop shop;
    public AttackShop(MainShop shop, GameState state, InfinitePlayer player)
    {
        super(state);
        this.shop = shop;
        addShop(new DartShop(state, this, player), new SlidingOption(10, 20, "Darts", LabelColor.GREEN, 0));
        addShop(new BulletShop(state, this, player), new SlidingOption(40, 20, "Bullets", LabelColor.GREEN, 1));
        options.add(new SlidingOption(200, 50, "Back", LabelColor.GREEN, 2));
    }

    protected void select()
    {
        if(!super.optionMoving())
        {
            setRelativeCoordinates(-1000, 0);
            if (highlightedOption == 2)
                shop.setMenu(0);
            else
                setMenu(highlightedOption + 1);
        }//end if statement
    }//end void statement
}//end class
