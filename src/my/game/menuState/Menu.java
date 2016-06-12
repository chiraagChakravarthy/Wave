package my.game.menuState;

import my.game.game_state.GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public abstract class Menu
{
    protected ArrayList<Label> options = new ArrayList<Label>();
    protected int highlightedOption;
    protected GameState state;

    public Menu(GameState state)
    {
        this.state = state;
    }

    public void tick()
    {
        for (int i = 0; i < options.size(); i++)
        {
            options.get(i).tick();
        }
    }

    public void render(Graphics g)
    {
        if (highlightedOption >= options.size())
        {
            highlightedOption = 0;
        }
        if (highlightedOption < 0)
        {
            highlightedOption = options.size() - 1;
        }

        for (int i = 0; i < options.size(); i++)
        {
            options.get(i).render(g);
        }
    }

    protected abstract void select();

    public void keyPressed(int k)
    {
        switch (k)
        {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                highlightedOption--;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                highlightedOption++;
                break;

            case KeyEvent.VK_ENTER:
                select();
                break;
        }
    }

    public void keyReleased(int k)
    {

    }
}