package my.game.infinite.shop.attacks.bullets.highSpeed;

import my.game.constants.Constants;
import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.Shop;
import my.game.menu.Label;
import my.game.menu.Option;
import my.game.menu.SlidingOption;

import java.awt.*;

public class HSBulletShop extends Shop
{
    private Shop shop;
    private Label bulletLabel;

    public HSBulletShop(GameState state, Shop shop, InfinitePlayer player)
    {
        super(state);
        this.shop = shop;
        addShop(new BSAmmo(state, this, player), new SlidingOption(110, 20, "Ammo", new Constants().nameColor, new Constants().boxColor, 0));
        addShop(new BSRange(state, this, player), new SlidingOption(140, 20, "Bullet Range", new Constants().nameColor, new Constants().boxColor, 1));
        addShop(new BSSpeedMultiplier(state, this, player), new SlidingOption(170, 20, "Speed Multiplier", new Constants().nameColor, new Constants().boxColor, 2));
        addShop(new BSDamage(state, this, player), new SlidingOption(200, 20, "Damage", new Constants().nameColor, new Constants().boxColor, 3));
        options.add(new SlidingOption(250, 50, "Back", new Constants().nameColor, new Constants().boxColor, 4));
        bulletLabel = new Label(10, 50, "High Speed", new Constants().nameColor, new Constants().boxColor);
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