package com.example.fragment2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Locale;


@SuppressLint("AppCompatCustomView")
public class CountDownTimerView extends TextView {
    private final String TAG = "CountDownTimerView";
    private long mTimeInFuture;
    private long mTimeInterval;
    private long mStopTimeInFuture;
    private boolean mVisible;
    private boolean mRunning;
    private boolean mStarted;

    public CountDownTimerView(Context context) {
        this(context,null);
    }

    public CountDownTimerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CountDownTimerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public  void start() {
        mStarted = true;
        updateTimer();
    }

    public void stop(){
        mStarted = false;
        updateTimer();
    }


    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        mVisible = visibility == VISIBLE;
        updateTimer();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mVisible = false;
        updateTimer();
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        updateTimer();
    }

    private void updateTimer() {
        boolean running = mVisible && mStarted && isShown();
        if(running != mRunning){
            if(running) {
                doCountDownTimer();
            }else{
                removeCallbacks(mTickRunnable);
            }
            mRunning = running;
        }

    }

    private void onFinish() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
        setText("完成");
    }

    private final Runnable mTickRunnable = new Runnable() {
        @Override
        public void run() {
            if(mRunning){
                doCountDownTimer();
            }
        }
    };

    private void doCountDownTimer() {
        final long millisLeft = mStopTimeInFuture - SystemClock.elapsedRealtime();
        if(millisLeft <= 0){
            onFinish();
        }else{
            long lastUpdateTextStart = SystemClock.elapsedRealtime();
            updateText(millisLeft);
            // take into account updateText() take time to execute
            long lastUpdateTextDuration = SystemClock.elapsedRealtime() - lastUpdateTextStart;
            long delay;

            if(millisLeft < mTimeInterval){
                delay = millisLeft - lastUpdateTextDuration;

                if(delay < 0) {
                    delay = 0;
                }
            } else {
                delay = mTimeInterval - lastUpdateTextDuration;
                while (delay < 0) {
                    delay += mTimeInterval;
                }
            }
            postDelayed(mTickRunnable,delay);
        }
    }

    public void init(long timeInFuture, long timeInterval){
        mTimeInFuture = timeInFuture;
        mTimeInterval = timeInterval;
        mStopTimeInFuture = SystemClock.elapsedRealtime() + mTimeInFuture;
        updateText(mStopTimeInFuture);
    }

    private void updateText(long now) {
        String text = formatTime(now);
        setText(text);
    }

    private String formatTime(long now) {
        String split = " : ";
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss SSS", Locale.CHINA);
        String time = sdf.format(now).replace(" ",":");
//        Log.d(TAG,"sxy: " + time);
        String[] time_arr = time.split(":");
        int hour = Integer.parseInt(time_arr[0]);
//        Log.d(TAG,"sxy: before transform " + hour);
        hour-=8;
//        Log.d(TAG,"sxy: " + hour);
        if(hour<10){
            time_arr[0] = "0"+hour;
        }else{
            time_arr[0] = "" + hour;
        }

        return time_arr[0] + split + time_arr[1] + split
                +time_arr[2] + split + time_arr[3];
    }
}
