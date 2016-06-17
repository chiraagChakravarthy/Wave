package my.game.infinite.shop.abilities;

import my.game.constants.Constants;
import my.game.game_state.GameState;
import my.game.infinite.shop.Shop;
import my.game.infinite.shop.abilities.invisibility.InvisibilityShop;
import my.game.infinite.shop.abilities.speedBoost.SpeedBoostShop;
import my.game.infinite.shop.abilities.warp.WarpShop;
import my.game.menu.Option;

public class AbilityShop extends Shop
{
    private Shop shop;
    public AbilityShop(Shop shop, GameState state)
    {
        super(state);
        this.shop = shop;
        addShop(new SpeedBoostShop(state, this), new Option(10, 20, "Speed Boost", new Constants().nameColor, new Constants().boxColor));
        addShop(new WarpShop(state, this), new Option(40, 20, "Warp", new Constants().nameColor, new Constants().boxColor));
        addShop(new InvisibilityShop(state, this), new Option(70, 20, "Invisibility", new Constants().nameColor, new Constants().boxColor));
        options.add(new Option(200, 50, "Back", new Constants().nameColor, new Constants().boxColor));
    }

    protected void select()
    {
        if(highlightedOption == options.size() - 1)
            shop.setMenu(0);
        else
            setMenu(highlightedOption + 1);
    }
}
