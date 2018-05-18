package com.example.nicolassurville.projet_android_lemarie_surville.Activity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.nicolassurville.projet_android_lemarie_surville.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView Chaman;
    private CardView Chasseur;
    private CardView Demoniste;
    private CardView Druide;
    private CardView Guerrier;
    private CardView Mage;
    private CardView Paladin;
    private CardView Pretre;
    private CardView Voleur;
    private CardView Legendaire;
    public static String classe;
    public static MediaPlayer mySong= null;
    public static MediaPlayer voicechaman= null;
    public static MediaPlayer voicechasseur= null;
    public static MediaPlayer voicedemoniste= null;
    public static MediaPlayer voicedruide= null;
    public static MediaPlayer voiceguerrier= null;
    public static MediaPlayer voicemage= null;
    public static MediaPlayer voicepaladin= null;
    public static MediaPlayer voicepretre= null;
    public static MediaPlayer voicevoleur= null;
    public static MediaPlayer voicelegendaire= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Chaman = (CardView) findViewById(R.id.Chaman);
        Chasseur = (CardView) findViewById(R.id.Chasseur);
        Demoniste = (CardView) findViewById(R.id.Demoniste);
        Druide = (CardView) findViewById(R.id.Druide);
        Guerrier = (CardView) findViewById(R.id.Guerrier);
        Mage = (CardView) findViewById(R.id.Mage);
        Paladin = (CardView) findViewById(R.id.Paladin);
        Pretre = (CardView) findViewById(R.id.Pretre);
        Voleur = (CardView) findViewById(R.id.Voleur);
        Legendaire = (CardView) findViewById(R.id.Legendaire);

        Chaman.setOnClickListener(this);
        Chasseur.setOnClickListener(this);
        Demoniste.setOnClickListener(this);
        Druide.setOnClickListener(this);
        Guerrier.setOnClickListener(this);
        Mage.setOnClickListener(this);
        Paladin.setOnClickListener(this);
        Pretre.setOnClickListener(this);
        Voleur.setOnClickListener(this);
        Legendaire.setOnClickListener(this);
        if(mySong == null) {
            mySong = MediaPlayer.create(getApplicationContext(), R.raw.hearthstone);
            if(!mySong.isPlaying()){
                mySong.start();
                mySong.setLooping(true);
            }
        }

    }





    private void quit() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(R.string.message);
        alertDialogBuilder.setPositiveButton(R.string.message_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });
        alertDialogBuilder.setNegativeButton(R.string.message_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, R.string.message_quit, Toast.LENGTH_LONG).show();
                finish();
                mySong.stop();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void settings(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(R.string.message_settings);
        alertDialogBuilder.setPositiveButton(R.string.message_gotit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    public void notificationcall () {
        NotificationCompat.Builder notificationBuider = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setSmallIcon(R.drawable.ic_info_black_24dp)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.hs_logo))
                .setContentTitle("Notification ")
                .setContentText("Application 2018 created by Maxime & Nicolas.");

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notificationBuider.build());

    }

    //gère le click sur une action de l'ActionBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.action_settings:
                settings();
                return true;
            case R.id.action_quit:
                quit();
                return true;
            case R.id.action_notification:
                notificationcall();
                return true;
            case R.id.action_internet:
                // 1. Appeler une URL web
                String url = "https://playhearthstone.com/fr-fr/?utm_term=hearthstone&utm_source=google&utm_medium=cpc&utm_content=33938835611&utm_campaign=MEC_444951971&gclid=CjwKCAjwiurXBRAnEiwAk2GFZu1KDw1Lk1PNEo0a5gDv9oMQg-4rCBL5maAnOpSfd8taGi_fU48a1xoCG9QQAvD_BwE";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
                startActivity(intent);
                return true;
            case R.id.action_home:
                    return true;
        }

        return super.onOptionsItemSelected(item);
    }


        @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){
            case(R.id.Chaman):
                classe="Chaman";
                intent = new Intent(this, SelectionChamanActivity.class);
                voicechaman = MediaPlayer.create(getApplicationContext(), R.raw.chaman);
                voicechaman.start();
                 startActivity(intent);
                 break;
            case(R.id.Chasseur):
                classe="Chasseur";
                intent = new Intent(this,  SelectionChamanActivity.class);
                voicechasseur = MediaPlayer.create(getApplicationContext(), R.raw.chasseur);
                voicechasseur.start();
                startActivity(intent);
                break;
            case(R.id.Demoniste):
                classe="Demoniste";
                intent = new Intent(this,  SelectionChamanActivity.class);
                voicedemoniste = MediaPlayer.create(getApplicationContext(), R.raw.demoniste);
                voicedemoniste.start();
                startActivity(intent);
                break;
            case(R.id.Druide):
                classe="Druide";
                intent = new Intent(this,  SelectionChamanActivity.class);
                voicedruide = MediaPlayer.create(getApplicationContext(), R.raw.druide);
                voicedruide.start();
                startActivity(intent);
                break;
            case(R.id.Guerrier):
                classe="Guerrier";
                intent = new Intent(this,  SelectionChamanActivity.class);
                voiceguerrier = MediaPlayer.create(getApplicationContext(), R.raw.guerrier);
                voiceguerrier.start();
                startActivity(intent);
                break;
            case(R.id.Mage):
                classe="Mage";
                intent = new Intent(this,  SelectionChamanActivity.class);
                    voicemage = MediaPlayer.create(getApplicationContext(), R.raw.mage);
                        voicemage.start();
                startActivity(intent);
                break;
            case(R.id.Paladin):
                classe="Paladin";
                intent = new Intent(this, SelectionChamanActivity.class);
                voicepaladin = MediaPlayer.create(getApplicationContext(), R.raw.paladin);
                voicepaladin.start();
                startActivity(intent);
                break;
            case(R.id.Pretre):
                classe="Pretre";
                intent = new Intent(this,  SelectionChamanActivity.class);
                voicepretre = MediaPlayer.create(getApplicationContext(), R.raw.pretre);
                voicepretre.start();
                startActivity(intent);
                break;
            case(R.id.Voleur):
                classe="Voleur";
                intent = new Intent(this,  SelectionChamanActivity.class);
                voicevoleur = MediaPlayer.create(getApplicationContext(), R.raw.voleur);
                voicevoleur.start();
                startActivity(intent);
                break;
            case(R.id.Legendaire):
                intent=new Intent(this, LegendaireActivity.class);
                voicelegendaire = MediaPlayer.create(getApplicationContext(), R.raw.leg_dore);
                voicelegendaire.start();
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
