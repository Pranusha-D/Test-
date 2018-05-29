package com.example.ppranush.mvpdaggerrecyclerview.presenter;

import android.support.v7.widget.RecyclerView;

public interface Presenter {
    void setAnimation();

    interface PresenterCallBack {
        void onButtonClick(RecyclerView recyclerView, int dx, int dy);

        void onDestroy();
    }
}
