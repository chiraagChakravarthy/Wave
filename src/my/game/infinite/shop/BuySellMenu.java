package my.game.infinite.shop;

import jdk.nashorn.internal.runtime.options.Options;
import my.game.constants.Constants;
import my.game.game_state.GameState;
import my.game.game_state.InfiniteState;
import my.game.menu.Label;
import my.game.menu.Menu;
import my.game.menu.Option;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class BuySellMenu extends Menu
{
    protected int price;
    protected Label asset;
    protected Shop shop;
    public BuySellMenu(GameState state, String asset, int price, Shop shop)
    {
        super(state);
        this.shop = shop;
        options.add(new Option(10, 10, 30, "Buy: " + price, new Constants().nameColor, new Constants().boxColor));
        options.add(new Option(10, 10, 30, "Sell: " + price / 2, new Constants().nameColor, new Constants().boxColor));
        options.add(new Option(400, 50, "Back", new Constants().nameColor, new Constants().boxColor));
        options.get(1).setX(630 - options.get(1).getWidth());
        this.price = price;
        this.asset = new Label(10, 30, asset, new Constants().nameColor, new Constants().boxColor);
    }

    public void tick()
    {
        for(int i = 0; i < options.size(); i++)
        {
            ((Option)options.get(i)).setHighlighted(i == highlightedOption);
        }
        asset.tick();
    }

    public void render(Graphics g)
    {
        asset.render(g);
        super.render(g);
    }

    protected void select()
    {
        switch(highlightedOption)
        {
            case 0:
                ((InfiniteState)state).getGame().setCredits( ((InfiniteState)state).getGame().getCredits() - price);
                buy();
                break;
            case 1:
                ((InfiniteState)state).getGame().setCredits( ((InfiniteState)state).getGame().getCredits() + price / 2);
                sell();
                break;
            case 2:
                shop.setMenu(0);
        }
    }

    public void keyPressed(int k)
    {
        switch(k)
        {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                if(highlightedOption == 2)
                    highlightedOption = 0;
                else
                    highlightedOption = 2;
                break;

            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                if(highlightedOption == 0)
                    highlightedOption = 1;
                else if(highlightedOption == 1)
                    highlightedOption = 0;
                break;

            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                if(highlightedOption < 2)
                    highlightedOption = 2;
                else
                highlightedOption = 0;
                break;

            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                if(highlightedOption == 1)
                    highlightedOption = 0;
                else if(highlightedOption == 0)
                    highlightedOption = 1;
                break;

            case KeyEvent.VK_ENTER:
                select();
        }
    }

    public void keyReleased(int k)
    {
        super.keyReleased(k);
    }

    protected abstract void buy();
    protected abstract void sell();
}
