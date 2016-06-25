package my.game.infinite.shop.attacks.bullets.explosive;


import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.BuySellMenu;
import my.game.infinite.shop.Shop;

public class BSRange extends BuySellMenu
{
    public BSRange(GameState state, Shop shop, InfinitePlayer player)
    {
        super(state, "Bullet Range", 10, shop, player);
    }

    public boolean canSell()
    {
        return false;
    }

    public boolean canBuy()
    {
        return false;
    }

    protected void buy()
    {

    }

    protected void sell()
    {

    }
}
