package my.game.campaign.levels;

import my.game.campaign.GameLevel;
import my.game.game_state.GameState;
import my.game.object.Enemies;
import my.game.object.Enemy;

public class Level14 extends GameLevel
{

    public Level14(GameState state)
    {
        super(20, state);
    }

    public void init()
    {
        this.enemies.addEnemy(new Enemy(new Enemies().goon), 0);
        this.enemies.addEnemy(new Enemy(new Enemies().goon), 10);
    }
}