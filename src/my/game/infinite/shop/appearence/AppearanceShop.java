package my.game.infinite.shop.appearence;

import my.game.game_state.GameState;
import my.game.infinite.shop.Shop;
import my.game.menu.LabelColor;
import my.game.menu.SlidingOption;

public class AppearanceShop extends Shop
{
    private Shop shop;
    public AppearanceShop(Shop shop, GameState state)
    {
        super(state);
        this.shop = shop;
        //color
        //tail type (achievement unlocked)
        options.add(new SlidingOption(200, 50, "Back", LabelColor.GREEN, 0));
        setRelativeCoordinates(-1000, 0);
    }

    protected void select()
    {
        if(!super.optionMoving())
        {
            if (highlightedOption == 0)
                shop.setMenu(0);
            else
                setMenu(highlightedOption + 1);
            setRelativeCoordinates(-1000, 0);
        }
    }
}