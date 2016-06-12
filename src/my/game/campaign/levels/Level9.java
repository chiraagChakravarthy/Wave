package my.game.campaign.levels;

import my.game.campaign.GameLevel;
import my.game.game_state.GameState;
import my.game.object.Enemies;
import my.game.object.Enemy;

public class Level9 extends GameLevel
{
    public Level9(GameState state)
    {
        super(10, state);
    }

    public void init()
    {
        for (int i = 0; i < 20; i++)
        {
            enemies.addEnemy(new Enemy(new Enemies().goon), (i / 2));
        }
    }
}