package com.example.nicolassurville.projet_android_lemarie_surville.Activity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
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

import java.io.IOException;

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
    MediaPlayer mySong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Chaman=(CardView) findViewById(R.id.Chaman);
        Chasseur=(CardView)findViewById(R.id.Chasseur);
        Demoniste=(CardView)findViewById(R.id.Demoniste);
        Druide=(CardView)findViewById(R.id.Druide);
        Guerrier=(CardView)findViewById(R.id.Guerrier);
        Mage = (CardView)findViewById(R.id.Mage);
        Paladin=(CardView)findViewById(R.id.Paladin);
        Pretre =(CardView)findViewById(R.id.Pretre);
        Voleur=(CardView)findViewById(R.id.Voleur);

        Chaman.setOnClickListener(this);
        Chasseur.setOnClickListener(this);
        Demoniste.setOnClickListener(this);
        Druide.setOnClickListener(this);
        Guerrier.setOnClickListener(this);
        Mage.setOnClickListener(this);
        Paladin.setOnClickListener(this);
        Pretre.setOnClickListener(this);
        Voleur.setOnClickListener(this);
        mySong=MediaPlayer.create(MainActivity.this,R.raw.hearthstone );
        mySong.start();

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
                .setSmallIcon(R.drawable.ic_file_download_black_24dp)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.hs_logo))
                .setBadgeIconType(R.drawable.ic_file_download_black_24dp)
                .setContentTitle("Notification ")
                .setContentText("Téléchargement terminé.");

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
            case R.id.action_internet:
                // 1. Appeler une URL web
                String url = "https://playhearthstone.com/fr-fr/?utm_term=hearthstone&utm_source=google&utm_medium=cpc&utm_content=33938835611&utm_campaign=MEC_444951971&gclid=CjwKCAjwiurXBRAnEiwAk2GFZu1KDw1Lk1PNEo0a5gDv9oMQg-4rCBL5maAnOpSfd8taGi_fU48a1xoCG9QQAvD_BwE";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
                startActivity(intent);
                return true;
            case R.id.action_home:
                    notificationcall();
                    return true;
        }

        return super.onOptionsItemSelected(item);
    }


        @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){
            case(R.id.Chaman):
                intent = new Intent(this, ChamanActivity.class);
                 startActivity(intent);
                 break;
            case(R.id.Chasseur):
                intent = new Intent(this, ChasseurActivity.class);
                startActivity(intent);
                break;
            case(R.id.Demoniste):
                intent = new Intent(this, DemonisteActivity.class);
                startActivity(intent);
                break;
            case(R.id.Druide):
                intent = new Intent(this, DruideActivity.class);
                startActivity(intent);
                break;
            case(R.id.Guerrier):
                intent = new Intent(this, GuerrierActivity.class);
                startActivity(intent);
                break;
            case(R.id.Mage):
                intent = new Intent(this, MageActivity.class);
                startActivity(intent);
                break;
            case(R.id.Paladin):
                intent = new Intent(this, PaladinActivity.class);
                startActivity(intent);
                break;
            case(R.id.Pretre):
                intent = new Intent(this, PretreActivity.class);
                startActivity(intent);
                break;
            case(R.id.Voleur):
                intent = new Intent(this, VoleurActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
