package com.example.octavio.teamproapp;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class contactanosActivity extends AppCompatActivity {

    Button enviar;
    ImageButton whatsapp,facebook,llamada;
    EditText nombre,correo,contenidoCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactanos);
        enviar = findViewById(R.id.buttonEnviarActivity);
        nombre = findViewById(R.id.nombreETActivity);

        contenidoCorreo = findViewById(R.id.contenidoETActivity);

        whatsapp=  findViewById(R.id.whatsappbuttonACtivity);
        facebook = findViewById(R.id.facebookbuttonActivity);
        llamada = findViewById(R.id.telefonoButtonActivity);

    }

    public void enviarCorreo(View view) {
        String[]email = new String[]{"octaviogamerofa@gmail.com"};
        String subject = new String("Cotización, Opinión de la App, etc.");
        String mensaje =nombre.getText().toString()+ " " + contenidoCorreo.getText().toString();
        escribirCorreo(email,subject,mensaje);

    }

    private void escribirCorreo(String[] email, String subject, String mensaje) {

        Intent intentEnviarCorreo = new Intent(Intent.ACTION_SEND);
        intentEnviarCorreo.setType("*/*");

        intentEnviarCorreo.putExtra(Intent.EXTRA_SUBJECT,subject);
        intentEnviarCorreo.putExtra(Intent.EXTRA_EMAIL,email);
        intentEnviarCorreo.putExtra(Intent.EXTRA_TEXT,mensaje);
        startActivity(intentEnviarCorreo);
    }


    public void facebookOnClick(View view) {
        Uri uri = Uri.parse("https://www.facebook.com/teampro2018/?ref=br_rs");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    public void llamadaIntent(View view) {
        Intent intentLlamada = new Intent(Intent.ACTION_DIAL);
        intentLlamada.setData(Uri.parse("tel:95344931"));
        startActivity(intentLlamada);
    }


    public void whatsappOnClick(View view) {
        try {

            Intent sendIntent = new Intent();
            sendIntent.putExtra(Intent.EXTRA_TEXT, "TEAMPRO Descargala en PlayStore");
            sendIntent.setType("text/plain");
            sendIntent.setPackage("com.gbwhatsapp");
            startActivity(sendIntent);

        }catch (Exception e){
            e.getStackTrace();
        }
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
