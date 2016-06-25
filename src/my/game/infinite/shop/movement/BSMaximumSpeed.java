package my.game.infinite.shop.movement;

import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.BuySellMenu;
import my.game.infinite.shop.Shop;

public class BSMaximumSpeed extends BuySellMenu
{

    public BSMaximumSpeed(GameState state, Shop shop, InfinitePlayer player)
    {
        super(state, "Maximum Speed", 20, shop, player);
    }

    public boolean canSell()
    {
        return false;
    }

    public boolean canBuy()
    {
        return false;
    }

    public void buy()
    {

    }

    public void sell()
    {

    }
}