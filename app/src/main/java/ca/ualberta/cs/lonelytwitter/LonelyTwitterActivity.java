package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static android.R.attr.type;


/**
 * This class sis the main view class of the project, <br> In this class, user interaction
 * and file manipulation is performed.
 * All files are in the form of "json" files tjat are stored in Emulator's accessilbe from Android
 * <pre>
 *     pre-formatted text: <br>
 *         File Explorer -> data -> data -> data -> ca.ualberta.cs.lonelytwitter ->files ->file.sav
 *
 * </pre>
 * <code> begin <br>
 * some psuedo code <br>
 * end.</code>
 * The file name is indicated in the &nbsp &nbsp &nbsp FILENAME constant .
 * <ul>
 * <ol>
 * <li>item 1</li>
 * <li>item 2</li>
 * <li>item 3</li>
 * </ol>
 * </ul>
 *
 * @author jspun
 * @version 1.0
 * @see Tweet
 * @since 0.5
 */
public class LonelyTwitterActivity extends Activity {
    /**
     * The file that all the tweets are saved there. The format of the file is JSON
     * @see #loadFromFile()
     * @see #saveInFile()
     *
     */

    private static final String FILENAME = "file.sav";
    private enum TweetListOrdering {
        /**
         * Date ascending tweet list ordering.
         */
        DATE_ASCENDING, /**
         * Date descending tweet list ordering.
         */
        DATE_DESCENDING, /**
         * Text ascending tweet list ordering.
         */
        TEXT_ASCENDING, /**
         * Text descending tweet list ordering.
         */
        TEXT_DESCENDING};
    private EditText bodyText;
    private ListView oldTweetsList;

    private ArrayList<Tweet> tweetList;
    private ArrayAdapter<Tweet> adapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bodyText = (EditText) findViewById(R.id.body);
        Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);
        oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);


        try {
            Tweet tweet = new NormalTweet("First Juan");
            tweet.setMessage("Allah");
            ImportantTweet importantTweet = new ImportantTweet("Important");
            importantTweet.getMessage();
            NormalTweet normalTweet = new NormalTweet("im Normal");

            ArrayList<Tweet>arrayList = new ArrayList<Tweet>();
            arrayList.add(tweet);
            arrayList.add(importantTweet);
            arrayList.add(normalTweet);

















        } catch (TweetToolong e) {
            e.printStackTrace();
        }
        clearButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {

                tweetList.clear();

                adapter.notifyDataSetChanged();
                deleteFile(FILENAME);
            }

        });
        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                String text = bodyText.getText().toString();
                text=trimExtraSpace(text);
                Tweet tweet = null;
                try {
                    tweet = new NormalTweet(text);
                } catch (TweetToolong tweetToolong) {
                    tweetToolong.printStackTrace();
                }
                tweetList.add(tweet);
         //       saveInFile(text, new Date(System.currentTimeMillis()));
                //finish();
                adapter.notifyDataSetChanged();
                saveInFile();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

        loadFromFile();
        //String[] tweets = loadFromFile();
        adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweetList);
        oldTweetsList.setAdapter(adapter);
    }

    /**
     * Trims extra s[aces using regualr expression
     * @param inputString string that needs to be cleared of extra spaces
     * @return resulting string
     */

    private String trimExtraSpace(String inputString){
        inputString = inputString.replaceAll("\\s+"," ");
        return inputString;
    }

    /**
     * This method sorts items in the tweet list and refreshes the adapter.
     * @param ordering ordering to be used
     */
    private void sortTweetListItems(TweetListOrdering ordering){


    }

    /**
     * Loads tweets from specified file.
     *
     * @throws TweetToolong if the tweet is too long
     * @exception FileNotFoundException if the file is not created first
     *
     */

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();

            tweetList = gson.fromJson(in,listType);

            //taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            //2017-01-24 18:19

        } catch (FileNotFoundException e) {
            tweetList = new ArrayList<Tweet>();
            // TODO Auto-generated catch block

        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }

    }

    /**
     * Saves tweets to a specified file in JSON format.
     * @throws FileNotFoundException if file folder doesn't exist
     *
     */

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(tweetList, out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            //TODO: Handle the Exception properly later
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     *
     * @return the index api action
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("LonelyTwitter Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStop() {

        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}