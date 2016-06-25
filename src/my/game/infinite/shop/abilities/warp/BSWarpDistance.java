package my.game.infinite.shop.abilities.warp;


import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.BuySellMenu;
import my.game.infinite.shop.Shop;

public class BSWarpDistance extends BuySellMenu
{

    public BSWarpDistance(GameState state, Shop shop, InfinitePlayer player)
    {
        super(state, "Distance", 15, shop, player);
        setDisplay(player.getWarper().getWarpMaxDistance() + " pixels");
    }

    public boolean canSell()
    {
        return player.getWarper().getWarpMaxDistance() > 0;
    }

    public boolean canBuy()
    {
        return player.getWarper().getWarpMaxDistance() < 400;
    }

    protected void buy()
    {
        player.getWarper().addToMaxDistance(20);
        setDisplay(player.getWarper().getWarpMaxDistance() + " pixels");
    }

    protected void sell()
    {
        player.getWarper().addToMaxDistance(-20);
        setDisplay(player.getWarper().getWarpMaxDistance() + " pixels");
    }
}