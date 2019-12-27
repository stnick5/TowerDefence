package com.nick.towerdefence.Controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.nick.towerdefence.R;

public class GameActivity extends AppCompatActivity {

    // Create a new fragment
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Get ID of selected fragment (Game, How To Play, High Scores)
        Intent intent = getIntent();
        int buttonNumber = intent.getIntExtra("buttonNumber", -1);

        switch(buttonNumber)
        {
            case 1:
                this.fragment = new GameFragment();
                break;
            case 2:
                this.fragment = new HowToPlayFragment();
                break;
            case 3:
                this.fragment = new HighScoresFragment();
                break;
        }

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction().add(R.id.game_activity_fragment_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onPause() {
        this.fragment.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        this.fragment.onResume();
        super.onResume();
    }


}
