package my.game.infinite.shop.utilities;


import my.game.constants.Constants;
import my.game.game_state.GameState;
import my.game.infinite.shop.Shop;
import my.game.menu.Option;
import my.game.menu.SlidingOption;

public class UtilitiesShop extends Shop
{
    private Shop shop;
    public UtilitiesShop(Shop shop, GameState state)
    {
        super(state);
        this.shop = shop;
        //Arena clearer
        //Hyper Boost
        //Invincibility
        //Coin Doubler
        options.add(new SlidingOption(200, 50, "Back", new Constants().nameColor, new Constants().boxColor, 0));
        setRelativeCoordinates(-1000, 0);
    }

    protected void select()
    {
        if(!super.optionMoving())
        {
            setRelativeCoordinates(-1000, 0);
            if (highlightedOption == 0)
                shop.setMenu(0);
            else
                setMenu(highlightedOption + 1);
        }
    }
}
