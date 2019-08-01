package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mScore1;
    private int mScore2;

    TextView mScore1TextView;
    TextView mScore2TextView;

    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScore1TextView = findViewById(R.id.score_1);
        mScore2TextView = findViewById(R.id.score_2);

        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            mScore1TextView.setText(String.valueOf(mScore1));
            mScore2TextView.setText(String.valueOf(mScore2));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();

            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                Toast.makeText(this, "Day Mode On", Toast.LENGTH_SHORT).show();
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                Toast.makeText(this, "Night Mode On", Toast.LENGTH_SHORT).show();
            }

            recreate();
        }
        return super.onOptionsItemSelected(item);
    }

    public void decreaseScore(View view) {

        int viewID = view.getId();

        switch (viewID) {
            case R.id.decreaseTeam1:
                mScore1--;
                mScore1TextView.setText(String.valueOf(mScore1));
                break;

            case R.id.decreaseTeam2:
                mScore2--;
                mScore2TextView.setText(String.valueOf(mScore2));
                break;
        }
    }

    public void increaseScore(View view) {

        int viewID = view.getId();

        switch (viewID) {
            case R.id.increaseTeam1:
                mScore1++;
                mScore1TextView.setText(String.valueOf(mScore1));
                break;

            case R.id.increaseTeam2:
                mScore2++;
                mScore2TextView.setText(String.valueOf(mScore2));
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }
}
