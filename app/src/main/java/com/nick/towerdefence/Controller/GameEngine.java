package com.nick.towerdefence.Controller;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.nick.towerdefence.Model.Level;
import com.nick.towerdefence.R;

public class GameEngine {

    Level level;

    public GameEngine(View view)
    {
        float width = view.findViewById(R.id.GameDisplayView).getWidth();
        float height = view.findViewById(R.id.GameDisplayView).getHeight();
        float x = view.findViewById(R.id.GameDisplayView).getX();
        float y = view.findViewById(R.id.GameDisplayView).getY();


        float cpWidth = view.findViewById(R.id.GameControlPanel).getWidth();
        float cpHeight = view.findViewById(R.id.GameControlPanel).getHeight();
        float cpx = view.findViewById(R.id.GameControlPanel).getX();
        float cpy = view.findViewById(R.id.GameControlPanel).getY();

        //level = new Level(gameGridLayout, controlPanelLayout);
    }
}
