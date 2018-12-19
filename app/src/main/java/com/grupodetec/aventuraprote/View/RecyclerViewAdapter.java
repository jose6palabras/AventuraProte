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

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.cardViewViewHolder> implements View.OnClickListener {
    private List <CardViewModel> cardViewModels;
    private int resource;
    private View.OnClickListener listener;

    public RecyclerViewAdapter(List<CardViewModel> cardViewModels, int resource) {
        this.cardViewModels = cardViewModels;
        this.resource = resource;
    }

    @Override
    public cardViewViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(resource, viewGroup, false);
        cardViewViewHolder cardViewViewHolderobj = new cardViewViewHolder(view);
        view.setOnClickListener(this);
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


    public void setOnClickListener(View.OnClickListener listener){this.listener = listener;}

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }

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
