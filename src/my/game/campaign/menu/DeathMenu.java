package my.game.campaign.menu;

import java.awt.Graphics;

import my.game.constants.Constants;
import my.game.engine.Game;
import my.game.game_state.CampaignState;
import my.game.game_state.GameState;
import my.game.game_state.MenuState;
import my.game.menu.Label;
import my.game.menu.Menu;
import my.game.menu.Option;

public class DeathMenu extends Menu
{
    private Label label;

    public DeathMenu(GameState state)
    {
        super(state);
        Constants constants = new Constants();
        label = new Label(10, 50, "You Died", constants.nameColor, constants.boxColor);
        options.add(new Option(100, 50, "Retry", constants.nameColor, constants.boxColor));
        options.add(new Option(200, 50, "Level Select", constants.nameColor, constants.boxColor));
        options.add(new Option(300, 50, "Main Menu", constants.nameColor, constants.boxColor));
    }

    public void render(Graphics g)
    {
        label.render(g);
        super.render(g);
    }

    public void tick()
    {
        super.tick();
        for (int i = 0; i < options.size(); i++)
        {
            ((Option) options.get(i)).setHighlighted(i == highlightedOption);
        }
    }

    protected void select()
    {
        ((CampaignState) state).getLevel().reset();
        ((CampaignState) state).setDeathScreen(false);
        switch (highlightedOption)
        {
            case 1:
                ((MenuState) state.getGsm().getGameState(0)).setMenu(2);
                state.getGsm().setGameState(0);
                Game.window.setTitle("Level Select");
                break;

            case 2:
                state.getGsm().setGameState(0);
        }
    }
}
