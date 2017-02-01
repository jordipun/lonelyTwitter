package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by jspun on 1/17/17.
 */
public class NormalTweet extends Tweet {
    /**
     * Instantiates a new Normal tweet.
     *
     * @param date    the date
     * @param message the message
     * @throws TweetToolong the tweet toolong
     */
    public NormalTweet(Date date, String message) throws TweetToolong {
        super(date, message);
    }

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     * @throws TweetToolong the tweet toolong
     */
    public NormalTweet(String message) throws TweetToolong {
        super(message);
    }

    public Boolean isImportant(){
        return Boolean.FALSE;
}

}
