package my.game.infinite.shop.abilities.speedBoost;

import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.BuySellMenu;
import my.game.infinite.shop.Shop;

public class BSSpeedMultiplier extends BuySellMenu
{

    public BSSpeedMultiplier(GameState state, Shop shop, InfinitePlayer player)
    {
        super(state, "Boost Speed Multiplier", 7, shop, player);
        setDisplay(player.getBooster().getBoostSpeedMultiplier() + " x");
    }

    public boolean canSell()
    {
        return player.getBooster().getBoostSpeedMultiplier() >= 0.25;
    }

    public boolean canBuy()
    {
        return player.getBooster().getBoostSpeedMultiplier() < 10;
    }

    protected void buy()
    {
        player.getBooster().addToSpeedMultiplier(0.25);
        setDisplay(player.getBooster().getBoostSpeedMultiplier() + " x");
    }

    protected void sell()
    {
        player.getBooster().addToSpeedMultiplier(-0.25);
        setDisplay(player.getBooster().getBoostSpeedMultiplier() + " x");
    }
}
