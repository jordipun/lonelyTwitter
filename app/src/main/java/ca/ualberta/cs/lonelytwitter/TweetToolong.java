package ca.ualberta.cs.lonelytwitter;

/**
 * Created by jspun on 1/17/17.
 */
public class TweetToolong extends Exception {

    /**
     * Instantiates a new Tweet toolong.
     */
    public TweetToolong() {
    }

    /**
     * Instantiates a new Tweet toolong.
     *
     * @param detailMessage the detail message
     */
    public TweetToolong(String detailMessage) {
        super(detailMessage);
    }
}