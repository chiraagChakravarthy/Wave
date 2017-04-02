package my.game.game_state;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class GameState
{
    protected GameStateManager gsm;

    public GameState(GameStateManager gsm)
    {
        this.gsm = gsm;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract void keyPressed(int k);

    public abstract void keyReleased(int k);

    public GameStateManager getGsm()
    {
        return gsm;
    }

    public abstract void mousePressed(MouseEvent e);

    public abstract void mouseReleased(MouseEvent e);
}
