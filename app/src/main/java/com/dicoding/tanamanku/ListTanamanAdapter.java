package com.dicoding.tanamanku;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListTanamanAdapter extends RecyclerView.Adapter<ListTanamanAdapter.ListViewHolder> {

    private ArrayList<Tanaman> listTanaman;
    private OnItemClickCallBack onItemClickCallBack;

    public ListTanamanAdapter(ArrayList<Tanaman> list){
        this.listTanaman = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_tanaman, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Tanaman tanaman = listTanaman.get(position);
        Glide.with(holder.itemView.getContext())
                .load(tanaman.getFotoTanaman())
                .apply(new RequestOptions().override(60, 60))
                .into(holder.fotoTanaman);
        holder.tvNamaTanaman.setText(tanaman.getNamaTanaman());
        holder.tvDetailTanaman.setText(tanaman.getDetailTanaman());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallBack.onItemClicked(listTanaman.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTanaman.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView fotoTanaman;
        TextView tvNamaTanaman, tvDetailTanaman;

        ListViewHolder(View itemView) {
            super(itemView);
            fotoTanaman =itemView.findViewById(R.id.foto_tanaman);
            tvNamaTanaman = itemView.findViewById(R.id.tv_nama_tanaman);
            tvDetailTanaman = itemView.findViewById(R.id.tv_detail_tanaman);
        }
    }

    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack;

    }

    public interface OnItemClickCallBack{
        void onItemClicked(Tanaman data);
    }



}
