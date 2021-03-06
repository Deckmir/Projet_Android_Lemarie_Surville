package com.example.nicolassurville.projet_android_lemarie_surville.Activity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
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

import static com.example.nicolassurville.projet_android_lemarie_surville.Activity.MainActivity.classe;

public class SelectionChamanActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView Sort;
    private CardView Serviteur;
    public static String choix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_chaman);
        Sort=(CardView)findViewById(R.id.Sort);
        Serviteur=(CardView)findViewById(R.id.Serviteur);
        Sort.setOnClickListener(this);
        Serviteur.setOnClickListener(this);
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
                Toast.makeText(SelectionChamanActivity.this, R.string.message_quit, Toast.LENGTH_LONG).show();
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void settings() {
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
        switch (item.getItemId()) {

            case R.id.action_settings:
                settings();
                return true;
            case R.id.action_quit:
                quit();
                return true;
            case R.id.action_notification:
                notificationcall();
                return true;


            case R.id.action_home:
                Intent intent;
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            case R.id.action_internet:
                // 1. Appeler une URL web
                String url = "https://playhearthstone.com/fr-fr/?utm_term=hearthstone&utm_source=google&utm_medium=cpc&utm_content=33938835611&utm_campaign=MEC_444951971&gclid=CjwKCAjwiurXBRAnEiwAk2GFZu1KDw1Lk1PNEo0a5gDv9oMQg-4rCBL5maAnOpSfd8taGi_fU48a1xoCG9QQAvD_BwE";
                Intent intent1 = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
                startActivity(intent1);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){
            case(R.id.Sort):
                choix="sort";
                switch (classe){
                    case("Chaman"):intent = new Intent(this, ChamanActivity.class);
                        startActivity(intent);
                        break;
                    case("Chasseur"):intent = new Intent(this, ChasseurActivity.class);
                        startActivity(intent);
                        break;
                    case("Druide"):intent = new Intent(this, DruideActivity.class);
                        startActivity(intent);
                        break;
                    case("Demoniste"):intent = new Intent(this, DemonisteActivity.class);
                        startActivity(intent);
                        break;
                    case("Guerrier"):intent = new Intent(this, GuerrierActivity.class);
                        startActivity(intent);
                        break;
                    case("Paladin"):intent = new Intent(this, PaladinActivity.class);
                        startActivity(intent);
                        break;
                    case("Pretre"):intent = new Intent(this, PretreActivity.class);
                        startActivity(intent);
                        break;
                    case("Mage"):intent = new Intent(this, MageActivity.class);
                        startActivity(intent);
                        break;
                    case("Voleur"):intent = new Intent(this, VoleurActivity.class);
                        startActivity(intent);
                        break;
                }
                break;


            case(R.id.Serviteur):
                choix="serviteur";
                switch (classe){
                    case("Chaman"):intent = new Intent(this, ChamanActivity.class);
                        startActivity(intent);
                        break;
                    case("Chasseur"):intent = new Intent(this, ChasseurActivity.class);
                        startActivity(intent);
                        break;
                    case("Druide"):intent = new Intent(this, DruideActivity.class);
                        startActivity(intent);
                        break;
                    case("Demoniste"):intent = new Intent(this, DemonisteActivity.class);
                        startActivity(intent);
                        break;
                    case("Guerrier"):intent = new Intent(this, GuerrierActivity.class);
                        startActivity(intent);
                        break;
                    case("Paladin"):intent = new Intent(this, PaladinActivity.class);
                        startActivity(intent);
                        break;
                    case("Pretre"):intent = new Intent(this, PretreActivity.class);
                        startActivity(intent);
                        break;
                    case("Mage"):intent = new Intent(this, MageActivity.class);
                        startActivity(intent);
                        break;
                    case("Voleur"):intent = new Intent(this, VoleurActivity.class);
                        startActivity(intent);
                        break;
                }
                break;
            default:
                break;
        }
    }
}

