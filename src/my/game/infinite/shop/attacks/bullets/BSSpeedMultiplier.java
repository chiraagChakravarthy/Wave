package my.game.infinite.shop.attacks.bullets;

import my.game.game_state.GameState;
import my.game.infinite.shop.BuySellMenu;
import my.game.infinite.shop.Shop;

public class BSSpeedMultiplier extends BuySellMenu
{
    private int[] speedMultipliers;
    public BSSpeedMultiplier(GameState state, int price, Shop shop)
    {
        super(state, "Speed Multiplier", price, shop);
        speedMultipliers = new int[4];
    }

    protected void buy()
    {

    }

    protected void sell()
    {

    }

    public void setBullet(int bullet)
    {

    }

}
