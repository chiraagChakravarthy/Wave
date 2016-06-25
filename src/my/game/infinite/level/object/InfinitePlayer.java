package my.game.infinite.level.object;

import my.game.object.Position;
import my.game.object.tail.Tail;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class InfinitePlayer extends InfiniteEntity
{
    public InfinitePlayer(double x, double y)
    {
        super(x, y, 0.2, 0.1, 2, new Tail(5, Color.white));
    }

    public void keyPressed(int k)
    {
        switch (k)
        {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                right = true;
                break;

            case KeyEvent.VK_SPACE:
                booster.boost();
                break;

            case KeyEvent.VK_F:
                cloaker.cloak();
        }
    }

    public void keyReleased(int k)
    {
        switch (k)
        {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                right = false;
                break;

            case KeyEvent.VK_SPACE:
                booster.stop();
                break;

            case KeyEvent.VK_F:
                cloaker.deCloak();
        }
    }

    public void mousePressed(MouseEvent e)
    {
        switch(e.getButton())
        {
            case MouseEvent.BUTTON1:
                warper.warp(new Position(e.getPoint()));
                break;
        }
    }

    public void mouseReleased(MouseEvent e)
    {

    }
}