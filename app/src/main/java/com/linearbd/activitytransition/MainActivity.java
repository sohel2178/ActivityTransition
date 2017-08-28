package com.linearbd.activitytransition;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.linearbd.activitytransition.Adapter.SampleAdapter;
import com.linearbd.activitytransition.Listener.ItemClickListener;
import com.linearbd.activitytransition.Model.Sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private List<Sample> sampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupWindowAnimations();

        initSampleList();
        setupToolbar();
        setupLayout();

    }

    private void setupLayout() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.sample_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SampleAdapter sampleAdapter = new SampleAdapter(getApplicationContext(), sampleList);
        sampleAdapter.setItemClickListener(this);
        recyclerView.setAdapter(sampleAdapter);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void initSampleList() {
        //noinspection ResourceType
        sampleList = Arrays.asList(
                new Sample(ContextCompat.getColor(this, R.color.sample_red), "Transitions"),
                new Sample(ContextCompat.getColor(this, R.color.sample_blue), "Shared Elements"),
                new Sample(ContextCompat.getColor(this, R.color.sample_green), "View animations"),
                new Sample(ContextCompat.getColor(this, R.color.sample_yellow), "Circular Reveal Animation")
        );
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void setupWindowAnimations() {
        // Re-enter transition is executed when returning to this activity
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT);
        slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);
    }

    @Override
    public void onClick(int position) {
        Log.d("HHH","Click");

        switch (position){
            case 0:
                Log.d("HHH","Click");
                transitionToActivity(TransitionActivity1.class,sampleList.get(position));
                break;

            case 1:
                break;

            case 2:
                break;

            case 3:
                break;
        }

    }


    private void transitionToActivity(Class target, Sample sample) {
        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
        startActivity(target, pairs, sample);
    }

    private void startActivity(Class target, Pair<View, String>[] pairs, Sample sample) {
        Intent intent = new Intent(getApplicationContext(),target);

        ActivityOptionsCompat activityTransitionOption =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,pairs);
        intent.putExtra("sample",sample);

        startActivity(intent,activityTransitionOption.toBundle());
    }
}
