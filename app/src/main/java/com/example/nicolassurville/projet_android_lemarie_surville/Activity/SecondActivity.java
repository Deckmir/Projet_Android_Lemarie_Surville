package com.example.nicolassurville.projet_android_lemarie_surville.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.nicolassurville.projet_android_lemarie_surville.R;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String name =getIntent().getExtras().getString("name");
        String attaque =getIntent().getExtras().getString("attack");
        String vie =getIntent().getExtras().getString("health");
        String cout =getIntent().getExtras().getString("cost");
        String classe =getIntent().getExtras().getString("playerClass");
        String race =getIntent().getExtras().getString("race");
        String img_url =getIntent().getExtras().getString("img");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing);
        collapsingToolbarLayout.setTitleEnabled(true);

       // TextView tv_name = findViewById(R.id.collapsing);
        TextView tv_attaque = findViewById(R.id.p_attaque);
        TextView tv_vie=findViewById(R.id.p_vie);
        TextView tv_cout=findViewById(R.id.p_cout);
        TextView tv_classe=findViewById(R.id.p_classe);
        TextView tv_race=findViewById(R.id.p_race);
        ImageView iv_img=findViewById(R.id.p_img);


        //tv_name.setText(name);
        tv_attaque.setText(attaque);
        tv_vie.setText(vie);
        tv_cout.setText(cout);
        tv_classe.setText(classe);
        tv_race.setText(race);

        Glide.with(this).load(img_url).into(iv_img);

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
                Toast.makeText(SecondActivity.this, R.string.message_quit, Toast.LENGTH_LONG).show();
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void settings() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(R.string.add_notification);
        alertDialogBuilder.setPositiveButton(R.string.message_gotit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    private void search() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(R.string.add_notification);
        alertDialogBuilder.setPositiveButton(R.string.message_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });
        alertDialogBuilder.setNegativeButton(R.string.message_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SecondActivity.this, R.string.message_notif, Toast.LENGTH_LONG).show();

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
                search();
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