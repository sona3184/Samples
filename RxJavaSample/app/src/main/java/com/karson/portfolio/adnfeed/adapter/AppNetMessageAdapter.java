package com.karson.portfolio.adnfeed.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.karson.portfolio.adnfeed.R;
import com.karson.portfolio.adnfeed.model.AppNetRowData;
import com.github.curioustechizen.ago.RelativeTimeTextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.karson.portfolio.adnfeed.Util.getLongFromTimeString;

/**
 * Created by smuthuvijayan on 6/18/16.
 */

public class AppNetMessageAdapter extends RecyclerView.Adapter<AppNetMessageAdapter.AppNetMessageHolder> {

    private List<AppNetRowData> data = new ArrayList<>();

    public AppNetMessageAdapter(List<AppNetRowData> data) {
        this.data.addAll(data);
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
        final AppNetRowData datum = data.get(position);
        Picasso.with(appNetMessageHolder.ivUserAvatar.getContext())
                .load(datum.getAvatarUrl())
                .into(appNetMessageHolder.ivUserAvatar);
        appNetMessageHolder.tvMessageText.setText(datum.getPostText());
        appNetMessageHolder.tvUsername.setText(datum.getUsername());
        appNetMessageHolder.tvTimestamp.setReferenceTime(getLongFromTimeString(datum.getTimeStamp()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addData(List<AppNetRowData> newData) {
        data.addAll(0, newData);
        notifyDataSetChanged();
    }

    public void addData(AppNetRowData newDatum) {
        data.add(0, newDatum);
        notifyDataSetChanged();
    }

    public static class AppNetMessageHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivUserAvatar) ImageView ivUserAvatar;
        @BindView(R.id.tvUsername) TextView tvUsername;
        @BindView(R.id.tvMessageText) TextView tvMessageText;
        @BindView(R.id.tvTimestamp) RelativeTimeTextView tvTimestamp;

        public AppNetMessageHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
