package com.example.nicolassurville.projet_android_lemarie_surville.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

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

