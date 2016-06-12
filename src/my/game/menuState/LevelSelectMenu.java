package my.game.menuState;

import my.game.constants.Constants;
import my.game.engine.Game;
import my.game.game_state.CampaignState;
import my.game.game_state.GameState;
import my.game.game_state.MenuState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class LevelSelectMenu extends SlideEnterMenu
{
    private int optionX;
    private int optionY;
    private int highestLevel;

    public LevelSelectMenu(GameState state)
    {
        super(state);
        if (Game.debugMode)
            highestLevel = 99;
        updateOptions();
        setRelativeCoordinates(-1000, 0);
    }

    public void tick()
    {
        if (optionY > 5)
            optionY = 0;
        if (optionY < 0)
            optionY = 5;
        if (optionX < 0)
            optionX = 19;
        if (optionX > 19)
            optionX = 0;
        if (optionY == 5)
            highlightedOption = 100;
        else
            highlightedOption = optionY * 20 + optionX;
        for (int i = 0; i < options.size(); i++)
        {
            ((SlidingOption) options.get(i)).setHighlighted(i == highlightedOption);
        }
        super.tick();
        setLabelPositions();
    }

    public void keyPressed(int k)
    {
        switch (k)
        {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                optionY--;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                optionY++;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                optionX--;
                break;

            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                optionX++;
                break;

            case KeyEvent.VK_ENTER:
                select();
                break;
        }
    }

    public void keyReleased(int k)
    {

    }


    protected void select()
    {
        if (!optionMoving())
        {
            if (highlightedOption <= highestLevel && highlightedOption < 100)
            {
                ((CampaignState) state.getGsm().getGameState(1)).setLevel(highlightedOption);
                ((MenuState) state).setMenu(0);
                state.getGsm().setGameState(1);
                setRelativeCoordinates(-1000, 0);
                if (((CampaignState) state.getGsm().getGameState(1)).getHighestLevel() < highlightedOption)
                    Game.window.setTitle("Level " + (((CampaignState) state.getGsm().getGameState(1)).getLevelNumber() + 1));
            }
            else if (highlightedOption == 100)
            {
                Game.window.setTitle("GameMode");
                ((MenuState) state).setMenu(3);
                setRelativeCoordinates(-1000, 0);
            }
        }
    }

    public void setHighestLevel(int level)
    {
        if (highestLevel < level)
        {
            this.highestLevel = level;
            updateOptions();
        }
    }

    private void updateOptions()
    {
        options = new ArrayList<Label>();
        for (int i = 1; i < 21; i++)
        {
            SlidingOption option;
            if (i - 1 <= highestLevel)
                option = new SlidingOption(i * 29, 10, 20, String.valueOf(i), new Constants().nameColor, new Constants().boxColor, i);
            else
                option = new SlidingOption(i * 29, 10, 20, String.valueOf(i), new Color(200, 200, 200), new Color(128, 128, 128), i);
            if (i < 10)
                option.setWidth(option.getWidth() + 11);
            options.add(option);
        }

        for (int i = 1; i < 21; i++)
        {
            SlidingOption option;
            if (i - 1 + 20 <= highestLevel)
                option = new SlidingOption(i * 29, 36, 20, String.valueOf(i + 20), new Constants().nameColor, new Constants().boxColor, i + 20);
            else
                option = new SlidingOption(i * 29, 36, 20, String.valueOf(i + 20), new Color(200, 200, 200), new Color(128, 128, 128), i + 20);
            options.add(option);
        }

        for (int i = 1; i < 21; i++)
        {
            SlidingOption option;
            if (i - 1 + 40 <= highestLevel)
                option = new SlidingOption(i * 29, 62, 20, String.valueOf(i + 40), new Constants().nameColor, new Constants().boxColor, i + 40);
            else
                option = new SlidingOption(i * 29, 62, 20, String.valueOf(i + 40), new Color(200, 200, 200), new Color(128, 128, 128), i + 40);
            options.add(option);
        }

        for (int i = 1; i < 21; i++)
        {
            SlidingOption option;
            if (i - 1 + 60 <= highestLevel)
                option = new SlidingOption(i * 29, 88, 20, String.valueOf(i + 60), new Constants().nameColor, new Constants().boxColor, i + 60);
            else
                option = new SlidingOption(i * 29, 88, 20, String.valueOf(i + 60), new Color(200, 200, 200), new Color(128, 128, 128), i + 60);
            options.add(option);
        }

        for (int i = 1; i < 21; i++)
        {
            SlidingOption option;
            if (i - 1 + 80 <= highestLevel)
                option = new SlidingOption(i * 29 - 6, 114, 20, String.valueOf(i + 80), new Constants().nameColor, new Constants().boxColor, i + 80);
            else
                option = new SlidingOption(i * 29 - 6, 114, 20, String.valueOf(i + 80), new Color(200, 200, 200), new Color(128, 128, 128), i + 80);
            options.add(option);
        }
        options.add(new SlidingOption(160, 50, "Back", new Constants().nameColor, new Constants().boxColor, 100));
    }
}
