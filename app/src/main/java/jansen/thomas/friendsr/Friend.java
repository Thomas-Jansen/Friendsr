package jansen.thomas.friendsr;

import java.io.Serializable;

public class Friend implements Serializable {

//  Initiate variables for class Friend
    private String name, bio;
    private int drawableId;
    private float rating;

    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }
//  Getters for variables
    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public float getRating() {
        return rating;
    }

//  Setters for variables
    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setBio(String bio) { this.bio = bio; }
}
