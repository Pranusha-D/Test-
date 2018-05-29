package com.example.ppranush.mvpdaggerrecyclerview.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;

import com.example.ppranush.mvpdaggerrecyclerview.model.RecyclerViewPojo;


public class PresenterImpl implements Presenter.PresenterCallBack, Animation.AnimationListener{

    private Presenter presenter;
    private RecyclerViewPojo model;

    public PresenterImpl(Presenter mainView, RecyclerViewPojo model) {
        this.presenter = mainView;
        this.model = model;
    }

    @Override
    public void onButtonClick(RecyclerView recyclerView, int dx, int dy) {
        if (dy > 0 || dy < 0) {
            presenter.setAnimation();
        }
    }

    @Override
    public void onDestroy() {
        presenter = null;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }


}
