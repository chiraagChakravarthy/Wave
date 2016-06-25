package my.game.infinite.shop;

import my.game.constants.Constants;
import my.game.game_state.GameState;
import my.game.game_state.InfiniteState;
import my.game.infinite.InfiniteGame;
import my.game.infinite.level.object.InfinitePlayer;
import my.game.menu.*;
import my.game.menu.Label;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class BuySellMenu extends SlideEnterMenu
{
    protected int price;
    protected Label asset;
    protected Label display;
    protected Shop shop;
    protected InfinitePlayer player;
    public BuySellMenu(GameState state, String asset, int price, Shop shop, InfinitePlayer player)
    {
        super(state);
        this.shop = shop;
        this.player = player;
        options.add(new SlidingOption(10, 10, 30, "Buy: " + price, new Constants().nameColor, new Constants().boxColor, 0));
        options.add(new SlidingOption(10, 10, 30, "Sell: " + price / 2, new Constants().nameColor, new Constants().boxColor, 1));
        options.add(new SlidingOption(400, 50, "Back", new Constants().nameColor, new Constants().boxColor, 2));
        options.get(1).setX(630 - options.get(1).getWidth());
        ((SlidingLabel)options.get(1)).setFinalX(630 - options.get(1).getWidth());
        this.price = price;
        this.asset = new Label(10, 30, asset, new Constants().nameColor, new Constants().boxColor);
        display = new Label(50, 30, "", new Constants().nameColor, new Constants().boxColor);
        setRelativeCoordinates(-1000, 0);
    }

    public void tick()
    {
        for(int i = 0; i < options.size(); i++)
        {
            ((SlidingOption)options.get(i)).setHighlighted(i == highlightedOption);
        }
        asset.tick();
        setLabelPositions();
        if(canBuy())
        {
            options.get(0).setName("Buy: " + price);
            if(price <= ((InfiniteState)state).getGame().getCredits())
            {
                options.get(0).setNameColor(new Color(0, 255, 0));
                options.get(0).setBoxColor(new Color(0, 128, 0));
            }
            else
            {
                options.get(0).setNameColor(new Color(255, 0, 0));
                options.get(0).setBoxColor(new Color(128, 0, 0));
            }
        }
        else
        {
            options.get(0).setNameColor(new Color(200, 200, 200));
            options.get(0).setBoxColor(new Color(128, 128, 128));
            options.get(0).setName("Maxed");
        }

        if(canSell())
        {
            options.get(1).setBoxColor(new Color(0, 128, 0));
            options.get(1).setNameColor(new Color(0, 255, 0));
        }
        else
        {
            options.get(1).setBoxColor(new Color(128, 0, 0));
            options.get(1).setNameColor(new Color(255, 0, 0));
        }
    }

    public void render(Graphics g)
    {
        asset.render(g);
        display.render(g);
        super.render(g);
    }

    protected void select()
    {
        if(!super.optionMoving())
        {
            switch (highlightedOption)
            {
                case 0:
                    if(canBuy() && price <= ((InfiniteState)state).getGame().getCredits())
                    {
                        ((InfiniteState) state).getGame().setCredits(((InfiniteState) state).getGame().getCredits() - price);
                        buy();
                    }
                    break;
                case 1:
                    if(canSell())
                    {
                        ((InfiniteState) state).getGame().setCredits(((InfiniteState) state).getGame().getCredits() + price / 2);
                        sell();
                    }
                    break;
                case 2:
                    shop.setMenu(0);
                    setRelativeCoordinates(-1000, 0);
            }
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

    public abstract boolean canSell();

    public abstract boolean canBuy();

    public void setDisplay(String displayName)
    {
        display.setName(displayName);
    }

    public void keyReleased(int k)
    {
        super.keyReleased(k);
    }

    protected abstract void buy();
    protected abstract void sell();
}
