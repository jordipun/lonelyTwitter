package ca.ualberta.cs.lonelytwitter;

/**
 * Created by jspun on 1/17/17.
 */

public class TweetToolong extends Exception {

    public TweetToolong() {
    }

    public TweetToolong(String detailMessage) {
        super(detailMessage);
    }
}