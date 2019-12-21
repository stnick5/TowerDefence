package com.nick.towerdefence.Controller;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nick.towerdefence.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment{

    private GameEngine engine;

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        engine = new GameEngine(view);

        view.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

}
