package my.game.engine;

import javax.swing.*;
import java.awt.*;

public class Window
{
    private int fsm = 0;
    private JFrame frame;
    private GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    public Window(String title, int fsm, Game game)
    {
        this.fsm = fsm;
        frame = new JFrame(title);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        setFullScreen();
        game.start();
    }

    public Window(String title, int width, int height, Game game)
    {
        frame = new JFrame(title);
        frame.setMinimumSize(new Dimension(width, height));
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }

    private void setFullScreen()
    {
        switch (fsm)
        {
            case 1:
                frame.dispose();
                frame.setSize(new Dimension(device.getDisplayMode().getWidth(), device.getDisplayMode().getHeight()));
                frame.setResizable(true);
                frame.setUndecorated(false);
                frame.setVisible(true);
                break;
            case 2:
                frame.dispose();
                frame.setMinimumSize(new Dimension(device.getDisplayMode().getWidth(), device.getDisplayMode().getHeight()));
                frame.setPreferredSize(new Dimension(device.getDisplayMode().getWidth(), device.getDisplayMode().getHeight()));
                frame.setMaximumSize(new Dimension(device.getDisplayMode().getWidth(), device.getDisplayMode().getHeight()));
                frame.setUndecorated(true);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                break;
            case 3:
                frame.dispose();
                if (device.isFullScreenSupported())
                    device.setFullScreenWindow(frame);
                else
                    System.out.println("FullScreen mode is not supported.");
                break;

            default:
                System.out.println("FullScreen mode not supported.");
                setFullScreen(1);
        }
    }

    public void setFullScreen(int fsm)
    {
        this.fsm = fsm;
        setFullScreen();
    }

    public void setTitle(String title)
    {
        frame.setTitle(title);
    }

    public String getTitle()
    {
        return frame.getTitle();
    }
}
