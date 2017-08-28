package com.linearbd.activitytransition.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.linearbd.activitytransition.Listener.ItemClickListener;
import com.linearbd.activitytransition.Model.Sample;
import com.linearbd.activitytransition.R;

import java.util.List;

/**
 * Created by Genius 03 on 8/27/2017.
 */

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.SampleHolder>{
    private Context context;
    private List<Sample> sampleList;
    private LayoutInflater inflater;

    private ItemClickListener listener;

    public SampleAdapter(Context context, List<Sample> sampleList) {
        this.context = context;
        this.sampleList = sampleList;
        this.inflater = LayoutInflater.from(context);
    }

    public void setItemClickListener(ItemClickListener listener){
        this.listener = listener;
    }

    @Override
    public SampleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.sample_row,parent,false);

        return new SampleHolder(view);
    }

    @Override
    public void onBindViewHolder(SampleHolder holder, int position) {

        Sample sample = sampleList.get(position);
        holder.tvSampleName.setText(sample.getName());
        holder.ivSampleIcon.setColorFilter(sample.getColor());

    }

    @Override
    public int getItemCount() {
        return sampleList.size();
    }

    public class SampleHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView ivSampleIcon;
        TextView tvSampleName;

        public SampleHolder(View itemView) {
            super(itemView);
            ivSampleIcon = itemView.findViewById(R.id.sample_icon);
            tvSampleName = itemView.findViewById(R.id.sample_name);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(listener != null){
                listener.onClick(getAdapterPosition());
            }

        }
    }
}
