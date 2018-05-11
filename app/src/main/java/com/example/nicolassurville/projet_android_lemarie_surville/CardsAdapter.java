package com.example.nicolassurville.projet_android_lemarie_surville;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.zip.Inflater;


class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardHolder> {


    private Context mContext;
    private List<Cards> cards;
    RequestOptions option;

    public CardsAdapter(Context mContext, List<Cards> cards) {
        this.mContext = mContext;
        this.cards = cards;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.legendaire).error(R.drawable.legendaire);
    }

    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_card_element,parent,false);
        return new CardHolder(view);
    }

    @Override
    public void onBindViewHolder(CardHolder holder, int position) {

        holder.tv_name.setText(cards.get(position).getName());
        holder.tv_cardClass.setText(cards.get(position).getclasse());


        Glide.with(mContext).load(cards.get(position).getImage_url()).apply(option).into(holder.img_URL);


    }



    @Override
    public int getItemCount() {
        return cards.size();
    }

    public void setNewCards(List<Cards> cards){
        this.cards = cards;
        notifyDataSetChanged();
    }



    public class CardHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_cardClass;
        ImageView img_URL;
       // private final TextView cost;

        public CardHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.rv_card_name);
            tv_cardClass = (TextView) itemView.findViewById(R.id.rv_playerClass);
            img_URL = itemView.findViewById(R.id.rv_img);
    //        cost = (TextView) itemView.findViewById(R.id.rv_cost);
        }




    }
}
