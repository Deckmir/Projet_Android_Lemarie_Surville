package com.example.nicolassurville.projet_android_lemarie_surville.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
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

public class DruideActivity extends AppCompatActivity {


    private RecyclerView rv;
    public static final String HEARTHSTONE_UPDATE = "https://raw.githubusercontent.com/Deckmir/Projet_Android_Lemarie_Surville/master/cards.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Cards> jeu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_druide);


        jeu = new ArrayList<>();


        Button btn = (Button) findViewById(R.id.ButtonSecondView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentFilter intentFilter = new IntentFilter(HEARTHSTONE_UPDATE);
                Card_Services.startActionCards(DruideActivity.this);

            }
        });

        rv = (RecyclerView) findViewById(R.id.rv_druide);
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


                        if(jsonObject.getString("playerClass").equals("Druid")) {
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
                    } catch (JSONException e) {
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

        requestQueue = Volley.newRequestQueue(DruideActivity.this);
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
                Toast.makeText(DruideActivity.this,R.string.message_quit,Toast.LENGTH_LONG).show();
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
            case R.id.action_search:
                return true;
            case R.id.action_home:
                Intent intent;
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}