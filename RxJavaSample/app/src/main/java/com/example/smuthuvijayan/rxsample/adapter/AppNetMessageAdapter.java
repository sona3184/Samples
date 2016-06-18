package com.example.smuthuvijayan.rxsample.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smuthuvijayan.rxsample.R;
import com.example.smuthuvijayan.rxsample.model.Datum;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by smuthuvijayan on 6/18/16.
 */

public class AppNetMessageAdapter extends RecyclerView.Adapter<AppNetMessageAdapter.AppNetMessageHolder> {

    private List<Datum> data;

    public AppNetMessageAdapter(List<Datum> data) {
        this.data = data;
    }

    @Override
    public AppNetMessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.card_app_new_message, parent, false);

        return new AppNetMessageHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AppNetMessageHolder appNetMessageHolder, int position) {
        final Datum datum = data.get(position);
        appNetMessageHolder.tvMessageText.setText(datum.getText());
        appNetMessageHolder.tvTimestamp.setText(datum.getCreatedAt());
        appNetMessageHolder.tvUsername.setText(datum.getUser().getUsername());
        Picasso.with(appNetMessageHolder.ivUserAvatar.getContext())
                .load(datum.getUser().getAvatarImage().getUrl())
                .into(appNetMessageHolder.ivUserAvatar);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addData(List<Datum> newData) {
        data.addAll(0, newData);
    }

    public static class AppNetMessageHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivUserAvatar) ImageView ivUserAvatar;
        @BindView(R.id.tvUsername) TextView tvUsername;
        @BindView(R.id.tvMessageText) TextView tvMessageText;
        @BindView(R.id.tvTimestamp) TextView tvTimestamp;

        public AppNetMessageHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
