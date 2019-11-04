package com.katasandi.submission;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewPemainAdapter extends RecyclerView.Adapter<CardViewPemainAdapter.CardViewHolder> {
    private ArrayList<Pemain> listPemain;
    private Context context;

    public CardViewPemainAdapter(ArrayList<Pemain> list) {
        this.listPemain = list;
    }


    public void setListPemain (ArrayList<Pemain> listPemain) {
        this.listPemain = listPemain;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, int position) {
        final Pemain pemain = listPemain.get(position);
        Glide.with(holder.itemView.getContext())
                .load(pemain.getFoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgFoto);
        holder.tvNama.setText(pemain.getNama());
        holder.tvNomor.setText(pemain.getNomor());
        holder.tvPosisi.setText(pemain.getPosisi());
        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Favorite Pemain " +
                        listPemain.get(holder.getAdapterPosition()).getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPemain.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;
        TextView tvNama, tvPosisi, tvNomor;
        Button btnDetail, btnFavorite;
        CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.img_item_foto);
            tvNama = itemView.findViewById(R.id.tv_item_nama);
            tvPosisi = itemView.findViewById(R.id.tv_item_posisi);
            tvNomor = itemView.findViewById(R.id.tv_item_nomor);
            btnDetail = itemView.findViewById(R.id.btn_set_detail);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
        }
    }
}
