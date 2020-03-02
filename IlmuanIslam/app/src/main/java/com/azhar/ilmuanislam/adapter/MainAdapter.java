package com.azhar.ilmuanislam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.azhar.ilmuanislam.R;
import com.azhar.ilmuanislam.model.MainModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private ArrayList<MainModel> listMain;

    public ArrayList<MainModel> getListMain() {
        return listMain;
    }

    public void setListMain(ArrayList<MainModel> listMain) {
        this.listMain = listMain;
    }

    public MainAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_main, viewGroup, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvName.setText(getListMain().get(i).getName());
        viewHolder.tvYear.setText(getListMain().get(i).getYear());
        viewHolder.tvDesc.setText(getListMain().get(i).getDesc());

        Glide.with(context)
                .load(getListMain().get(i).getPhoto())
                .into(viewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return listMain.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvYear, tvDesc;
        ImageView imgPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvYear = itemView.findViewById(R.id.tv_year);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            imgPhoto = itemView.findViewById(R.id.img_photo);

        }
    }
}
