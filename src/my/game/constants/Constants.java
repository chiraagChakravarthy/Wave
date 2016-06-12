package my.game.constants;

import my.game.engine.Game;
import my.game.object.Player;

import java.awt.*;

public class Constants
{
    public final Color boxColor = new Color(0, 128, 0);
    public final Color nameColor = new Color(0, 255, 0);

    public Player player = new Player(Game.WIDTH / 2 - 16, Game.HEIGHT / 2 - 16, 2);
}