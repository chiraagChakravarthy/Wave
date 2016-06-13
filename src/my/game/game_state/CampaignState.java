package my.game.game_state;

import my.game.campaign.menu.DeathMenu;
import my.game.campaign.GameLevel;
import my.game.campaign.menu.LevelEndMenu;
import my.game.campaign.menu.PauseMenu;
import my.game.campaign.levels.*;
import my.game.engine.Game;
import my.game.menu.LevelSelectMenu;

import java.awt.*;
import java.util.ArrayList;

public class CampaignState extends GameState
{
    private ArrayList<GameLevel> levels = new ArrayList<GameLevel>();
    private int level;
    private boolean pauseScreen, lvEndScreen, deathScreen;
    private PauseMenu pauseMenu;
    private LevelEndMenu levelEndMenu;
    private DeathMenu deathMenu;

    public CampaignState(GameStateManager gsm)
    {
        super(gsm);
        addLevels();
        levelEndMenu = new LevelEndMenu(this);
        pauseMenu = new PauseMenu(this);
        deathMenu = new DeathMenu(this);
    }

    public void tick(double delta)
    {
        if (pauseScreen)
            pauseMenu.tick();
        else if (lvEndScreen)
            levelEndMenu.tick();
        else if (deathScreen)
            deathMenu.tick();
        else
            levels.get(level).tick(delta);
    }

    public void render(Graphics g)
    {
        if (pauseScreen)
            pauseMenu.render(g);
        else if (lvEndScreen)
            levelEndMenu.render(g);
        else if (deathScreen)
            deathMenu.render(g);
        else
            levels.get(level).render(g);
    }

    public void keyPressed(int k)
    {
        if (pauseScreen)
        {
            pauseMenu.keyPressed(k);
        }
        else if (lvEndScreen)
        {
            levelEndMenu.keyPressed(k);
        }
        else if (deathScreen)
        {
            deathMenu.keyPressed(k);
        }
        else
        {
            levels.get(level).keyPressed(k);
        }
    }

    public void keyReleased(int k)
    {
        if (pauseScreen)
            pauseMenu.keyReleased(k);
        else if (lvEndScreen)
        {
            levelEndMenu.keyReleased(k);
        }
        else if (deathScreen)
        {
            deathMenu.keyReleased(k);
        }
        else
            levels.get(level).keyReleased(k);
    }

    public void setPauseScreen(boolean pauseScreen)
    {
        this.pauseScreen = pauseScreen;
        if (pauseScreen)
            Game.window.setTitle(Game.window.getTitle() + " (paused)");
        else
            Game.window.setTitle("Level " + (level + 1));
    }

    public void setDeathScreen(boolean deathScreen)
    {
        this.deathScreen = deathScreen;
        if (deathScreen)
            Game.window.setTitle("You Died!");
        else
            Game.window.setTitle("Level " + (level + 1));
    }

    public void setLevelEndScreen(boolean lvEndScreen)
    {
        this.lvEndScreen = lvEndScreen;
        if (lvEndScreen && level <= levels.size())
        {
            ((LevelSelectMenu) ((MenuState) gsm.getGameState(0)).getMenu(2)).setHighestLevel(level + 1);
        }
    }

    public int getHighestLevel()
    {
        return levels.size() + 1;
    }

    public GameLevel getLevel()
    {
        return levels.get(level);
    }

    public int getLevelNumber()
    {
        return level;
    }

    public void setLevel(int level)
    {
        if (level < levels.size())
        {
            this.level = level;
            Game.window.setTitle("Level " + (level + 1));
        }
        else
        {
            gsm.setGameState(0);
            ((MenuState) gsm.getGameState(0)).setMenu(2);
        }
    }

    private void addLevels()
    {
        levels.add(new Level1(this));
        levels.add(new Level2(this));
        levels.add(new Level3(this));
        levels.add(new Level4(this));
        levels.add(new Level5(this));
        levels.add(new Level6(this));
        levels.add(new Level7(this));
        levels.add(new Level8(this));
        levels.add(new Level9(this));
        levels.add(new Level10(this));
        levels.add(new Level11(this));
    }
}
