package com.linearbd.activitytransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setupWindowAnimations();
    }

    private void setupWindowAnimations() {
        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setEnterTransition(fade);
    }
}
