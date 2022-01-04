package com.example.androidarchitecturepractice.repos;

import com.example.androidarchitecturepractice.repos.datasources.IntegerData;
import com.example.androidarchitecturepractice.repos.datasources.StringData;
import com.example.androidarchitecturepractice.repos.util.MutableObservableData;
import com.example.androidarchitecturepractice.repos.util.ObservableData;

public class MainRepository
{
    private final IntegerData integerDataSource;
    private final StringData stringDataSource;

    private final MutableObservableData<Integer> currentColor;

    public MainRepository(IntegerData integerDataSource, StringData stringDataSource)
    {
        this.integerDataSource = integerDataSource;
        this.stringDataSource = stringDataSource;
        this.currentColor = new MutableObservableData<>(integerDataSource.getValue());
    }

    public ObservableData<Integer> getCurrentColor()
    {
        return currentColor;
    }

    public void setCurrentColor(int newColorId)
    {
        integerDataSource.setValue(newColorId);
        currentColor.setValue(newColorId);
    }
}
