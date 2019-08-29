package com.example.octavio.teamproapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by octavio on 03-28-18.
 */

public class Adaptador_Sesiones extends RecyclerView.Adapter<Adaptador_Sesiones.ViewHolderSesiones> implements View.OnClickListener{
    ArrayList<SesionesVo>listaSesiones;
    private View.OnClickListener mlistener;
    Context context;

    public Adaptador_Sesiones(ArrayList<SesionesVo> listaSesiones, Context context) {
        this.listaSesiones = listaSesiones;
        this.context = context;
    }

    @Override
    public Adaptador_Sesiones.ViewHolderSesiones onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = 0;

        if(Utilidades.visualizacion == Utilidades.LIST){
            layout = R.layout.items_sesiones;
        }else{
            layout = R.layout.item_grid_sesiones;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,null, false);

        view.setOnClickListener(this);
        return new ViewHolderSesiones(view,context, listaSesiones);
    }

    @Override
    public void onBindViewHolder(Adaptador_Sesiones.ViewHolderSesiones holder, int position) {
        holder.titulo.setText(listaSesiones.get(position).getTitulo());
        holder.imagen.setImageResource(listaSesiones.get(position).getImagen());

    }


    @Override
    public int getItemCount() {
        return listaSesiones.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
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

    public class ViewHolderSesiones extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView titulo;
        private ImageView imagen;
        ArrayList<SesionesVo> listaSesiones = new ArrayList<SesionesVo>();
        Context context;
        public ViewHolderSesiones(View itemView, Context context, ArrayList<SesionesVo>listaSesiones) {
            super(itemView);
            this.context = context;
            this.listaSesiones= listaSesiones;
            itemView.setOnClickListener(this);
            titulo = itemView.findViewById(R.id.sesionesTitulo);
            imagen = itemView.findViewById(R.id.imagenCV);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            SesionesVo sesionesVo = this.listaSesiones.get(position);
            Intent intent = new Intent(this.context, Insertar_Reservaciones.class);
            intent.putExtra("nombre",sesionesVo.getTitulo());
            this.context.startActivity(intent);

        }
    }

}