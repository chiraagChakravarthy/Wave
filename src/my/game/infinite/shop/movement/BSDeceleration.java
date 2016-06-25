package my.game.infinite.shop.movement;

import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.BuySellMenu;
import my.game.infinite.shop.Shop;

public class BSDeceleration extends BuySellMenu
{

    public BSDeceleration(GameState state, Shop shop, InfinitePlayer player)
    {
        super(state, "Deceleration", 10, shop, player);
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
