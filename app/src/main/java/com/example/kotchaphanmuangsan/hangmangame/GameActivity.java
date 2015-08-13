package com.example.kotchaphanmuangsan.hangmangame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Kotchaphan Muangsan on 13/8/2558.
 */
public class GameActivity extends Activity {

    String mWord = "WORD";
    int mFailedCounter = 0;
    int mGuessedLetters = 0;

    int mPoint = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void introdueLetter(View v) {
        EditText editText = (EditText) findViewById(R.id.editTextLetter);
        //get edittext values
        String letter = editText.getText().toString();
        editText.setText("");

        Log.d("Log EditText", "Letter is : " + letter);
        if (letter.length() > 0 && letter.length() == 1) {
            checkLetter(letter);
        } else {
            Toast.makeText(getApplicationContext(), "Please introduce letter", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkLetter(String introduceLetter) {
        char charIntroduce = introduceLetter.charAt(0);
        boolean letterGuessed = false;
        for (int i = 0; i < mWord.length(); i++) {
            char charFromTheWord = mWord.charAt(i);
            if (charFromTheWord == charIntroduce) {
                //show letter
                Log.d("Word", "There was one match is : " + charFromTheWord);
                letterGuessed = true;
                showLetterAtIndex(i, charIntroduce);

                mGuessedLetters++;
            }
        }

        if (letterGuessed == false) {
            letterFailed(Character.toString(charIntroduce));
        }

        if (mGuessedLetters == mWord.length()) {
            //TODO Winer Score One Point
            mPoint++;
            //TODO Clear
            clearScreen();

        }
    }

    //TODO Clear
    public void clearScreen() {
        TextView textView = (TextView) findViewById(R.id.textView6);
        textView.setText("");

        mGuessedLetters = 0;
        mFailedCounter = 0;

        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);
        for (int i = 0; i < layoutLetter.getChildCount(); i++) {
            TextView currentTextView = (TextView) layoutLetter.getChildAt(i);
            currentTextView.setText("_");
        }

        //clear image to zero
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.hangdroid_0);
    }

    public void letterFailed(String letterFail) {

        //Respone Show Text
        TextView textView = (TextView) findViewById(R.id.textView6);

        String previousFail = textView.getText().toString();

        textView.setText(previousFail + letterFail);

        //mfailedCounter++
        mFailedCounter = mFailedCounter + 1;
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        //change image
        if (mFailedCounter == 1) {
            imageView.setImageResource(R.drawable.hangdroid_1);
        } else if (mFailedCounter == 2) {
            imageView.setImageResource(R.drawable.hangdroid_2);
        } else if (mFailedCounter == 3) {
            imageView.setImageResource(R.drawable.hangdroid_3);
        } else if (mFailedCounter == 4) {
            imageView.setImageResource(R.drawable.hangdroid_4);
        } else if (mFailedCounter == 5) {
            imageView.setImageResource(R.drawable.hangdroid_5);
        } else if (mFailedCounter == 6) {
            //TODO game over
            //go to Game Over Screen
            Intent intent = new Intent(GameActivity.this, GameOverActivity.class);
            intent.putExtra("POINTS", mPoint);
            startActivity(intent);
        }
    }

    public void showLetterAtIndex(int position, char letterGuessed) {
        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);

        TextView textView = (TextView) layoutLetter.getChildAt(position);
        textView.setText(Character.toString(letterGuessed));
    }
}
