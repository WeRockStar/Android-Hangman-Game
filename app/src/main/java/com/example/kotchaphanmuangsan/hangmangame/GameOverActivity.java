package com.example.kotchaphanmuangsan.hangmangame;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GameOverActivity extends Activity {

    int mPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        //name , default values
        int points = getIntent().getIntExtra("POINTS_IDENTIFIER", 0);
        TextView textView = (TextView) findViewById(R.id.textViewPoints);
        textView.setText(String.valueOf(points));

        mPoint = points;

        //1.NAME X POINT
        //2.NAME X POINT
        //...
    }

    public void saveScore(View v) {
        SharedPreferences preferences = getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);
        EditText editText = (EditText) findViewById(R.id.editTextName);

        String name = editText.getText().toString();

        //List Name and edit local storage
        SharedPreferences.Editor editor = preferences.edit();
        String previousScore = preferences.getString("SCORES", "");
        editor.putString("SCORES", name + " " + mPoint + " POINTS \n");

        //save
        editor.commit();
    }
}
