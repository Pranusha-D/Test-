package com.example.ppranush.mvpdaggerrecyclerview.dagger.component;

import android.app.Application;
import android.content.Context;


import com.example.ppranush.mvpdaggerrecyclerview.InitApplication;
import com.example.ppranush.mvpdaggerrecyclerview.dagger.module.AppModule;
import com.example.ppranush.mvpdaggerrecyclerview.dagger.module.ContextModule;
import com.example.ppranush.mvpdaggerrecyclerview.dagger.module.DataModule;
import com.example.ppranush.mvpdaggerrecyclerview.model.RecyclerViewPojo;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DataModule.class, ContextModule.class})
public interface AppComponent {
    void inject(InitApplication initApplication);

    Context getContext();

    RecyclerViewPojo getFindItemsInteractor();

    Application getApplication();
}
