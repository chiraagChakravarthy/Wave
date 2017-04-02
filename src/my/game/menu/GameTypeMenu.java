package my.game.menu;

import my.game.engine.Game;
import my.game.game_state.GameState;
import my.game.game_state.MenuState;

public class GameTypeMenu extends SlideEnterMenu {

    public GameTypeMenu(GameState state) {
        super(state);
        options.add(new SlidingOption(10, 50, "Campaign", LabelColor.GREEN, 0));
        options.add(new SlidingOption(100, 50, "Infinite", LabelColor.GREEN, 1));
        options.add(new SlidingOption(200, 50, "Back", LabelColor.GREEN, 2));
        super.setRelativeCoordinates(-1000, 0);
    }

    public void tick() {
        super.setLabelPositions();
        super.tick();
        if (highlightedOption > options.size() - 1)
            highlightedOption = 0;
        if (highlightedOption < 0)
            highlightedOption = options.size() - 1;
        for (int i = 0; i < options.size(); i++) {
            ((SlidingOption) options.get(i)).setHighlighted(highlightedOption == i);
        }
    }

    protected void select() {
        if (!super.optionMoving()) {
            super.setRelativeCoordinates(-1000, 0);
            switch (highlightedOption) {
                case 0:
                    ((MenuState) state).setMenu(2);
                    Game.window.setTitle("Level Select");
                    break;

                case 1:
                    state.getGsm().setGameState(2);
                    Game.window.setTitle("Game Selection");
                    break;

                case 2:
                    ((MenuState) state).setMenu(0);
                    Game.window.setTitle("Wave");
                    break;
            }
        }
    }
}
