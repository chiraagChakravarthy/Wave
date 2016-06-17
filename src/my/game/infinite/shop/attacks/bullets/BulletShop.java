package my.game.infinite.shop.attacks.bullets;

import my.game.game_state.GameState;
import my.game.infinite.shop.Shop;

public class BulletShop extends Shop
{
    private Shop shop;
    public BulletShop(GameState state, Shop shop)
    {
        super(state);
        this.shop = shop;
        //regular bullet
        //high speed bullet
        //homing bullet
        //explosive
    }

    protected void select()
    {

    }
}
