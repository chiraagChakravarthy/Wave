package my.game.campaign.levels;

import my.game.campaign.GameLevel;
import my.game.game_state.GameState;
import my.game.object.Enemies;

public class Level12 extends GameLevel{

    public Level12(GameState state) {
        super(15, state);
    }

    @Override
    public void init() {
        Enemies enemies = new Enemies();

    }
}
