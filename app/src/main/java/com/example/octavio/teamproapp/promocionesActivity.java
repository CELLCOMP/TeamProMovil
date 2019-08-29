package com.example.octavio.teamproapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

public class promocionesActivity extends AppCompatActivity {

    RecyclerView recyclerViewPromocionesActivity;
    ArrayList<PromocionesVo> listaPromociones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones);

        listaPromociones = new ArrayList<>();
        recyclerViewPromocionesActivity = findViewById(R.id.recyclerPromocionesActivity);
        recyclerViewPromocionesActivity.setLayoutManager(new LinearLayoutManager(this));
        Adaptador_promociones adaptador_promociones = new Adaptador_promociones(listaPromociones);
        recyclerViewPromocionesActivity.setAdapter(adaptador_promociones);
        llenarPromociones();

    }

    private void llenarPromociones() {
        listaPromociones.add(new PromocionesVo("Fotografías", "15 Fotografias Digitales por LPS.1500"));
        listaPromociones.add(new PromocionesVo("Fotografías", "10 Fotografias Digitales por LPS.900"));
        listaPromociones.add(new PromocionesVo("Fotografías", "25 Fotografias Digitales por LPS.2000"));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
