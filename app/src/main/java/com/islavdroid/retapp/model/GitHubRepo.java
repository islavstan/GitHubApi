package com.islavdroid.retapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by islav on 14.11.2016.
 */

public class GitHubRepo {
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("language")
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public GitHubRepo(String name, String description, String language) {
        this.name = name;
        this.description = description;
        this.language = language;
    }
}
