package my.game.campaign.levels;

import my.game.campaign.GameLevel;
import my.game.game_state.GameState;
import my.game.object.Enemies;
import my.game.object.Enemy;

public class Level15 extends GameLevel
{
    public Level15(GameState state)
    {
        super(15, state);
    }


    public void init()
    {
        enemies.addEnemy(new Enemy(new Enemies().redOrbiter), 0);
        enemies.addEnemy(new Enemy(new Enemies().redOrbiter), 5);
        enemies.addEnemy(new Enemy(new Enemies().redOrbiter), 10);
    }
}