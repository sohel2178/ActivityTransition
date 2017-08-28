package com.linearbd.activitytransition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Visibility;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.linearbd.activitytransition.Model.Sample;

public class TransitionActivity1 extends BaseDetailActivity implements View.OnClickListener {
    private Sample sample;
    private TextView tvTitle;

    private Button btnSample1,btnSample2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition1);

        setupWindowAnimations();
        setupToolbar();

        initView();

        sample = (Sample) getIntent().getSerializableExtra(EXTRA_SAMPLE);
        if(sample!= null){
            tvTitle.setText(sample.getName());

        }
    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.title);
        btnSample1 = (Button) findViewById(R.id.sample1_button1);
        btnSample2 = (Button) findViewById(R.id.sample1_button2);

        btnSample1.setOnClickListener(this);
        btnSample2.setOnClickListener(this);
    }

    private void setupWindowAnimations() {
        Visibility enterTransition = buildEnterTransition();
        getWindow().setEnterTransition(enterTransition);
    }

    private Visibility buildEnterTransition() {
        Fade enterTransition = new Fade();
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        enterTransition.excludeTarget(R.id.square_red,true); // You can replace any integer for |R.id.square_red|

        return enterTransition;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.sample1_button1:
                Intent i = new Intent(TransitionActivity1.this, TransitionActivity2.class);
                i.putExtra(EXTRA_SAMPLE, sample);
                i.putExtra(EXTRA_TYPE, TYPE_PROGRAMMATICALLY);
                transitionTo(i);
                break;

            case R.id.sample1_button2:
                break;

        }
    }
}
