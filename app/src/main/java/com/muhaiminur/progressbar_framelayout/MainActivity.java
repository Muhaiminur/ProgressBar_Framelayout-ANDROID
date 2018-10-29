package com.muhaiminur.progressbar_framelayout;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.progressbar)
    MaterialProgressBar progressbar;
    @BindView(R.id.start_progress)
    Button startProgress;


    Handler handler = new Handler();
    @BindView(R.id.end_progress)
    Button endProgress;

    ProgressBarHandler mProgressBarHandler;
    @BindView(R.id.main_view)
    LinearLayout mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.start_progress, R.id.end_progress})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.start_progress:
                //progressbar.setVisibility(View.VISIBLE);
                final int c=mainView.getDrawingCacheBackgroundColor();
                mainView.setBackgroundColor(getResources().getColor(R.color.cardview_shadow_start_color));
                mProgressBarHandler = new ProgressBarHandler(this); // In onCreate
                mProgressBarHandler.show(); // To show the progress bar
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        // do something...
                        //progressbar.setVisibility(View.GONE);
                        mProgressBarHandler.hide();
                        mainView.setBackgroundColor(c);
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    }
                }, 15000);
                break;
            case R.id.end_progress:
                progressbar.setVisibility(View.GONE);
                break;
        }
    }
}
