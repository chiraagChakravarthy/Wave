package my.game.infinite.shop;

import my.game.game_state.GameState;
import my.game.menu.Menu;
import my.game.menu.Option;
import my.game.menu.SlideEnterMenu;
import my.game.menu.SlidingOption;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class Shop extends SlideEnterMenu
{
    protected ArrayList<Menu> menus;
    protected int menu;
    public Shop(GameState state)
    {
        super(state);
        menus = new ArrayList<Menu>();
    }

    public void tick()
    {
        if(menu == 0)
        {
            setLabelPositions();
            for(int i = 0; i < options.size(); i++)
            {
                ((SlidingOption)options.get(i)).setHighlighted(i == highlightedOption);
            }
        }
        else
            menus.get(menu - 1).tick();
    }

    public void render(Graphics g)
    {
        if(menu == 0)
            super.render(g);
        else
            menus.get(menu - 1).render(g);
    }

    public void keyPressed(int k)
    {
        if(menu == 0)
        {
            super.keyPressed(k);
        }
        else
            menus.get(menu - 1).keyPressed(k);
    }

    public void keyReleased(int k)
    {
        if(menu == 0)
            super.keyReleased(k);
        else
            menus.get(menu - 1).keyReleased(k);
    }

    public void mousePressed(MouseEvent e)
    {
        if(menu == 0)
            super.mousePressed(e);
        else
            menus.get(menu - 1).mousePressed(e);
    }

    public void mouseReleased(MouseEvent e)
    {
        if(menu == 0)
            super.mouseReleased(e);
        else
            menus.get(menu - 1).mouseReleased(e);
    }

    public void setMenu(int menu)
    {
        if(menu < options.size())
            this.menu = menu;

    }

    public void addShop(Menu shop, SlidingOption option)
    {
        options.add(option);
        menus.add(shop);
    }
}
