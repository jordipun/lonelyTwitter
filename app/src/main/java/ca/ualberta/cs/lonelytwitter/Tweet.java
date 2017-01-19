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

    public Tweet(Date date, String message) throws TweetToolong {
        this.date = date;
        this.setMessage(message);

    }

    public Tweet(String message) throws TweetToolong {
        this.setMessage(message);
        this.date = new Date();
    }

    public abstract Boolean isImportant();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }



    public void setMessage(String message) throws TweetToolong {
        if (message.length() > 144) {
            // do stuff
            throw new TweetToolong();

        } else {
            this.message = message;

        }
    }



    public void addMood(Mood mood){
        moodArrayList.add(mood);
    }
}
