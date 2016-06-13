package my.game.infinite.shop;

import my.game.game_state.GameState;
import my.game.menu.Menu;
import my.game.menu.Option;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public abstract class Shop extends Menu
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
            for(int i = 0; i < options.size(); i++)
            {
                ((Option)options.get(i)).setHighlighted(i == highlightedOption);
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
            switch(k)
            {
                case KeyEvent.VK_D:
                case KeyEvent.VK_RIGHT:
                    highlightedOption++;
                    break;

                case KeyEvent.VK_A:
                case KeyEvent.VK_LEFT:
                    highlightedOption--;
                    break;

                default:
                    super.keyPressed(k);
                    break;
            }
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

    public void setMenu(int menu)
    {
        if(menu < options.size())
            this.menu = menu;

    }

    public void addShop(Menu shop, Option option)
    {
        options.add(option);
        menus.add(shop);
    }
}
