package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jspun on 1/17/17.
 */
public abstract class Mood {
    private Date date;
    private String mood;

    /**
     * Instantiates a new Mood.
     *
     * @param date the date
     * @param mood the mood
     * @throws TweetToolong the tweet toolong
     */
    public Mood(Date date, String mood) throws TweetToolong {
        this.date=date;
        this.setMood(mood);

    }

    /**
     * Instantiates a new Mood.
     *
     * @param mood the mood
     * @throws TweetToolong the tweet toolong
     */
    public Mood(String mood)throws TweetToolong{
        this.setMood(mood);
        this.date=new Date();
    }

    /**
     * Display mood string.
     *
     * @return the string
     */
    public abstract String DisplayMood();

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets mood.
     *
     * @return the mood
     */
    public String getMood() {
        return mood;
    }

    /**
     * Sets mood.
     *
     * @param mood the mood
     */
    public void setMood(String mood) {
        this.mood = mood;
    }

}





