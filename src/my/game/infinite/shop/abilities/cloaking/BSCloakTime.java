package my.game.infinite.shop.abilities.cloaking;

import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.BuySellMenu;
import my.game.infinite.shop.Shop;

public class BSCloakTime extends BuySellMenu
{

    public BSCloakTime(GameState state, Shop shop, InfinitePlayer player)
    {
        super(state, "Cloak Time", 17, shop, player);
    }

    public boolean canSell()
    {
        return player.getCloaker().getMaxCloakTime() >= 0.5;
    }

    public boolean canBuy()
    {
        return player.getCloaker().getMaxCloakTime() < 5;
    }

    protected void buy()
    {
        player.getCloaker().addToMaximumTime(0.5);
        setDisplay(String.valueOf(player.getCloaker().getMaxCloakTime()) + " seconds");
    }

    protected void sell()
    {
        player.getCloaker().addToMaximumTime(-0.5);
        setDisplay(String.valueOf(player.getCloaker().getMaxCloakTime()) + " seconds");
    }
}
