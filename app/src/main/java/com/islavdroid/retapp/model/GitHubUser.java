package com.islavdroid.retapp.model;


import com.google.gson.annotations.SerializedName;

public class GitHubUser {
    @SerializedName("login")
    private String login;
    @SerializedName("name")
    private String name;
    @SerializedName("followers")
    private String followers;
    @SerializedName("following")
    private String following;
    @SerializedName("avatar_url")
    private String   avatar;
    @SerializedName("email")
    private String  email;

    public String getRepos() {
        return repos;
    }

    public void setRepos(String repos) {
        this.repos = repos;
    }

    @SerializedName("public_repos")
    private String repos;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GitHubUser(String login, String name, String followers, String avatar, String following, String email) {
        this.login = login;
        this.name = name;
        this.followers = followers;
        this.avatar = avatar;
        this.following = following;
        this.email = email;
    }
}
