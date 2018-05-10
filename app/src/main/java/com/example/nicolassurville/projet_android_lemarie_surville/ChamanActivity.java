package com.example.nicolassurville.projet_android_lemarie_surville;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ChamanActivity extends AppCompatActivity {


    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chaman);

        Button btn = (Button) findViewById(R.id.ButtonSecondView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentFilter intentFilter = new IntentFilter(HEARTHSTONE_UPDATE);
                LocalBroadcastManager.getInstance(ChamanActivity.this).registerReceiver(new CardUpdate(), intentFilter);
                Card_Services.startActionCards(ChamanActivity.this);

            }
        });

        rv = (RecyclerView) findViewById(R.id.rv_chaman);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new CardsAdapter(getCardsFromFile()));
    }


    public static final String HEARTHSTONE_UPDATE = "com.example.nicolassurville.projet_android_lemarie_surville.HEARTHSTONE_UPDATE";

    public class CardUpdate extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("tag", "OnReceive");
            CardsAdapter adapter = (CardsAdapter) rv.getAdapter();

            adapter.setNewCards(getCardsFromFile());


        }
    }

    public JSONArray getCardsFromFile() {
        try {
            InputStream is = new FileInputStream(getCacheDir() + "/" + "Hearthstone.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            JSONArray test = new JSONArray(new String(buffer,"utf-8"));
            int length = test.length();

            Log.d("tag", "Longueur : " + Integer.toString(length));
            return test; // construction du tableau
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new JSONArray();
    }
}