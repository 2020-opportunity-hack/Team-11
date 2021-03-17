package com.ichangemycity.ichangemycommunity.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ichangemycity.ichangemycommunity.R;
import com.ichangemycity.ichangemycommunity.model.LuminosityRowItem;

public class LuminosityAdapter extends RecyclerView.Adapter<LuminosityAdapter.ViewHolder> {

    private LuminosityRowItem luminosityData[];

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView thumbnailText;
        private final ImageView thumbnail;

        public ViewHolder(View view) {
            super(view);
            thumbnail = view.findViewById(R.id.thumbnail);
            thumbnailText = view.findViewById(R.id.thumbnail_text);
        }

        public TextView getThumbnailText() {
            return thumbnailText;
        }

        public ImageView getThumbnail() {
            return thumbnail;
        }
    }

    public LuminosityAdapter(LuminosityRowItem luminosityData[]) {
        this.luminosityData = luminosityData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.thumbnail.setImageBitmap(luminosityData[position].getImage());
        holder.thumbnailText.setText(luminosityData[position].getLumens() + " Lumens");
    }

    @Override
    public int getItemCount() {
        return luminosityData.length;
    }
}
