package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jspun on 1/17/17.
 */

public class Frustrated extends Mood {
    public Frustrated(String mood) throws TweetToolong {
        super(mood);
    }

    public Frustrated(Date date, String mood) throws TweetToolong {
        super(date, mood);
    }

    public String DisplayMood(){
        String Mood="D:";
        return Mood;
    }
}
