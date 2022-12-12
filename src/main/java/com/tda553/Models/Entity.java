package com.tda553.Models;

public abstract class Entity
{
    private Position pos = new Position(0, 0);

    public int[] getPosition()
    {
        return new int[] {pos.getX(), pos.getY()};
    }

    public void setPosition(int x, int y)
    {
        pos.setPosition(x, y);
    }

    public int getX()
    {
        return pos.getX();
    }

    public int getY()
    {
        return pos.getY();
    }
}