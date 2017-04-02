package my.game.object;

import my.game.object.tail.Tail;

import java.awt.*;

public class Enemies {
    public final Enemy goon = new Enemy(100, 100, 0.1F, 0.05F, 2F, new Tail(25, new Color(128, 0, 0)), 10);
    public final Enemy goon2 = new Enemy(100, 100, 0.1F, 0.05F, 2F, new Tail(25, new Color(255, 0, 0)), 30);
    public final Enemy blueSpeeder = new Enemy(100, 100, 0.2F, 0.1F, 2F, new Tail(25, Color.blue), 20);
    public final Enemy purpleOrbiter = new Enemy(100, 100, 0.35F, 0.35F, 10000000F, new Tail(25, Color.magenta), 100);
    public final Enemy darkPurpleOrbiter = new Enemy(100, 100, 0.25F, 0.25F, 10000000F, new Tail(50, new Color(128, 0, 128)), 100);
    public final Enemy redOrbiter = new Enemy(100, 100, 0.2F, 0.1F, 10000000F, new Tail(25, new Color(100, 0, 100)), 100);
    public final Enemy greenSpeeder = new Enemy(100, 100, 0.15F, 0.74F, 2.5F, new Tail(25, Color.green), 100);
    public final Enemy snake = new Enemy(100, 100, .35f, 0.2f, 3, new Tail(75, new Color(0, 255, 0)), 35);
}