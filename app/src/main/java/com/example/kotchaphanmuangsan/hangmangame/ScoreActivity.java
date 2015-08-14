package com.example.kotchaphanmuangsan.hangmangame;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ScoreActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        SharedPreferences preferences = getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);

        String score = preferences.getString("SCORES" , "NO SCORES");
        TextView textView = (TextView) findViewById(R.id.textViewScore);
        textView.setText(score);
    }

}
