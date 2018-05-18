package com.example.nicolassurville.projet_android_lemarie_surville.Activity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.nicolassurville.projet_android_lemarie_surville.Cards.Card_Services;
import com.example.nicolassurville.projet_android_lemarie_surville.Cards.Cards;
import com.example.nicolassurville.projet_android_lemarie_surville.Cards.CardsAdapter;
import com.example.nicolassurville.projet_android_lemarie_surville.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.nicolassurville.projet_android_lemarie_surville.Activity.SelectionChamanActivity.choix;

public class DemonisteActivity extends AppCompatActivity {


    private RecyclerView rv;
    public static final String HEARTHSTONE_UPDATE = "https://raw.githubusercontent.com/Deckmir/Projet_Android_Lemarie_Surville/master/cardsDemoniste.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Cards> jeu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demoniste);


        jeu = new ArrayList<>();


        rv = (RecyclerView) findViewById(R.id.rv_demoniste);
        lancement_JSON();
    }
    private void lancement_JSON(){

        request= new JsonArrayRequest(HEARTHSTONE_UPDATE, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);


                        Cards cards = new Cards();


                        if(choix.equals("serviteur")){
                            if(jsonObject.getString("type").equals("Minion" ) || jsonObject.getString("type").equals("Weapon" ) ) {
                                cards.setName(jsonObject.getString("name"));
                                cards.setType(jsonObject.getString("type"));
                                cards.setRare(jsonObject.getString("rarity"));
                                cards.setCout(jsonObject.getString("cost"));
                                cards.setAttaque(jsonObject.getString("attack"));
                                cards.setPoint_de_vie(jsonObject.getString("health"));
                                cards.setDescription(jsonObject.getString("text"));
                                cards.setclasse(jsonObject.getString("playerClass"));
                                cards.setImage_url(jsonObject.getString("img"));
                                cards.setRace(jsonObject.getString("race"));
                                jeu.add(cards);
                            }
                        }
                        if(choix.equals("sort")){
                            if(jsonObject.getString("type").equals("Spell" )  ) {
                                cards.setName(jsonObject.getString("name"));
                                cards.setType(jsonObject.getString("type"));
                                cards.setRare(jsonObject.getString("rarity"));
                                cards.setCout(jsonObject.getString("cost"));
                                cards.setDescription(jsonObject.getString("text"));
                                cards.setclasse(jsonObject.getString("playerClass"));
                                cards.setImage_url(jsonObject.getString("img"));
                                jeu.add(cards);
                            }
                        } } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setuprecyclerview(jeu);

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(DemonisteActivity.this);
        requestQueue.add(request);

    }
    private void setuprecyclerview( List<Cards> jeu){

        CardsAdapter myadapter = new CardsAdapter(this,jeu);
        rv.setLayoutManager(new LinearLayoutManager(this));

        rv.setAdapter((myadapter));
    }


    private void quit(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(R.string.message);
        alertDialogBuilder.setPositiveButton(R.string.message_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });
        alertDialogBuilder.setNegativeButton(R.string.message_yes,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DemonisteActivity.this,R.string.message_quit,Toast.LENGTH_LONG).show();
                finish();
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
}