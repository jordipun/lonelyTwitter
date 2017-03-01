package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by jspun on 2/14/17.
 */

public class TweetList {


    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    int count = 0;

    public void add(Tweet tweet) {

        if (tweets.contains(tweet)) {
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
        }


    }

    public boolean hasTweet(Tweet tweet) {


        return tweets.contains(tweet);

    }


    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public Tweet getTweet(int index) {
        return tweets.get(index);
    }
}



