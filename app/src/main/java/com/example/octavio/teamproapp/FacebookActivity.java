package com.example.octavio.teamproapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class FacebookActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);

        setTitle("Facebook");


        final ProgressBar facebookPB = findViewById(R.id.progressBarFace);
        facebookPB.setMax(100);
        facebookPB.setVisibility(View.GONE);


        WebView facebookWV = findViewById(R.id.facebookwebView);
        WebSettings settings = facebookWV.getSettings();
        facebookWV.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                facebookPB.setProgress(newProgress);
                if(newProgress==100){
                    facebookPB.setVisibility(View.GONE);
                }else{
                    facebookPB.setVisibility(View.VISIBLE);
                }

            }
        });
        settings.setJavaScriptEnabled(true);
        facebookWV.loadUrl("https://www.facebook.com/teampro2018/?ref=br_rs");
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
}
