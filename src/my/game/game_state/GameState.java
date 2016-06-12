package my.game.game_state;

import java.awt.*;

public abstract class GameState
{
    protected GameStateManager gsm;

    public GameState(GameStateManager gsm)
    {
        this.gsm = gsm;
    }

    public abstract void tick(double delta);

    public abstract void render(Graphics g);

    public abstract void keyPressed(int k);

    public abstract void keyReleased(int k);

    public GameStateManager getGsm()
    {
        return gsm;
    }
}
