package my.game.campaign;

import my.game.constants.Constants;
import my.game.engine.Game;
import my.game.game_state.CampaignState;
import my.game.game_state.GameState;
import my.game.game_state.MenuState;
import my.game.menuState.Label;
import my.game.menuState.Menu;
import my.game.menuState.Option;

import java.awt.*;

public class LevelEndMenu extends Menu
{
    private Label label;

    public LevelEndMenu(GameState state)
    {
        super(state);
        label = new Label(10, 50, "You Beat The Level", new Constants().nameColor, new Constants().boxColor);
        options.add(new Option(100, 50, "Main Menu", new Constants().nameColor, new Constants().boxColor));
        options.add(new Option(200, 50, "Level Select", new Constants().nameColor, new Constants().boxColor));
        options.add(new Option(300, 50, "Reset", new Constants().nameColor, new Constants().boxColor));
        options.add(new Option(400, 50, "Next Level", new Constants().nameColor, new Constants().boxColor));
    }

    public void tick()
    {
        super.tick();
        for (int i = 0; i < options.size(); i++)
        {
            ((Option) options.get(i)).setHighlighted(i == highlightedOption);
        }
    }

    public void render(Graphics g)
    {
        label.render(g);
        super.render(g);
    }

    protected void select()
    {
        ((CampaignState) state).getLevel().reset();
        switch (highlightedOption)
        {
            case 0:
                ((MenuState) state.getGsm().getGameState(0)).setMenu(0);
                state.getGsm().setGameState(0);
                Game.window.setTitle("Wave");
                break;

            case 1:
                ((MenuState) state.getGsm().getGameState(0)).setMenu(2);
                state.getGsm().setGameState(0);
                Game.window.setTitle("Level Select");
                break;

            case 2:
                break;

            case 3:
                ((CampaignState) state).setLevel(((CampaignState) state).getLevelNumber() + 1);
        }
        ((CampaignState) state).setLevelEndScreen(false);
    }
}
