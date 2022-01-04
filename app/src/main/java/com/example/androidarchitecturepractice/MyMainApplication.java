package com.example.androidarchitecturepractice;

import android.app.Application;

/**
 * This class extends Application and is therefore created automatically by android
 * once and lasts the duration of the application. All classes that need the container's
 * data can access it through this class.
 */
public class MyMainApplication extends Application
{
    public AppContainer appContainer = new AppContainer();
}
