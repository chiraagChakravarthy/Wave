package my.game.menu;

import my.game.engine.Game;
import my.game.game_state.GameState;
import my.game.object.Position;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
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

    public void slide(int relativeX, int relativeY)
    {
        for(Label label: options)
        {
            label.setX(label.getX() + relativeX);
            label.setY(label.getY() + relativeY);
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

    public void mousePressed(MouseEvent e)
    {
        Point location = e.getPoint();
        for(int i = 0; i < options.size(); i++)
        {
            if (options.get(i).getArea().contains(location))
            {
                highlightedOption = i;
            }
        }
    }

    public void mouseReleased(MouseEvent e)
    {
        if(options.get(highlightedOption).getArea().contains(e.getPoint()))
            select();
    }

    public void keyReleased(int k)
    {

    }
}