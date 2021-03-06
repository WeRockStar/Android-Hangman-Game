package com.example.kotchaphanmuangsan.hangmangame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSinglePlayGame(View v){
        Intent intent = new Intent(this , GameActivity.class);
        startActivity(intent);
    }

    public void startMultiGame(View v){
        Intent intent = new Intent(this , MultiplayerActivity.class);
        startActivity(intent);
    }

    public void openScore(View v){
        Intent intent = new Intent(this , ScoreActivity.class);
        startActivity(intent);
    }

}
