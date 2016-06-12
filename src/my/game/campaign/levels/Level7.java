package my.game.campaign.levels;

import my.game.campaign.GameLevel;
import my.game.game_state.GameState;
import my.game.object.Enemies;
import my.game.object.Enemy;

public class Level7 extends GameLevel
{
    public Level7(GameState state)
    {
        super(40, state);
    }

    public void init()
    {
        enemies.addEnemy(new Enemy(new Enemies().goon2), 0);
        enemies.addEnemy(new Enemy(new Enemies().goon), 10);
        enemies.addEnemy(new Enemy(new Enemies().goon), 20);
        enemies.addEnemy(new Enemy(new Enemies().goon2), 30);
    }
}