package my.game.object;

import my.game.object.tail.Tail;

public class BasicEnemy extends Enemy
{
    public BasicEnemy(int x, int y, float acc, float dcc, float maxSpeed, Tail tail, int difficulty)
    {
        super(x, y, acc, dcc, maxSpeed, tail, difficulty);
    }

    public BasicEnemy(Enemy enemy)
    {
        super(enemy);
    }
}
