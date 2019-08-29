package com.example.octavio.teamproapp;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gamero on 2/5/2018.
 */

public class Adaptador_Reservar_Sesiones extends BaseAdapter implements DatePickerDialog.OnDateSetListener  {
    private ArrayList<ReservarSesionesVo> reservarSesionesVoArrayList;
    private Context context;

    public Adaptador_Reservar_Sesiones(Context context ,ArrayList<ReservarSesionesVo> reservarSesionesVoArrayList) {
        this.context = context;
        this.reservarSesionesVoArrayList = reservarSesionesVoArrayList;

    }

    @Override
    public int getCount() {
        return reservarSesionesVoArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return reservarSesionesVoArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vista = inflater.inflate(R.layout.item_reservaciones, viewGroup,false);

        TextView tipoSesion = vista.findViewById(R.id.tipoSesion);
        TextView fechaReservacion = vista.findViewById(R.id.fechaSesion);


        tipoSesion.setText(reservarSesionesVoArrayList.get(i).getTipoSesion());
        fechaReservacion.setText(reservarSesionesVoArrayList.get(i).getFecha());




        return vista;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

    }
}
