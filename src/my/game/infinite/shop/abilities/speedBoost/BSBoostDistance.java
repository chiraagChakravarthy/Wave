package my.game.infinite.shop.abilities.speedBoost;

import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.BuySellMenu;
import my.game.infinite.shop.Shop;

public class BSBoostDistance extends BuySellMenu
{

    public BSBoostDistance(GameState state, Shop shop, InfinitePlayer player)
    {
        super(state, "Boost Distance", 5, shop, player);
        setDisplay(player.getBooster().getBoostMaxDistance() + " pixels");
    }

    public boolean canSell()
    {
        return player.getBooster().getBoostMaxDistance() > 0;
    }

    public boolean canBuy()
    {
        return player.getBooster().getBoostMaxDistance() < 500;
    }

    protected void buy()
    {
        player.getBooster().addToMaxDistance(20);
        setDisplay(player.getBooster().getBoostMaxDistance() + " pixels");
    }

    protected void sell()
    {
        player.getBooster().addToMaxDistance(-20);
        setDisplay(player.getBooster().getBoostMaxDistance() + " pixels");
    }
}
