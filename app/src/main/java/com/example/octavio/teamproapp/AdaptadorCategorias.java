package com.example.octavio.teamproapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by octavio on 03-26-18.
 */

public class AdaptadorCategorias extends RecyclerView.Adapter<AdaptadorCategorias.ViewHolderCategorias> implements View.OnClickListener {
    static ArrayList<CategoriasVo>listaCategorias;
    private View.OnClickListener mlistener;


    public AdaptadorCategorias(ArrayList<CategoriasVo> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    @Override
    public ViewHolderCategorias onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_categoria,null, false);
       view.setOnClickListener(this);

        return new ViewHolderCategorias(view);
    }


    @Override
    public void onBindViewHolder(ViewHolderCategorias holder, int position) {
    holder.nombreTV.setText(listaCategorias.get(position).getNombre());
    holder.descripcionTV.setText(listaCategorias.get(position).getDescripcion());
    holder.fotoButton.setImageResource(listaCategorias.get(position).getImagenPreview());


    }

    @Override
    public int getItemCount()  {
        return listaCategorias.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.mlistener = listener;
    }
    @Override
    public void onClick(View view) {
    if(mlistener !=null){
        mlistener.onClick(view);
    }
    }


    public class ViewHolderCategorias extends RecyclerView.ViewHolder {
        TextView nombreTV, descripcionTV;
        ImageView fotoButton;

        ImageView imagenPortada;

        public ViewHolderCategorias(View itemView) {
            super(itemView);

            nombreTV = itemView.findViewById(R.id.idNombreCategoria);
            descripcionTV = itemView.findViewById(R.id.idInfoDescripcion);
            fotoButton = itemView.findViewById(R.id.idImagenButton);
        }
    }



}
