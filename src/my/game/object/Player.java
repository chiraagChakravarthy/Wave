package my.game.object;

import my.game.engine.Game;
import my.game.object.tail.Tail;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity {
    private int health;
    private int invulnerabilityTimer;

    public Player() {
        super(Game.WIDTH/2, Game.HEIGHT/2, 0.1F, 0.05F, 2, new Tail(10, Color.white));
        this.health = 2;
        invulnerabilityTimer = 60;
    }

    public void tick() {
        super.tick();
        if (invulnerabilityTimer > 0) {
            invulnerabilityTimer--;
            invisible = !invisible;
        } else
            invisible = false;
    }

    public boolean isInvulnerable() {
        return invulnerabilityTimer > 0;
    }

    public void damage(int damage) {
        if (!(invulnerabilityTimer > 0)) {
            health -= damage;
            invulnerabilityTimer = 60;
        }
    }

    public int getHealth() {
        return health;
    }


    public void keyPressed(int k) {
        switch (k) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
        }
    }

    public void keyReleased(int k) {
        switch (k) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                right = false;
        }
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setInvulnerabilityTime(int invulnerability) {
        this.invulnerabilityTimer = invulnerability;
    }
}
