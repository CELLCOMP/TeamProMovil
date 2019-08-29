package com.example.octavio.teamproapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by octavio on 03-30-18.
 */

public class Adaptador_promociones extends RecyclerView.Adapter<Adaptador_promociones.ViewHolderPromociones> {
    ArrayList<PromocionesVo>listaPromociones;

    public Adaptador_promociones(ArrayList<PromocionesVo> listaPromociones) {
        this.listaPromociones = listaPromociones;
    }

    @Override
    public ViewHolderPromociones onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_promociones,null,false);

        return new ViewHolderPromociones( vista);
    }

    @Override
    public void onBindViewHolder(ViewHolderPromociones holder, int position) {
        holder.titulo.setText(listaPromociones.get(position).getTitulo());
        holder.descripcion.setText(listaPromociones.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return listaPromociones.size();
    }


    public class ViewHolderPromociones extends RecyclerView.ViewHolder {
      private TextView titulo,descripcion;

        public ViewHolderPromociones(View itemView) {

            super(itemView);
            titulo = itemView.findViewById(R.id.tituloPromo);
            descripcion = itemView.findViewById(R.id.descripcionPromo);

        }
    }
}
