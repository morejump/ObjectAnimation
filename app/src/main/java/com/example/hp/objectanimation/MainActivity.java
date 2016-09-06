package com.example.hp.objectanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private ObjectAnimator objectAnimator01;
    private ObjectAnimator objectAnimator02;
    private AnimatorSet animatorSet;
    private ObjectAnimator objectAnimator;
    private float angle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        button= (Button) findViewById(R.id.btn);
        button.setX(0f);
        button.setY(0f);
        button.setOnClickListener(this);
        angle=0f;
        final int[] height = new int[1];
        //
        //
//        objectAnimator01= ObjectAnimator.ofFloat(button,"x",angle,
//                getWithOfScreen(),0f);
//        objectAnimator01.setDuration(5000);
        //
//        objectAnimator = ObjectAnimator.ofFloat(button,"rotation",0f,3600f);
//        objectAnimator.setDuration(3000);

        objectAnimator02= ObjectAnimator.ofFloat(button,"y",angle,
                getHeightOfScreen()-button.getHeight()-getNavigationHeight(),0f);
        objectAnimator02.setDuration(5000);
        //
        animatorSet= new AnimatorSet();
        animatorSet.playTogether(objectAnimator02);
        //
        Log.d("thao", ""+getNavigationHeight());
        Log.d("thao01", ""+height[0]);
//        getNavigationHeight();
    }

    @Override
    public void onClick(View view) {
       animatorSet.start();
    }
    //
    private int getWithOfScreen() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
    //
    private int getHeightOfScreen() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }
    //
    public int getNavigationHeight() {
        Resources resources = getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId);
        }
        return 0;
    }

}
