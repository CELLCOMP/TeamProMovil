package com.example.octavio.teamproapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class sesiones extends AppCompatActivity{

    RecyclerView recyclerViewSesiones;
    ArrayList<SesionesVo>listaSesiones;
    TextView tituloSesion;
    Adaptador_Sesiones adaptador_sesiones;
    View.OnClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_sesiones);
        setTitle("Sesiones");

        construirRecycler();



    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void llenarSesiones() {
        listaSesiones.add(new SesionesVo("Boda",R.drawable.bodas));
        listaSesiones.add(new SesionesVo("Familiar",R.drawable.familiar));
        listaSesiones.add(new SesionesVo("Pregnancy",R.drawable.pregnancy));
        listaSesiones.add(new SesionesVo("Pre-Wedding",R.drawable.prewedding));
        listaSesiones.add(new SesionesVo("Bautizos",R.drawable.bautizos));
        listaSesiones.add(new SesionesVo("Aniversario de Bodas",R.drawable.aniversarioboda));
        listaSesiones.add(new SesionesVo("Bebes",R.drawable.bebes));
        listaSesiones.add(new SesionesVo("Catálogo Corporativo",R.drawable.corporativa));
        listaSesiones.add(new SesionesVo("Eventos Sociales",R.drawable.social));
        listaSesiones.add(new SesionesVo("Concierto",R.drawable.concierto));
        listaSesiones.add(new SesionesVo("Cumpleaños",R.drawable.cumpleaneos));
        listaSesiones.add(new SesionesVo("Fiestas",R.drawable.fiestas));
        listaSesiones.add(new SesionesVo("Navideñas",R.drawable.navidenias));
        listaSesiones.add(new SesionesVo("Parejas",R.drawable.parejas));
        listaSesiones.add(new SesionesVo("Pre-Cumpleaños",R.drawable.precumple));
        listaSesiones.add(new SesionesVo("Tomas Aéreas",R.drawable.tomasaereas));
        listaSesiones.add(new SesionesVo("Urbanas",R.drawable.urbanas));


    }

    private void construirRecycler() {
        listaSesiones = new ArrayList<>();
        recyclerViewSesiones = findViewById(R.id.recyclerSesiones);

        if (Utilidades.visualizacion == Utilidades.LIST) {
            recyclerViewSesiones.setLayoutManager(new LinearLayoutManager(this));
            recyclerViewSesiones.setHasFixedSize(true);

        } else {

            recyclerViewSesiones.setLayoutManager(new GridLayoutManager(this, 2));
            recyclerViewSesiones.setHasFixedSize(true);
        }
        llenarSesiones();

         adaptador_sesiones = new Adaptador_Sesiones(listaSesiones,this);
        recyclerViewSesiones.setAdapter(adaptador_sesiones);


    }



    public void onClick(View view){

        switch (view.getId()){
            case R.id.buttonLista: Utilidades.visualizacion=Utilidades.LIST;
                break;
            case R.id.buttonGrid: Utilidades.visualizacion=Utilidades.GRID;
                break;
        }
        construirRecycler();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()){
            case R.id.informacion:
                alertDialog();
                return  true;

            case R.id.reservarSesion:
                Intent reservarSesion = new Intent(this, ReservarSesion.class);
                startActivity(reservarSesion);
            default:

                return super.onOptionsItemSelected(item);

        }
    }
    private void alertDialog() {
        final CharSequence[] opciones = {"Visítanos", "Acerca de"};

        final AlertDialog.Builder alerdialog = new AlertDialog.Builder(this);
        alerdialog.setTitle("Información");
        alerdialog.setIcon(R.drawable.logonegro);
        alerdialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerdialog.setMessage("Gracias por Preferirnos\n\n2018 TEAMPRO Todos los derechos Reservados ");

        alerdialog.show();
    }

}
