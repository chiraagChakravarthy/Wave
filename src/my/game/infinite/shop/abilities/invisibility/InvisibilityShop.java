package my.game.infinite.shop.abilities.invisibility;

import my.game.constants.Constants;
import my.game.game_state.GameState;
import my.game.infinite.shop.Shop;
import my.game.menu.Option;

public class InvisibilityShop extends Shop
{
    private Shop shop;
    public InvisibilityShop(GameState state, Shop shop)
    {
        super(state);
        this.shop = shop;
        addShop(new BSInvisTime(state, this), new Option(10, 20, "Invisibility Time", new Constants().nameColor, new Constants().boxColor));
        addShop(new BSInvisChargeRate(state, this), new Option(40, 20, "Invisibility Charge Rate", new Constants().nameColor, new Constants().boxColor));
        options.add(new Option(200, 50, "Back", new Constants().nameColor, new Constants().boxColor));
    }

    protected void select()
    {
        if(highlightedOption == 2)
            shop.setMenu(0);
        else
            setMenu(highlightedOption + 1);
    }
}
