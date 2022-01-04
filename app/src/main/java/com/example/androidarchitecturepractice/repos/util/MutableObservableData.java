package com.example.androidarchitecturepractice.repos.util;

import java.util.HashSet;
import java.util.Set;

public class MutableObservableData<T> extends ObservableData<T>
{
    public MutableObservableData(T value)
    {
        super(value);
    }

    public void setValue(T newValue)
    {
        super.setValue(newValue);
    }
}
