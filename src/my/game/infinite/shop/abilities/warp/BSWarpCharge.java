package my.game.infinite.shop.abilities.warp;


import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.BuySellMenu;
import my.game.infinite.shop.Shop;

public class BSWarpCharge extends BuySellMenu
{

    public BSWarpCharge(GameState state, Shop shop, InfinitePlayer player)
    {
        super(state, "Charge Rate", 15, shop, player);
        setDisplay(player.getWarper().getChargePercentRate() + "% per second");
    }

    public boolean canSell()
    {
        return player.getWarper().getChargePercentRate() > 0;
    }

    public boolean canBuy()
    {
        return player.getWarper().getChargePercentRate() < 100;
    }

    protected void buy()
    {
        player.getWarper().addToChargeRate(5);
        setDisplay(player.getWarper().getChargePercentRate() + "% per second");
    }

    protected void sell()
    {
        player.getWarper().addToChargeRate(-5);
        setDisplay(player.getWarper().getChargePercentRate() + "% per second");
    }
}
