package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jspun on 1/17/17.
 */
public abstract class Tweet implements Tweetable {

    private Date date;
    private String message;
    //private String hiddenString
    private ArrayList<Mood> moodArrayList;

    /**
     * Instantiates a new Tweet.
     *
     * @param date    the date
     * @param message the message
     * @throws TweetToolong the tweet toolong
     */
    public Tweet(Date date, String message) throws TweetToolong {
        this.date = date;
        this.setMessage(message);

    }

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     * @throws TweetToolong the tweet toolong
     */
    public Tweet(String message) throws TweetToolong {
        this.setMessage(message);
        this.date = new Date();
    }

    /**
     * Is important boolean.
     *
     * @return the boolean
     */
    public abstract Boolean isImportant();

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

    public String getMessage() {
        return message;
    }


    /**
     * Sets message.
     *
     * @param message the message
     * @throws TweetToolong the tweet toolong
     */
    public void setMessage(String message) throws TweetToolong {
        if (message.length() > 144) {
            // do stuff
            throw new TweetToolong();

        } else {
            this.message = message;

        }
    }


    /**
     * Add mood.
     *
     * @param mood the mood
     */
    public void addMood(Mood mood){
        moodArrayList.add(mood);
    }

    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}
