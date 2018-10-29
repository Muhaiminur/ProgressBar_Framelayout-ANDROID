package com.muhaiminur.progressbar_framelayout;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.agrawalsuneet.loaderspack.loaders.PulseLoader;

public class ProgressBarHandler {
    private ProgressBar mProgressBar;
    private Context mContext;

    PulseLoader pulseLoader;

    public ProgressBarHandler(Context context) {
        mContext = context;

        ViewGroup layout = (ViewGroup) ((Activity) context).findViewById(android.R.id.content).getRootView();

        mProgressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleLarge);
        mProgressBar.setIndeterminate(true);

        pulseLoader = new PulseLoader(mContext,
                15,
                400,
                4.0f,
                15.0f,
                ContextCompat.getColor(mContext, R.color.accent));

        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        RelativeLayout rl = new RelativeLayout(context);

        rl.setGravity(Gravity.CENTER);
        rl.addView(pulseLoader);

        layout.addView(rl, params);

        hide();
    }

    public void show() {
        pulseLoader.setVisibility(View.VISIBLE);
    }

    public void hide() {
        pulseLoader.setVisibility(View.INVISIBLE);
    }
}