package my.game.infinite.shop.attacks.bullets.explosive;

import my.game.constants.Constants;
import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.Shop;
import my.game.infinite.shop.abilities.speedBoost.BSSpeedMultiplier;
import my.game.menu.Label;
import my.game.menu.Option;
import my.game.menu.SlidingOption;

import java.awt.*;

public class ExplosiveBulletShop extends Shop
{
    private Shop shop;
    private Label bulletLabel;
    public ExplosiveBulletShop(GameState state, Shop shop, InfinitePlayer player)
    {
        super(state);
        addShop(new BSAmmo(state, shop, player), new SlidingOption(110, 20, "Ammo", new Constants().nameColor, new Constants().boxColor, 0));
        addShop(new BSRange(state, shop, player), new SlidingOption(140, 20, "Bullet Range", new Constants().nameColor, new Constants().boxColor, 1));
        addShop(new BSSpeedMultiplier(state, shop, player), new SlidingOption(170, 20, "Speed Multiplier", new Constants().nameColor, new Constants().boxColor, 2));
        addShop(new BSDamage(state, this, player), new SlidingOption(200, 20, "Damage", new Constants().nameColor, new Constants().boxColor, 3));
        //explosion radius
        //fire effect
        options.add(new SlidingOption(250, 50, "Back", new Constants().nameColor, new Constants().boxColor, 4));
        this.shop = shop;
        bulletLabel = new Label(10, 50, "Explosive", new Constants().nameColor, new Constants().boxColor);
        setRelativeCoordinates(-1000, 0);
    }

    public void render(Graphics g)
    {
        if(menu == 0)
            bulletLabel.render(g);
        super.render(g);
    }

    protected void select()
    {
        if(!super.optionMoving())
        {
            setRelativeCoordinates(-1000, 0);
            if (highlightedOption == 4)
                shop.setMenu(0);
            else
                setMenu(highlightedOption + 1);
        }
    }
}