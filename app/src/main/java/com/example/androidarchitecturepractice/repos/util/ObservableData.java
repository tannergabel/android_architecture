package com.example.androidarchitecturepractice.repos.util;

import java.util.HashSet;
import java.util.Set;

public class ObservableData<T>
{
    private T value;
    private final Set<Observer<T>> observers;

    public ObservableData(T value)
    {
        this.value = value;
        this.observers = new HashSet<>();
    }

    public T getValue()
    {
        return value;
    }

    protected void setValue(T newValue)
    {
        this.value = newValue;
        notifyAllObservers();
    }

    public boolean subscribe(Observer<T> o)
    {
        boolean b = observers.add(o);
        o.update(this.value);
        return b;
    }

    public boolean unsubscribe(Observer<T> o)
    {
        return observers.remove(o);
    }

    private void notifyAllObservers()
    {
        for (Observer<T> o: observers)
        {
            o.update(value);
        }
    }
}
