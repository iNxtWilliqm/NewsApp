package com.inxtwilliqm.newsapp.models;

public class News {
    private final String title;
    private final String description;
    private final String category;
    private final int image;

    public News(String title, String description, String category, int image) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public int getImage() {
        return image;
    }
}
