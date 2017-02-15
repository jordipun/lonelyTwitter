package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by jspun on 2/14/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2{

    public TweetListTest(){
        super(LonelyTwitterActivity.class);

    }

    public void testAddTweet(){

        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test tweet");


        tweets.add(tweet);
        try {
            tweets.add(tweet);
            fail();
        } catch (IllegalArgumentException e)
                //passes test
        {

        }
        assertTrue(tweets.hasTweet(tweet));


    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another test tweet");

        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(),tweet.getMessage());
        assertEquals(returnedTweet.getDate(),tweet.getDate());
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Last tweet");

        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }
    public void testStrings(){
        assertEquals("'test' should be 'test' ","test","test");
        assertTrue("'test' should start with 't'", "test".startsWith("y"));
    }

    public void testhasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("#1");
        Tweet tweet2 = new NormalTweet("#2");

        tweets.add(tweet);
        tweets.add(tweet2);



        /**
         *
         * Test for error
          */
        //assertTrue(tweets.hasTweet(tweet1));

        tweets.add(tweet);

        assertTrue(tweets.hasTweet(tweet));










    }

}
