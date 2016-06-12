package my.game.game_state;

import my.game.infinite.InfiniteLevel;
import my.game.infinite.shop.Shop;

import java.awt.*;

public class InfiniteState extends GameState
{
    private InfiniteLevel level;
    private Shop shop;
    private boolean inShop;

    public InfiniteState(GameStateManager gsm)
    {
        super(gsm);
        level = new InfiniteLevel(this);
        shop = new Shop(this);
        setInShop(true);
    }

    public void tick(double delta)
    {
        if (!inShop)
            shop.tick();
        else
            level.tick(delta);
    }

    public void render(Graphics g)
    {
        if (!inShop)
            shop.render(g);
        else
            level.render(g);
    }

    public void keyPressed(int k)
    {
        if (!inShop)
            shop.keyPressed(k);
        else
            level.keyPressed(k);
    }

    public void keyReleased(int k)
    {
        if (!inShop)
            shop.keyReleased(k);
        else
            level.keyReleased(k);
    }

    public void setInShop(boolean inShop)
    {
        this.inShop = inShop;
    }
}
