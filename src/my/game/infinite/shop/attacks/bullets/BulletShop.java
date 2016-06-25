package my.game.infinite.shop.attacks.bullets;

import my.game.constants.Constants;
import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.Shop;
import my.game.infinite.shop.attacks.bullets.explosive.ExplosiveBulletShop;
import my.game.infinite.shop.attacks.bullets.highSpeed.HSBulletShop;
import my.game.infinite.shop.attacks.bullets.homing.HomingBulletShop;
import my.game.menu.Option;
import my.game.menu.SlidingOption;

public class BulletShop extends Shop
{
    private Shop shop;

    public BulletShop(GameState state, Shop shop, InfinitePlayer player)
    {
        super(state);
        this.shop = shop;
        addShop(new HSBulletShop(state, this, player), new SlidingOption(10, 20, "High Speed Bullets", new Constants().nameColor, new Constants().boxColor, 0));
        addShop(new HomingBulletShop(state, this, player), new SlidingOption(40, 20, "Homing Bullets", new Constants().nameColor, new Constants().boxColor, 1));
        addShop(new ExplosiveBulletShop(state, this, player), new SlidingOption(70, 20, "Explosive Bullets", new Constants().nameColor, new Constants().boxColor, 2));
        options.add(new SlidingOption(200, 50, "Back", new Constants().nameColor, new Constants().boxColor, 3));
    }

    protected void select()
    {
        if(!super.optionMoving())
        {
            if (highlightedOption == 3)
                shop.setMenu(0);
            else
                setMenu(highlightedOption + 1);
        }
    }
}
