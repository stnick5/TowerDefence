package com.nick.towerdefence.Controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.nick.towerdefence.Model.Level;
import com.nick.towerdefence.R;

public class GameEngine extends View implements View.OnTouchListener{

    private Level level;

    public GameEngine(Context context)
    {
        super(context);

        // Sets the view to the game fragment.
        View view = ((Activity)context).getWindow().getDecorView().findViewById(R.id.GameFragment);

        // Get the game grid and control panel layouts from the XML file
        LinearLayout gameLayout = view.findViewById(R.id.GameDisplayView);
        LinearLayout controlLayout = view.findViewById(R.id.GameControlPanel);

        // Set the Touch Listeners for both layouts.
        gameLayout.setOnTouchListener(this);
        controlLayout.setOnTouchListener(this);

        float width = view.findViewById(R.id.GameDisplayView).getWidth();
        float height = view.findViewById(R.id.GameDisplayView).getHeight();
        float x = view.findViewById(R.id.GameDisplayView).getX();
        float y = view.findViewById(R.id.GameDisplayView).getY();
        RectF gameRect = new RectF(x, y, width, height);


        float cpWidth = view.findViewById(R.id.GameControlPanel).getWidth();
        float cpHeight = view.findViewById(R.id.GameControlPanel).getHeight();
        float cpx = view.findViewById(R.id.GameControlPanel).getX();
        float cpy = view.findViewById(R.id.GameControlPanel).getY();
        RectF controlRect = new RectF(cpx, cpy, cpWidth, cpHeight);

        level = new Level(view, gameRect, controlRect);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return level.processTouchEvents(event, v.getId());
    }
}
