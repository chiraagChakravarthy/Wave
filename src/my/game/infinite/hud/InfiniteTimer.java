package my.game.infinite.hud;

import my.game.menu.Label;
import my.game.menu.LabelColor;

import java.awt.*;

public class InfiniteTimer extends Label {
    private int lastTime;
    private int now;
    private double initialTime;

    public InfiniteTimer(int x, int y) {
        super(x, y, 30, "0", LabelColor.GREEN);
        initialTime = Integer.parseInt(name);
    }

    public void tick() {
        super.tick();
        now++;
        if (now - lastTime >= 6) {
            lastTime += 6;
            name = String.valueOf(Math.round((Double.parseDouble(name) + 0.1) * 10.0) / 10.0);
        }
        stringWidth = (int) new FontMetrics(new Font("Arial", Font.PLAIN, scale)) {
            private static final long serialVersionUID = 1L;
        }.getStringBounds(name, null).getWidth();
        width = (int) (new FontMetrics(new Font("Arial", Font.PLAIN, scale)) {
            private static final long serialVersionUID = 1L;
        }.getStringBounds(name, null).getWidth() + scale / 4);
    }

    public void setTime(double time) {
        this.name = String.valueOf(time);
        stringWidth = (int) new FontMetrics(new Font("Arial", Font.PLAIN, scale)) {
            private static final long serialVersionUID = 1L;
        }.getStringBounds(name, null).getWidth();
        width = (int) (new FontMetrics(new Font("Arial", Font.PLAIN, scale)) {
            private static final long serialVersionUID = 1L;
        }.getStringBounds(name, null).getWidth() + scale / 4);
    }

    public void render(Graphics g) {
        super.render(g);
    }

    public double getElapsedTime() {
        return initialTime - Double.parseDouble(name);
    }

    public double getInitialTime() {
        return initialTime;
    }

    public void reset() {
        name = String.valueOf(initialTime);
    }

    public double getTime() {
        return Double.parseDouble(name);
    }
}
