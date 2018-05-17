package com.example.nicolassurville.projet_android_lemarie_surville.Cards;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.nicolassurville.projet_android_lemarie_surville.Activity.SecondActivity;
import com.example.nicolassurville.projet_android_lemarie_surville.R;

import java.util.List;


public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardHolder> {


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
        final CardHolder cardHolder = new CardHolder(view);
        cardHolder.Lin_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, SecondActivity.class);
                intent.putExtra("name",cards.get(cardHolder.getAdapterPosition()).getName());
                intent.putExtra("playerClass",cards.get(cardHolder.getAdapterPosition()).getclasse());
                intent.putExtra("img",cards.get(cardHolder.getAdapterPosition()).getImage_url());
                intent.putExtra("cost",cards.get(cardHolder.getAdapterPosition()).getCout());
                intent.putExtra("health",cards.get(cardHolder.getAdapterPosition()).getPoint_de_vie());
                intent.putExtra("attack",cards.get(cardHolder.getAdapterPosition()).getAttaque());
                intent.putExtra("race",cards.get(cardHolder.getAdapterPosition()).getRace());
                intent.putExtra("rarity",cards.get(cardHolder.getAdapterPosition()).getRare());
                intent.putExtra("type",cards.get(cardHolder.getAdapterPosition()).getType());
                intent.putExtra("text", cards.get(cardHolder.getAdapterPosition()).getDescription());

                mContext.startActivity(intent);
            }
        });



        return cardHolder;
    }

    @Override
    public void onBindViewHolder(CardHolder holder, int position) {

        holder.tv_name.setText(cards.get(position).getName());



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
        ImageView img_URL;
        LinearLayout Lin_container;

        public CardHolder(View itemView) {
            super(itemView);
            Lin_container= itemView.findViewById(R.id.container);
            tv_name = (TextView) itemView.findViewById(R.id.rv_card_name);
            img_URL = itemView.findViewById(R.id.rv_img);


        }




    }
}
