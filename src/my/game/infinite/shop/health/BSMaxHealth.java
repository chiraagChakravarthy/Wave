package my.game.infinite.shop.health;

import my.game.game_state.GameState;
import my.game.game_state.InfiniteState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.BuySellMenu;
import my.game.infinite.shop.Shop;

public class BSMaxHealth extends BuySellMenu {
    public BSMaxHealth(GameState state, Shop shop, InfinitePlayer player) {
        super(state, "Maximum Health", 5, shop, player);
    }

    public boolean canSell() {
        return false;
    }

    public boolean canBuy() {
        return true;
    }

    public void buy() {
        player.set
    }

    public void sell() {

    }
}
