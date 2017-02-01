package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jspun on 1/17/17.
 */
public class Frustrated extends Mood {
    /**
     * Instantiates a new Frustrated.
     *
     * @param mood the mood
     * @throws TweetToolong the tweet toolong
     */
    public Frustrated(String mood) throws TweetToolong {
        super(mood);
    }

    /**
     * Instantiates a new Frustrated.
     *
     * @param date the date
     * @param mood the mood
     * @throws TweetToolong the tweet toolong
     */
    public Frustrated(Date date, String mood) throws TweetToolong {
        super(date, mood);
    }

    public String DisplayMood(){
        String Mood="D:";
        return Mood;
    }
}
