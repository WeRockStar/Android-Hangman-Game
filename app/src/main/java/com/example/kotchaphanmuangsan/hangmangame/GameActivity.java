package com.example.kotchaphanmuangsan.hangmangame;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Kotchaphan Muangsan on 13/8/2558.
 */
public class GameActivity extends Activity{

    String mWord = "WORD";

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
        if(letter.length() > 0 && letter.length() == 1){
            checkLetter(letter);
        }else {
            Toast.makeText(getApplicationContext() , "Please introduce letter" , Toast.LENGTH_SHORT).show();
        }
    }

    public void checkLetter(String introduceLetter){
        char charIntroduce = introduceLetter.charAt(0);
        for (int i = 0;i < mWord.length();i++){
            char charFromTheWord = mWord.charAt(i);
            if (charFromTheWord == charIntroduce){
                //show letter
                Log.d("Word" , "There was one match is : "+charFromTheWord);

                showLetterAtIndex(i , charIntroduce);
            }
        }
    }

    public void showLetterAtIndex(int position , char letterGuessed){
        
    }
}
