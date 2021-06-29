package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mScore1;
    private int mScore2;

    static  final  String SCORE_1 ="Team 1 Score";
    static  final  String SCORE_2 ="Team 2 Score";

    private TextView mScoreText1;
    private TextView mScoreText2;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main__menu,menu);
        int NightMode = AppCompatDelegate.getDefaultNightMode();
        if(NightMode==AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);

        }
        else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.night_mode){
            int NightMode = AppCompatDelegate.getDefaultNightMode();
            if(NightMode==AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode((AppCompatDelegate.MODE_NIGHT_NO));
            }
            else{
                AppCompatDelegate.setDefaultNightMode((AppCompatDelegate.MODE_NIGHT_YES));
            }
            recreate();
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScoreText1=(TextView)findViewById(R.id.score_1);
        mScoreText2=(TextView)findViewById(R.id.score_2);
        if(savedInstanceState != null){
            mScore1=savedInstanceState.getInt(SCORE_1);
            mScore2=savedInstanceState.getInt(SCORE_2);

            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText1.setText(String.valueOf(mScore2));


        }

    }

    public void decreaseScore(View view) {
        int viewID =view.getId();
        switch (viewID){
            case R.id.decreaseTeam1:
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam2:
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));






        }
    }

    public void increaseScore(View view) {
        int viewID =view.getId();
        switch (viewID){
            case R.id.increaseTeam1:
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam2:
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));




        }
}

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(SCORE_1,mScore1);
        outState.putInt(SCORE_2,mScore2);
        super.onSaveInstanceState(outState);
    }
}