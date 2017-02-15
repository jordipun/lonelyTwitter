package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

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

    public void testGetTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Another test tweet");
        Tweet tweet1 = new NormalTweet("Lol");
        Date date = new Date(192);
        Date date1 = new Date(200);
        tweet.setDate(date);
        tweet1.setDate(date1);

        tweets.add(tweet1);
        tweets.add(tweet);
       // assertEquals(tweet.getDate(), tweet1.getDate());
        /**
         * Both times not equal test fails
         */


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
    public void testcount(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("#1");


        tweets.add(tweet);

        if(tweets.getCount()==0){
            fail();
        }else{
            int i = tweets.getCount();
            assertTrue(true);
        }
    }

}
