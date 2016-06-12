package my.game.campaign.levels;

import my.game.campaign.GameLevel;
import my.game.game_state.GameState;
import my.game.object.Enemies;
import my.game.object.Enemy;

public class Level8 extends GameLevel
{
    public Level8(GameState state)
    {
        super(15, state);
    }


    public void init()
    {
        enemies.addEnemy(new Enemy(new Enemies().greenSpeeder), 0);
        enemies.addEnemy(new Enemy(new Enemies().blueSpeeder), 5);
        enemies.addEnemy(new Enemy(new Enemies().greenSpeeder), 10);
    }
}