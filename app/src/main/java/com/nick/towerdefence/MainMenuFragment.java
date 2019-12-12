package com.nick.towerdefence;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nick.towerdefence.Controller.GameActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainMenuFragment extends Fragment {

    // Menu buttons
    Button btnStartGame, btnHowToPlay, btnHighScores;

    public MainMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);

        btnStartGame = view.findViewById(R.id.btnStartGame);
        btnHowToPlay = view.findViewById(R.id.btnHowToPlay);
        btnHighScores = view.findViewById(R.id.btnHighScores);

        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGameActivity(1);
            }
        });

        btnHowToPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGameActivity(2);
            }
        });

        btnHighScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGameActivity(3);
            }
        });

        return view;
    }

    public void startGameActivity(int buttonNumber)
    {
        // Create intent
        Intent intent = new Intent(getActivity().getApplicationContext(), GameActivity.class);

        // Add the buttonNumber variable to the intent.
        intent.putExtra("buttonNumber", buttonNumber);

        // Start activity
        startActivity(intent);
    }

}
