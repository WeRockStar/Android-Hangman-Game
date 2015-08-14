package com.example.kotchaphanmuangsan.hangmangame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MultiplayerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);
        
    }

    public void startMultiGame(View v) {
        EditText editText = (EditText) findViewById(R.id.editTextWord);
        String wordToGuess = editText.getText().toString();
        editText.setText("");
        Intent intent = new Intent(this, GameMultiActivity.class);
        intent.putExtra("WORD", wordToGuess);
        startActivity(intent);
    }

}
