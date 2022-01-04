package com.example.androidarchitecturepractice.repos.datasources;

public class IntegerData
{
    private int value;

    public IntegerData(int value)
    {
        this.value = value;
    }

    public void setValue(int newValue)
    {
        this.value = newValue;
    }

    public int getValue()
    {
        return value;
    }
}
