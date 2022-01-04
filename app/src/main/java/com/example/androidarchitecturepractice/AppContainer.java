package com.example.androidarchitecturepractice;

import com.example.androidarchitecturepractice.repos.MainRepository;
import com.example.androidarchitecturepractice.repos.datasources.IntegerData;
import com.example.androidarchitecturepractice.repos.datasources.StringData;

/**
 * This class acts as a container for all application wide objects, such as repositories.
 * This container must be instantiated by an object with an application lifecycle. i.e. an
 * Application class.
 */
public class AppContainer
{
    private final IntegerData integerData = new IntegerData(R.color.white);
    private final StringData stringData = new StringData();

    public MainRepository mainRepository = new MainRepository(integerData, stringData);
}
