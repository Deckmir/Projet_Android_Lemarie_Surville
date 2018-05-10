package com.example.nicolassurville.projet_android_lemarie_surville;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CardView Chaman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Chaman=(CardView) findViewById(R.id.Chaman);

        Chaman.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId()== R.id.Chaman) {
            intent = new Intent(this, ChamanActivity.class);
            startActivity(intent);
        }
    }
}
