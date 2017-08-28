package com.linearbd.activitytransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.linearbd.activitytransition.Model.Sample;

import java.util.ArrayList;
import java.util.List;

public class TransitionActivity2 extends BaseDetailActivity {

    private int type;
    private Sample sample;

    private TextView tvTitle;
    private ImageView ivSquareRed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition2);

        getData();

        initView();



        setupWindowAnimations();
        setupLayout();
        setupToolbar();
    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.title);
        ivSquareRed = (ImageView) findViewById(R.id.square_red);

        if(sample!=null){
            tvTitle.setText(sample.getName());
            ivSquareRed.setColorFilter(sample.getColor());
        }
    }

    private void getData() {
        sample = (Sample) getIntent().getSerializableExtra(EXTRA_SAMPLE);
        type = getIntent().getIntExtra(EXTRA_TYPE,0);
    }

    private void setupLayout() {
        findViewById(R.id.exit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
            }
        });
    }


    private void setupWindowAnimations() {
        Transition transition;

        if (type == TYPE_PROGRAMMATICALLY) {
            transition = buildEnterTransition();
        }  else {
            transition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
        }
        getWindow().setEnterTransition(transition);
    }

    private Transition buildEnterTransition() {
        Explode enterTransition = new Explode();
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        return enterTransition;

    }
}
