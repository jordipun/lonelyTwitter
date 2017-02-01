package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jspun on 1/17/17.
 */
public class HappyFace extends Mood {
    /**
     * Instantiates a new Happy face.
     *
     * @param date the date
     * @param mood the mood
     * @throws TweetToolong the tweet toolong
     */
    public HappyFace(Date date, String mood) throws TweetToolong {
        super(date, mood);
    }

    /**
     * Instantiates a new Happy face.
     *
     * @param mood the mood
     * @throws TweetToolong the tweet toolong
     */
    public HappyFace(String mood) throws TweetToolong {
        super(mood);
    }

    public String DisplayMood() {
        String Mood = ":D";
        return Mood;
    }
}

