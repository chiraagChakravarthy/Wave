package my.game.infinite.shop.attacks.bullets;

import my.game.game_state.GameState;
import my.game.infinite.shop.BuySellMenu;
import my.game.infinite.shop.Shop;

public class BSAmmo extends BuySellMenu
{
    private int[] ammoValues;
    public BSAmmo(GameState state, int price, Shop shop)
    {
        super(state, "Ammo", price, shop);
    }

    protected void buy()
    {

    }

    protected void sell()
    {

    }
}
