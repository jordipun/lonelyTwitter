package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jspun on 1/17/17.
 */

public class HappyFace extends Mood {
    public HappyFace(Date date, String mood) throws TweetToolong {
        super(date, mood);
    }

    public HappyFace(String mood) throws TweetToolong {
        super(mood);
    }

    public String DisplayMood() {
        String Mood = ":D";
        return Mood;
    }
}

