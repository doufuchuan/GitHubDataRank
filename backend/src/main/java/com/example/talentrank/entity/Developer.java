package com.example.talentrank.entity;

public class Developer {
    private int id;
    private int github_id;
    private String username;
    private String nation;
    private int repos;
    private int followers;
    private int contributions;
    private int stars;
    private int issues;
    private float talent_rank;

    public int getId(){ return id;}

    public void setId(int id) {
        this.id = id;
    }

    public int getGithub_id() {
        return github_id;
    }

    public void setGithub_id(int github_id) {
        this.github_id = github_id;
    }

    public String getUsername(){return username;}

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNation(){return nation;}

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getRepos() {
        return repos;
    }

    public void setRepos(int repos) {
        this.repos = repos;
    }
    public int getContributions() {
        return contributions;
    }

    public void setContributions(int contributions) {
        this.contributions = contributions;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getIssues() {
        return issues;
    }

    public void setIssues(int issues) {
        this.issues = issues;
    }

    public float getTalent_rank() {
        return talent_rank;
    }

    public void setTalent_rank(int talent_rank) {
        this.talent_rank = talent_rank;
    }
}
