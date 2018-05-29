package com.example.ppranush.mvpdaggerrecyclerview.model;

public class RecyclerViewPojo {

    private String title, description;
    private int imageView;


    public RecyclerViewPojo(int iv, String mTitle, String mDescription){
        imageView=iv;
        title=mTitle;
        description=mDescription;
    }

    public RecyclerViewPojo() {

    }


    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public int getImageView() {
        return imageView;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


}

