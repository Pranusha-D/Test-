package com.example.ppranush.mvpdaggerrecyclerview.dagger.module;

import android.app.Application;


import com.example.ppranush.mvpdaggerrecyclerview.InitApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private InitApplication initApplication;    // Application instance

    public AppModule(InitApplication initApplication) {
        this.initApplication = initApplication;
    }   //initialise with app instance

    @Provides
    @Singleton
    public Application provideApplication() {
        return initApplication;
    }
}
