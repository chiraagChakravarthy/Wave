package my.game.infinite.shop.abilities.speedBoost;

import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.BuySellMenu;
import my.game.infinite.shop.Shop;

public class BSBoostChargeRate extends BuySellMenu
{
    public BSBoostChargeRate(GameState state, Shop shop, InfinitePlayer player)
    {
        super(state, "Boost Charge Rate", 7, shop, player);
        setDisplay(player.getBooster().getChargeRate() + "% per second");
    }

    public boolean canSell()
    {
        return player.getBooster().getChargeRate() >= 5;
    }

    public boolean canBuy()
    {
        return player.getBooster().getChargeRate() < 100;
    }

    protected void buy()
    {
        player.getBooster().addToChargeRate(5);
        setDisplay(player.getBooster().getChargeRate() + "% per second");
    }

    protected void sell()
    {
        player.getBooster().addToChargeRate(-5);
        setDisplay(player.getBooster().getChargeRate() + "% per second");
    }
}
