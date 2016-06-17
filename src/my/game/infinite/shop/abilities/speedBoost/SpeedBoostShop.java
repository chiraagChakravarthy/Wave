package my.game.infinite.shop.abilities.speedBoost;

import my.game.constants.Constants;
import my.game.game_state.GameState;
import my.game.infinite.shop.Shop;
import my.game.menu.Option;

public class SpeedBoostShop extends Shop
{
    private Shop shop;
    public SpeedBoostShop(GameState state, Shop shop)
    {
        super(state);
        this.shop = shop;
        addShop(new BSBoostDistance(state, this), new Option(10, 20, "Distance", new Constants().nameColor, new Constants().boxColor));
        addShop(new BSSpeedMultiplier(state, this), new Option(40, 20, "Speed Multiplier", new Constants().nameColor, new Constants().boxColor));
        addShop(new BSBoostCharge(state, this), new Option(70, 20, "Boost Charge Rate", new Constants().nameColor, new Constants().boxColor));
        options.add(new Option(200, 50, "Back", new Constants().nameColor, new Constants().boxColor));
    }

    protected void select()
    {
        if(highlightedOption == 3)
            shop.setMenu(0);
        else
            setMenu(highlightedOption + 1);
    }
}
