package com.example.agelessfitness.Model;

public class LeaderBoardModel {

    private int id;
    private int competitorsImage;
    private int competitorProgressImage;
    private String competitorName;
    private String competitorDuration;
    private String competitorCalories;

    public LeaderBoardModel(int id, int competitorsImage, int competitorProgressImage, String competitorName, String competitorDuration, String competitorCalories) {
        this.id = id;
        this.competitorsImage = competitorsImage;
        this.competitorProgressImage = competitorProgressImage;
        this.competitorName = competitorName;
        this.competitorDuration = competitorDuration;
        this.competitorCalories = competitorCalories;
    }

    public LeaderBoardModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompetitorsImage() {
        return competitorsImage;
    }

    public void setCompetitorsImage(int competitorsImage) {
        this.competitorsImage = competitorsImage;
    }

    public int getCompetitorProgressImage() {
        return competitorProgressImage;
    }

    public void setCompetitorProgressImage(int competitorProgressImage) {
        this.competitorProgressImage = competitorProgressImage;
    }

    public String getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(String competitorName) {
        this.competitorName = competitorName;
    }

    public String getCompetitorDuration() {
        return competitorDuration;
    }

    public void setCompetitorDuration(String competitorDuration) {
        this.competitorDuration = competitorDuration;
    }

    public String getCompetitorCalories() {
        return competitorCalories;
    }

    public void setCompetitorCalories(String competitorCalories) {
        this.competitorCalories = competitorCalories;
    }
}
