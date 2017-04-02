package my.game.menu;

import my.game.engine.Game;

import java.awt.*;

public class Label {
    protected String name;
    protected double y;
    protected double x;
    protected int width;
    protected int height;
    protected int scale;
    protected int stringWidth;
    protected LabelColor color;
    protected boolean centered;

    public Label(int y, int scale, String name, LabelColor color) {
        this.color = color;
        this.y = y;
        this.scale = scale;
        this.name = name;
        FontMetrics metrics = new FontMetrics(new Font("Arial", 0, scale)) {
            private static final long serialVersionUID = -8572322988205722333L;
        };
        this.stringWidth = (int) metrics.getStringBounds(name, null).getWidth();
        this.width = this.stringWidth + scale / 4;
        this.height = (int) (metrics.getStringBounds(name, null).getHeight() + (double) (scale / 8));
        this.x = 320 - this.width / 2;
        centered = true;
    }

    public Label(int x, int y, int scale, String name, LabelColor color) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.name = name;
        FontMetrics metrics = new FontMetrics(new Font("Arial", 0, scale)) {
            private static final long serialVersionUID = -8572322988205722333L;
        };
        this.width = (int) (metrics.getStringBounds(name, null).getWidth() + (double) (scale / 4));
        this.height = (int) (metrics.getStringBounds(name, null).getHeight() + (double) (scale / 8));
        this.stringWidth = (int) metrics.getStringBounds(name, null).getWidth();
        centered = false;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setFont(new Font("Arial", 0, this.scale));
        g.setColor(color.getBoxColor());
        g.fillRect((int) x, (int) y, this.width, this.height);
        g.setColor(color.getNameColor());
        g.drawString(this.name, (int) x + width / 2 - stringWidth / 2, (int) y + height - height / 4);
    }

    public int getHeight() {
        return this.height;
    }

    public void setName(String name) {
        this.name = name;
        FontMetrics metrics = new FontMetrics(new Font("Arial", 0, scale)) {
            private static final long serialVersionUID = -8572322988205722333L;
        };
        this.width = (int) (metrics.getStringBounds(name, null).getWidth() + (double) (scale / 4));
        this.height = (int) (metrics.getStringBounds(name, null).getHeight() + (double) (scale / 8));
        this.stringWidth = (int) metrics.getStringBounds(name, null).getWidth();
        if (centered) x = Game.WIDTH / 2 - width / 2;
    }

    public String getName() {
        return this.name;
    }

    public double getX() {
        return this.x;
    }

    public int getWidth() {
        return this.width;
    }

    public double getY() {
        return y;
    }

    public void setColor(LabelColor color) {
        this.color = color;
    }

    public Rectangle getArea() {
        return new Rectangle((int) x, (int) y, width, height);
    }
}

