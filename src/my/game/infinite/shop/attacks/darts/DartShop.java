package my.game.infinite.shop.attacks.darts;

import my.game.game_state.GameState;
import my.game.infinite.shop.Shop;

public class DartShop extends Shop
{
    private Shop shop;
    public DartShop(GameState state, Shop shop)
    {
        super(state);
        this.shop = shop;
    }

    protected void select()
    {

    }
}
