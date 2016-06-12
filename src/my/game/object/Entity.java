package my.game.object;

import my.game.object.tail.Tail;

import java.awt.*;
import java.util.ArrayList;

public abstract class Entity
{
    protected Position position;
    protected float velX;
    protected float velY;
    protected Tail tail;
    protected boolean up, down, left, right;
    protected static Rectangle levelBounds;
    protected Rectangle hitBox;
    protected float speedUp;
    protected float speedDown;
    protected float speedLeft;
    protected float speedRight;
    protected float maxSpeed;
    protected float acc;
    protected float dcc;
    protected boolean invisible;
    protected boolean infinite;

    public Entity(float x, float y, float acc, float dcc, float maxSpeed, Tail tail)
    {
        position = new Position(x, y);
        invisible = false;
        this.acc = acc;
        this.dcc = dcc;
        this.maxSpeed = maxSpeed;
        this.tail = tail;
    }

    public Entity(Entity entity)
    {
        position = new Position(entity.getX(), entity.getY());
        this.acc = entity.getAcc();
        this.dcc = entity.getDcc();
        this.tail = entity.getTail();
        this.maxSpeed = entity.getMaxSpeed();
        invisible = false;
        hitBox = new Rectangle((int) position.getX(), (int) position.getY(), 32, 32);
    }

    public void tick()
    {
        if (up)
        {
            if (speedUp < maxSpeed)
                speedUp += acc;
            else
                speedUp = maxSpeed;
        }
        else
        {
            if (speedUp > 0)
                speedUp -= dcc;
            else
                speedUp = 0;
        }

        if (left)
        {
            if (speedLeft < maxSpeed)
                speedLeft += acc;
            else
                speedLeft = maxSpeed;
        }
        else
        {
            if (speedLeft > 0)
                speedLeft -= dcc;
            else
                speedLeft = 0;
        }

        if (down) 
        {
            if (speedDown < maxSpeed)
                speedDown += acc;
            else
                speedDown = maxSpeed;
        }
        else
        {
            if (speedDown > 0)
                speedDown -= dcc;
            else
                speedDown = 0;
        }

        if (right)
        {
            if (speedRight < maxSpeed)
                speedRight += acc;
            else
                speedRight = maxSpeed;
        }
        else
        {
            if (speedRight > 0)
                speedRight -= dcc;
            else
                speedRight = 0;
        }

        velX = speedRight - speedLeft;
        velY = speedDown - speedUp;
        position.setPosition(position.getX() + velX, position.getY() + velY);
        tail.setLocation(position);
        if (position.getX() < 0)
        {
            position.setPosition(0, position.getY());
            velX = 0;
        }
        if (position.getY() < 0)
        {
            position.setPosition(position.getX(), 0);
            velY = 0;
        }
        if (position.getX() > levelBounds.getWidth() - 32)
        {
            position.setPosition((float) levelBounds.getWidth() - 32, position.getY());
            velX = 0;
        }
        if (position.getY() > levelBounds.getHeight() - 32)
        {
            position.setPosition(position.getX(), (float) levelBounds.getHeight() - 32);
            velY = 0;
        }

        hitBox.setLocation((int) position.getX(), (int) position.getY());
    }

    public Rectangle getHitBox()
    {
        return hitBox;
    }

    public void render(Graphics g)
    {
        if (!invisible)
        {
            tail.render(g);
            g.setColor(tail.getBaseColor());
            g.fillRect((int) position.getScrX(), (int) position.getScrY(), 32, 32);
        }

    }

    public float getX()
    {
        return position.getX();
    }

    public float getY()
    {
        return position.getY();
    }

    public void setUp(boolean up)
    {
        this.up = up;
    }

    public void setDown(boolean down)
    {
        this.down = down;
    }

    public void setLeft(boolean left)
    {
        this.left = left;
    }

    public void setRight(boolean right)
    {
        this.right = right;
    }

    public float getAcc()
    {
        return acc;
    }

    public float getDcc()
    {
        return dcc;
    }

    public float getMaxSpeed()
    {
        return maxSpeed;
    }

    public ArrayList<Color> getColors()
    {
        return tail.getColors();
    }

    public void setLocation(float x, float y)
    {
        position.setPosition(x, y);
    }

    public static void setLevelBounds(Rectangle levelBounds)
    {
        Entity.levelBounds = levelBounds;
    }

    public Tail getTail()
    {
        return tail;
    }
}
