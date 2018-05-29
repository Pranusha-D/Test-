package com.example.ppranush.mvpdaggerrecyclerview.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.ppranush.mvpdaggerrecyclerview.InitApplication;
import com.example.ppranush.mvpdaggerrecyclerview.R;
import com.example.ppranush.mvpdaggerrecyclerview.adapter.RecyclerViewAdapter;
import com.example.ppranush.mvpdaggerrecyclerview.dagger.component.DaggerActivityComponent;
import com.example.ppranush.mvpdaggerrecyclerview.dagger.module.MvpModule;
import com.example.ppranush.mvpdaggerrecyclerview.model.RecyclerViewPojo;
import com.example.ppranush.mvpdaggerrecyclerview.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity implements Presenter,Animation.AnimationListener {

    Toolbar mTopToolbar;
    Animation animFadeOut;

    private List<RecyclerViewPojo> recyclerViewList = new ArrayList<>();

    private RecyclerViewAdapter mAdapter;
    @Inject
    Presenter.PresenterCallBack presenterCallBack;

    @Inject
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //  ((MyApp) getApplicationContext()).getComponent().inject(this);

        DaggerActivityComponent.builder()
                .appComponent(InitApplication.get(this).component())
                .mvpModule(new MvpModule(this))
                .build()
                .inject(this);       // injecting presenter
        mTopToolbar = (Toolbar) findViewById(R.id.toolbar);
        animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_out);

        setSupportActionBar(mTopToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerViewAdapter(recyclerViewList);
        recyclerView.setAdapter(mAdapter);

        DividerItemDecoration itemDecor = new DividerItemDecoration(getApplicationContext(), VERTICAL);
        recyclerView.addItemDecoration(itemDecor);

        animFadeOut.setAnimationListener(this);
        prepareData();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
              /*  if (dy > 0 || dy < 0) {
                    mTopToolbar.startAnimation(animFadeOut);*/
                presenterCallBack.onButtonClick(recyclerView, dx, dy);

            }
        });
    }
    private void prepareData() {
        RecyclerViewPojo recyclerViewPojo = new RecyclerViewPojo(R.drawable.xamarin, "Xamarin", "Xamarin is a Microsoft-owned San Francisco California-based software company founded in May 2011 which has cross-platform implementations of the Common Language Infrastructure (CLI) and Common Language Specifications (often called Microsoft .NET)");
        recyclerViewList.add(recyclerViewPojo);

        recyclerViewPojo = new RecyclerViewPojo(R.drawable.phonegap, "PhoneGap", "PhoneGap is the most popular cross-platform framework for mobile hybrid application development. From the team behind Apache Cordova, the Adobe PhoneGap framework is an open source distribution of Cordova framework. With Phonegap, you can reuse existing web development skills to quickly make hybrid applications built with HTML, CSS, and JavaScript for multiple platforms with a single codebase so you can reach your audience no matter their device");
        recyclerViewList.add(recyclerViewPojo);

        recyclerViewPojo = new RecyclerViewPojo(R.drawable.ionic, "Ionic Framework", "The Ionic Framework is a complete open-source SDK for hybrid mobile app development. Built on top of Angular.js and Apache Cordova, Ionic provides tools and services for developing hybrid mobile apps using Web technologies like CSS, HTML5, and Sass. Apps can be built with these Web technologies and then distributed through native app stores to be installed on devices by leveraging Cordova");
        recyclerViewList.add(recyclerViewPojo);

        recyclerViewPojo = new RecyclerViewPojo(R.drawable.titanium, "Titanium", "Titanium has mixed development environments provided by Xamarin and PhoneGap. All apps are written in JavaScript but you must use a custom XML and Appcelerator's API to support some native features. This framework is cross-platform with full support for Android and iOS, but it is not included with CSS and HTML. In the end, the compiled code is a combination of native and javascript that improves a better performance for mobile hybrid development");
        recyclerViewList.add(recyclerViewPojo);

        recyclerViewPojo = new RecyclerViewPojo(R.drawable.angular, "Mobile Angular UI", "Mobile Angular UI is a hybrid mobile framework for the fans of Bootstrap and Angular. With Mobile Angular UI, you'll get the best of both Bootstrap 3 and Angular framework to build HTML5 mobile applications. Angular UI is more like an extension to Bootstrap 3 but without any dependencies of Bootstrap js libs or jQuery (which both are default dependencies in Bootstrap 3), instead, all you need to use are some AngularJS directives to create awesome mobile user experiences");
        recyclerViewList.add(recyclerViewPojo);

        mAdapter.notifyDataSetChanged();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterCallBack.onDestroy();
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

    @Override
    public void setAnimation() {
        mTopToolbar.startAnimation(animFadeOut);
    }
}
