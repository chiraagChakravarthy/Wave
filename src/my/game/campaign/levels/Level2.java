package my.game.campaign.levels;

import my.game.campaign.GameLevel;
import my.game.game_state.GameState;
import my.game.object.Enemies;
import my.game.object.Enemy;

public class Level2 extends GameLevel
{

    public Level2(GameState state)
    {
        super(20, state);
    }

    public void init()
    {
        Enemies enemies = new Enemies();
        this.enemies.addEnemy(new Enemy(enemies.goon2), 0);
    }
}
