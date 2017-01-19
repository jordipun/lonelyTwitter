package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jspun on 1/17/17.
 */

public abstract class Mood {
    private Date date;
    private String mood;

    public Mood(Date date, String mood) throws TweetToolong {
        this.date=date;
        this.setMood(mood);

    }
    public Mood(String mood)throws TweetToolong{
        this.setMood(mood);
        this.date=new Date();
    }
    public abstract String DisplayMood();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

}





