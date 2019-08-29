package com.example.octavio.teamproapp;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Calendar;

public class Insertar_Reservaciones extends AppCompatActivity implements View.OnClickListener , Response.Listener<JSONObject>, Response.ErrorListener{
    private EditText fechaET, tipoSesion, nombre,telefono;
    private int dia,mes,anio;
    private Button reservarBoton;
    private ProgressDialog progreso;
    RequestQueue resquest;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar__reservaciones);

        setTitle("Reservacion");
        tipoSesion = findViewById(R.id.tipoSesionET);
        fechaET = findViewById(R.id.fechaReservacion);

        reservarBoton = findViewById(R.id.botonReservar);

        nombre = findViewById(R.id.nombreClienteET);
        telefono = findViewById(R.id.telefonoCliente);

        ConnectivityManager con = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = con.getActiveNetworkInfo();


            tipoSesion.setText(getIntent().getStringExtra("nombre"));
        fechaET.setOnClickListener(this);

        resquest = Volley.newRequestQueue(this);

        reservarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectivityManager con = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo info = con.getActiveNetworkInfo();

                if (info != null && info.isConnected()) {

                    if(tipoSesion.getText().toString().trim().equals("")||fechaET.getText().toString().trim().equals("")){
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Insertar_Reservaciones.this);
                        alertDialog.setTitle("Advertencia");
                        alertDialog.setMessage("No se permite vacíos");
                        alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        alertDialog.setIcon(R.drawable.logoblancobajacalidad);
                        alertDialog.show();
                    }else{
                        cargarWebService();
                    Intent intent = new Intent(Insertar_Reservaciones.this, ReservarSesion.class);
                    startActivity(intent);
                    finish();

                } }else {
                    Snackbar.make(view, "No hay conexión a Internet", Snackbar.LENGTH_SHORT).show();
                }
            }

        });



    }

    private void cargarWebService() {

        progreso = new ProgressDialog(Insertar_Reservaciones.this);
        progreso.setMessage("Cargando...");
        progreso.show();

           String url = "https://teampro.000webhostapp.com/ws_teampro/insertarReservaciones.php?tipo_sesion="
                   +tipoSesion.getText().toString()+"&fecha_sesion="
                   +fechaET.getText().toString()+"&nombre=" + nombre.getText().toString()
                   +"&telefono=" + telefono.getText().toString();

       url =  url.replace(" ","%20");

           jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
           resquest.add(jsonObjectRequest);

    }


    @Override
    public void onClick(View view) {
        if(view== fechaET){
            final Calendar calendar =  Calendar.getInstance() ;

            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            anio = calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    fechaET.setText(i2+ "-" +i1 +"-" + i);
                }
            }


            ,anio,mes,dia);
            datePickerDialog.show();
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {
       progreso.hide();
        Toast.makeText(this, "No se puedo Registrar" + error.toString(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(this, "Se inserto Correctamente", Toast.LENGTH_SHORT).show();
        progreso.hide();
        nombre.setText("");
        tipoSesion.setText("");
        fechaET.setText("");
        telefono.setText("");

    }


}
