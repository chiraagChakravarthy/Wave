package my.game.engine;

import my.game.game_state.GameStateManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable, KeyListener
{
    private static final long serialVersionUID = 1L;
    private boolean running = false;
    private static Thread thread;
    private GameStateManager gsm;
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH * 9 / 12;
    public static Window window;
    public static final boolean debugMode = false;

    public Game()
    {
        window = new Window("Wave", WIDTH, HEIGHT + 22, this);
    }

    public void start()
    {
        thread = new Thread(this);
        gsm = new GameStateManager(0);
        addKeyListener(this);
        requestFocus();
        running = true;
        thread.start();
    }

    public static void main(String[] args)
    {
        new Game();
    }

    public void run()
    {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        int ticks = 60;
        double ns = 1000000000 / ticks;
        double delta = 0;
        int frames = 0;
        int updates = 0;
        while (running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta > 1)
            {
                tick(delta);
                updates++;
                delta--;
                render();
                frames++;
            }

            if (System.currentTimeMillis() - timer >= 1000)
            {
                System.out.println("FPS: " + frames + ", Ticks: " + updates);
                updates = 0;
                frames = 0;
                timer += 1000;
            }
        }
        stop();
    }

    public void stop()
    {
        running = false;
        try
        {
            thread.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void tick(double delta)
    {
        gsm.tick(delta);
    }

    public void render()
    {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null)
        {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //////////////////////////////////////////////////////////
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        gsm.render(g);
        //////////////////////////////////////////////////////////
        bs.show();
    }

    public void keyTyped(KeyEvent e)
    {

    }

    public void keyPressed(KeyEvent e)
    {
        int k = e.getKeyCode();
        gsm.keyPressed(k);

    }

    public void keyReleased(KeyEvent e)
    {
        int k = e.getKeyCode();
        gsm.keyReleased(k);
    }
}
