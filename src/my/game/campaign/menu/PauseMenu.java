package my.game.campaign.menu;

import my.game.constants.Constants;
import my.game.engine.Game;
import my.game.game_state.CampaignState;
import my.game.game_state.GameState;
import my.game.game_state.MenuState;
import my.game.menu.SlideEnterMenu;
import my.game.menu.SlidingOption;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PauseMenu extends SlideEnterMenu
{

    public PauseMenu(GameState state)
    {
        super(state);
        options.add(new SlidingOption(10, 50, "Back to Game", new Constants().nameColor, new Constants().boxColor, 0));
        options.add(new SlidingOption(100, 50, "Reset", new Constants().nameColor, new Constants().boxColor, 1));
        options.add(new SlidingOption(200, 50, "Main Menu", new Constants().nameColor, new Constants().boxColor, 2));
        options.add(new SlidingOption(300, 50, "Level Select", new Constants().nameColor, new Constants().boxColor, 3));
        setRelativeCoordinates(-1000, 0);
    }

    public void tick()
    {
        super.tick();
        setLabelPositions();
        if (highlightedOption > options.size() - 1)
            highlightedOption = 0;
        if (highlightedOption < 0)
            highlightedOption = options.size() - 1;
        for (int i = 0; i < options.size(); i++)
        {
            ((SlidingOption) options.get(i)).setHighlighted(i == highlightedOption);
        }
    }

    public void render(Graphics g)
    {
        super.render(g);
    }

    protected void select()
    {
        if (!optionMoving())
        {
            ((CampaignState) state).setPauseScreen(false);
            switch (highlightedOption)
            {
                case 0:
                    Game.window.setTitle("Level " + (((CampaignState) state).getLevelNumber() + 1));
                    break;

                case 1:
                    ((CampaignState) state).getLevel().reset();
                    break;
                case 2:
                    ((CampaignState) state).getLevel().reset();
                    state.getGsm().setGameState(0);
                    Game.window.setTitle("Wave");
                    break;

                case 3:
                    ((CampaignState) state).getLevel().reset();
                    state.getGsm().setGameState(0);
                    ((MenuState) state.getGsm().getGameState(0)).setMenu(2);
                    Game.window.setTitle("Level Select");
            }

            setRelativeCoordinates(-1000, 0);
        }
    }

    public void keyPressed(int k)
    {
        switch (k)
        {
            case KeyEvent.VK_ESCAPE:
                if (!optionMoving())
                {
                    ((CampaignState) state).setPauseScreen(false);
                    setRelativeCoordinates(-1000, 0);
                }
                break;

            default:
                super.keyPressed(k);
        }
    }
}
