package com.nick.towerdefence.Controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nick.towerdefence.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

   // private Activity gameActivity;
    private View gameView;
    private GameEngine engine;

    public GameFragment() {
        // Constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.gameView = inflater.inflate(R.layout.fragment_game, container, false);
        return this.gameView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        this.engine = new GameEngine(this.gameView);
    }

    @Override
    public void onPause() {
        super.onPause();
        this.engine.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.engine.resume();
    }
}
