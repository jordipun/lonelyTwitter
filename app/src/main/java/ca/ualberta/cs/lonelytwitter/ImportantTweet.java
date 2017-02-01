package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


/**
 * Created by jspun on 1/17/17.
 */
public class ImportantTweet extends Tweet {
    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     * @throws TweetToolong the tweet toolong
     */
    public ImportantTweet(String message) throws TweetToolong {
        super(message);
    }

    /**
     * Instantiates a new Important tweet.
     *
     * @param date    the date
     * @param message the message
     * @throws TweetToolong the tweet toolong
     */
    public ImportantTweet(Date date, String message) throws TweetToolong {
        super(date, message);
    }

    public Boolean isImportant(){
        return Boolean.TRUE;
    }
    @Override
    public String getMessage(){
        return super.getMessage() + " !!!";
    }
}
