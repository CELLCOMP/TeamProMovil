package com.example.octavio.teamproapp;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,ImplementacionesFragments{

    private TextView textViewBusqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags &= (~WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getWindow().setAttributes(attrs);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = new categoriasFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.content_main, fragment).commit();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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
                Toast.makeText(this,"Informacion",Toast.LENGTH_SHORT).show();
                return  true;

            case R.id.reservarSesion:
                Intent reservarSesion = new Intent(this, ReservarSesion.class);
                startActivity(reservarSesion);
                default:

                return super.onOptionsItemSelected(item);

        }
        }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment miFragment = null;
        boolean fragmentSeleccionado=false;

        if (id == R.id.inicio) {
        miFragment = new categoriasFragment();
        fragmentSeleccionado = true;
        setTitle("Inicio");
        } else if (id == R.id.promocionesDv) {
            miFragment = new promocionesFragment();
            fragmentSeleccionado = true;
            setTitle("Promociones");
        }  else if (id == R.id.contactanos) {
            miFragment = new contactanosFragment();
            fragmentSeleccionado = true;

        } else if (id == R.id.nav_compartir) {
            Intent intentCompartir = new Intent();
            intentCompartir.setAction(Intent.ACTION_SEND);
            intentCompartir.putExtra(Intent.EXTRA_TEXT,"Gracias por compartir nuestra APP, siguenos en Facebook e I" +
                    "nstagram como TeamPro");
            intentCompartir.setType("*/*");
            intentCompartir.putExtra(Intent.CATEGORY_APP_MESSAGING,Intent.EXTRA_TEXT);

            if(intentCompartir.resolveActivity(getPackageManager())!= null){
                startActivity(intentCompartir);
            }

        }else if(id == R.id.quienessomos){
            miFragment = new QuienesSomosFragment();
            fragmentSeleccionado=true;
            setTitle("¿Quiénes Somos?");
        }else if(id == R.id.facebookDV){
            Intent facebookIntent = new Intent(this, FacebookActivity.class);
            startActivity(facebookIntent);
            setTitle("Facebook");
        }
        else if(id == R.id.instagramDv){
            miFragment = new InstagramFragment();
            fragmentSeleccionado = true;
            setTitle("Instagram");
        }
        if(fragmentSeleccionado==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,miFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
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
