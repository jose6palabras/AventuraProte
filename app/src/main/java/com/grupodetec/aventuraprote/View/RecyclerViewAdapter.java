package com.grupodetec.aventuraprote.View;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.grupodetec.aventuraprote.R;

import java.util.List;

/**
 * Created by android on 17/12/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.cardViewViewHolder> {
    List <CardViewModel> cardViewModels;

    public RecyclerViewAdapter(List<CardViewModel> cardViewModels) {
        this.cardViewModels = cardViewModels;
    }

    @Override
    public cardViewViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_model, viewGroup, false);
        cardViewViewHolder cardViewViewHolderobj = new cardViewViewHolder(view);
        return cardViewViewHolderobj;
    }

    @Override
    public void onBindViewHolder(cardViewViewHolder holder, int position) {
        holder.imageView.setImageResource(cardViewModels.get(position).photo_id);
        holder.textViewname.setText(cardViewModels.get(position).name);
        holder.textViewlocal.setText(cardViewModels.get(position).local);
    }

    @Override
    public int getItemCount() {
        return cardViewModels.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class cardViewViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        TextView textViewname;
        TextView textViewlocal;

        public cardViewViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.modelCardView);
            imageView = (ImageView) itemView.findViewById(R.id.cardviewpicture);
            textViewname = (TextView) itemView.findViewById(R.id.cardviewname);
            textViewlocal = (TextView) itemView.findViewById(R.id.cardviewlocal);
        }
    }
}
