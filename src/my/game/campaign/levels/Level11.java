package my.game.campaign.levels;

import my.game.campaign.GameLevel;
import my.game.game_state.GameState;
import my.game.object.Enemies;

public class Level11 extends GameLevel{

    public Level11(GameState state) {
        super(15, state);
    }

    @Override
    public void init() {
        Enemies enemies = new Enemies();
        super.enemies.addEnemy(enemies.redOrbiter, 0);
        super.enemies.addEnemy(enemies.blueSpeeder, 10);
    }
}