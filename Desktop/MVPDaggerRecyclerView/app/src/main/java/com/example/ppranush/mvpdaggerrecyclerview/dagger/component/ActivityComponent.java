package com.example.ppranush.mvpdaggerrecyclerview.dagger.component;


import com.example.ppranush.mvpdaggerrecyclerview.dagger.module.MvpModule;
import com.example.ppranush.mvpdaggerrecyclerview.dagger.scope.ActivityScope;
import com.example.ppranush.mvpdaggerrecyclerview.presenter.Presenter;
import com.example.ppranush.mvpdaggerrecyclerview.view.MainActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = MvpModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
