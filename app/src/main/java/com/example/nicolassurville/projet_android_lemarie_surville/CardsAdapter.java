package com.example.nicolassurville.projet_android_lemarie_surville;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.zip.Inflater;


class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardHolder> {

    private JSONArray cards;


    public CardsAdapter(JSONArray cards){
        this.cards = cards;
    }


    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_card_element,parent,false);
        return new CardHolder(view);
    }

    @Override
    public void onBindViewHolder(CardHolder holder, int position) {


        try {
            JSONObject obj = cards.getJSONObject(position);
            holder.display(obj);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return cards.length();
    }

    public void setNewCards(JSONArray cards){
        this.cards = cards;
        notifyDataSetChanged();
    }



    public class CardHolder extends ViewHolder {
        private final TextView name;
        private final TextView cardClass;
        private final TextView cost;

        public CardHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.rv_bier_element_name);
            cardClass = (TextView) itemView.findViewById(R.id.creation);
            cost = (TextView) itemView.findViewById(R.id.year);
        }


        public void display(JSONObject obj) {
            try {

                name.setText(obj.getString("name"));
                cardClass.setText(obj.getString("cardClass"));
                cost.setText(obj.getString("cost"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
