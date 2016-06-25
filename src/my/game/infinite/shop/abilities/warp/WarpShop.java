package my.game.infinite.shop.abilities.warp;

import my.game.constants.Constants;
import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.Shop;
import my.game.menu.SlidingOption;

public class WarpShop extends Shop
{
    private Shop shop;
    public WarpShop(GameState state, Shop shop, InfinitePlayer player)
    {
        super(state);
        this.shop = shop;
        addShop(new BSWarpDistance(state, this, player), new SlidingOption(10, 20, "Distance", new Constants().nameColor, new Constants().boxColor, 0));
        addShop(new BSWarpCharge(state, this, player), new SlidingOption(40, 20, "Charge Rate", new Constants().nameColor, new Constants().boxColor, 1));
        options.add(new SlidingOption(200, 50, "Back", new Constants().nameColor, new Constants().boxColor, 2));
        setRelativeCoordinates(-1000, 0);
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
        }
    }
}