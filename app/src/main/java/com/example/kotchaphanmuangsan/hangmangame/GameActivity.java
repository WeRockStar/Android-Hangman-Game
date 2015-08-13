package com.example.kotchaphanmuangsan.hangmangame;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Kotchaphan Muangsan on 13/8/2558.
 */
public class GameActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void introdueLetter(View v) {
        EditText editText = (EditText) findViewById(R.id.editTextLetter);

        //get edittext values
        String letter = editText.getText().toString();
        Log.d("Log EditText" , "Letter is : "+letter);

    }
}
