package com.example.ppranush.mvpdaggerrecyclerview.dagger.module;

import com.example.ppranush.mvpdaggerrecyclerview.model.RecyclerViewPojo;
import com.example.ppranush.mvpdaggerrecyclerview.presenter.Presenter;
import com.example.ppranush.mvpdaggerrecyclerview.presenter.PresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MvpModule {

    private Presenter viewCallBack;

    public MvpModule(Presenter viewCallBack) {
        this.viewCallBack = viewCallBack;
    }

    @Provides
    public Presenter provideView() {
        return viewCallBack;
    }

    @Provides
    public Presenter.PresenterCallBack providePresenter(Presenter view, RecyclerViewPojo model) {
        return new PresenterImpl(view, model);
    }
}
