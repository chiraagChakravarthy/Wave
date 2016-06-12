package my.game.object;

public class Position
{
    private float x;
    private float y;
    private static float xOffset;
    private static float yOffset;

    public Position(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public void setPosition(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public float getScrX()
    {
        return x - xOffset;
    }

    public float getScrY()
    {
        return y - yOffset;
    }

    public static void setXOffset(float xOffset)
    {
        Position.xOffset = xOffset;
    }

    public static void setYOffset(float yOffset)
    {
        Position.yOffset = yOffset;
    }


    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public static float getScrX(float x)
    {
        return x - xOffset;
    }

    public static float getScrY(float y)
    {
        return y - yOffset;
    }

    public static float getYOffset()
    {
        return yOffset;
    }
}
