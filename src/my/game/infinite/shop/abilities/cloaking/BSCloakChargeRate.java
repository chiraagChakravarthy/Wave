package my.game.infinite.shop.abilities.cloaking;

import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.BuySellMenu;
import my.game.infinite.shop.Shop;

public class BSCloakChargeRate extends BuySellMenu
{
    public BSCloakChargeRate(GameState state, Shop shop, InfinitePlayer player)
    {
        super(state, "Cloak Charge Rate", 12, shop, player);
        setDisplay(String.valueOf(player.getCloaker().getPercentChargeRate() + "% per second"));
    }

    public boolean canSell()
    {
        return player.getCloaker().getPercentChargeRate() >= 5;
    }

    public boolean canBuy()
    {
        return player.getCloaker().getPercentChargeRate() < 100;
    }

    protected void buy()
    {
        player.getCloaker().addToChargeRate(5);
        setDisplay(String.valueOf(player.getCloaker().getPercentChargeRate() + "% per second"));
    }

    protected void sell()
    {
        player.getCloaker().addToChargeRate(-5);
        setDisplay(String.valueOf(player.getCloaker().getPercentChargeRate()) + "% per second");
    }
}