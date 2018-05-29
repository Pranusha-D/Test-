package com.example.ppranush.mvpdaggerrecyclerview.dagger.module;

import com.example.ppranush.mvpdaggerrecyclerview.model.RecyclerViewPojo;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    public RecyclerViewPojo provideModelClass() {
        return new RecyclerViewPojo();
    }
}
