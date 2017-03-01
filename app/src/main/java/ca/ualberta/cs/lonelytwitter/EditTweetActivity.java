package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class EditTweetActivity extends Activity {
    String message;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        Intent intent = getIntent();
        String message = intent.getExtras().getString("tweets");

        textView = (TextView) findViewById(R.id.textView);

        textView.setText(message);

    }



}
