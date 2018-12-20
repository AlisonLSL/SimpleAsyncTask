package com.example.taruc.simpleasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //The TextView where we will show results
    private TextView mTextView = null;

    //Key for saving the state of the TextView
    private static final String TEXT_STATE = "currentText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Save the state of the TextView
        setContentView(R.layout.activity_main);

        //Initialise mTextView
        mTextView = (TextView)findViewById(R.id.textView1);

        if (savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    public void startTask(View view) {
        //Put a message in the text view
        mTextView.setText(R.string.napping);

        //Start the AsyncTask.
        //The AsyncTask has a callback that will update the text view.
        new SimpleAsyncTask(mTextView).execute();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Save the state of the TextView
        outState.putString(TEXT_STATE, mTextView.getText().toString());
    }
}
