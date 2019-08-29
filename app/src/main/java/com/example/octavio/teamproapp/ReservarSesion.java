package com.example.octavio.teamproapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ReservarSesion extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener{

    ArrayList<ReservarSesionesVo> reservacionesArrayList;
    JsonObjectRequest jsonObjectRequest;
    RequestQueue resquest;
    ProgressDialog progreso;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_sesion);

        setTitle("Reservaciones de Sesiones");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReservarSesion.this, Insertar_Reservaciones.class);
                startActivity(intent);
                finish();

            }
        });

        reservacionesArrayList = new ArrayList<>();
         lista = findViewById(R.id.listaReservaciones);

        Adaptador_Reservar_Sesiones reservacionesAdapter = new Adaptador_Reservar_Sesiones(this,reservacionesArrayList);
        lista.setAdapter(reservacionesAdapter);

        resquest = Volley.newRequestQueue(this);

        ConnectivityManager con = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = con.getActiveNetworkInfo();

        if(info !=null && info.isConnected()){

            cargarWebService();

        }else{
            Toast.makeText(this, "No hay conexión a Internet", Toast.LENGTH_SHORT).show();
        }

    }

    private void cargarWebService() {

        progreso = new ProgressDialog(ReservarSesion.this);
        progreso.setMessage("Cargando...");
        progreso.show();

        String url = "https://teampro.000webhostapp.com/ws_teampro/consultarReservaciones.php";

            jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
            resquest.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        progreso.hide();
        Toast.makeText(this, "No hay Reservaciones Aun" + error.toString(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResponse(JSONObject response) {
        ReservarSesionesVo reservarSesionesVo = null;

        JSONArray jsonArray = response.optJSONArray("sesion");
        try {

        for(int i =0;i<jsonArray.length();i++){
            reservarSesionesVo = new ReservarSesionesVo();
            JSONObject jsonObject =null;
                jsonObject=jsonArray.getJSONObject(i);
                reservarSesionesVo.setTipoSesion(jsonObject.optString("tipo_sesion"));

                reservarSesionesVo.setFecha(jsonObject.optString("fecha_sesion"));
                reservacionesArrayList.add(reservarSesionesVo);


        }
           }catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "No se pudo establecer la conexion", Toast.LENGTH_SHORT).show();

        }
        Adaptador_Reservar_Sesiones adapter = new Adaptador_Reservar_Sesiones(this,reservacionesArrayList);
        lista.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        progreso.hide();
    }



}
