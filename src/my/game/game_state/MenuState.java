package my.game.game_state;

import my.game.menu.*;
import my.game.menu.Menu;

import java.awt.*;
import java.util.ArrayList;

public class MenuState extends GameState
{
    private ArrayList<Menu> menus = new ArrayList<Menu>();
    private int menu = 0;

    public MenuState(GameStateManager gsm)
    {
        super(gsm);
        menus.add(new MainMenu(this));
        menus.add(new HelpMenu(this));
        menus.add(new LevelSelectMenu(this));
        menus.add(new GameTypeMenu(this));
    }

    public void setMenu(int menu)
    {
        this.menu = menu;
    }

    public void tick(double delta)
    {
        menus.get(menu).tick();
    }

    public void render(Graphics g)
    {
        menus.get(menu).render(g);
    }

    public void keyPressed(int k)
    {
        menus.get(menu).keyPressed(k);
    }

    public void keyReleased(int k)
    {
        menus.get(menu).keyReleased(k);
    }

    public Menu getMenu(int menu)
    {
        return menus.get(menu);
    }
}
