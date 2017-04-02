package my.game.infinite.shop.health;

import my.game.game_state.GameState;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.infinite.shop.MainShop;
import my.game.infinite.shop.Shop;
import my.game.menu.LabelColor;
import my.game.menu.SlidingOption;

public class HealthShop extends Shop {
    private Shop shop;

    public HealthShop(MainShop shop, GameState state, InfinitePlayer player) {
        super(state);
        this.shop = shop;
        addShop(new BSMaxHealth(state, this, player), new SlidingOption(10, 20, "Max Health", LabelColor.GREEN, 0));
        addShop(new BSInvulnerability(state, this, player), new SlidingOption(40, 20, "Invulnerability", LabelColor.GREEN, 1));
        addShop(new BSRegeneration(state, this, player), new SlidingOption(70, 20, "Regeneration", LabelColor.GREEN, 2));
        options.add(new SlidingOption(200, 50, "Back", LabelColor.GREEN, 3));
        setRelativeCoordinates(-1000, 0);
    }

    protected void select() {
        if (!super.optionMoving()) {
            setRelativeCoordinates(-1000, 0);
            if (highlightedOption == 3)
                shop.setMenu(0);
            else
                setMenu(highlightedOption + 1);
        }
    }
}
