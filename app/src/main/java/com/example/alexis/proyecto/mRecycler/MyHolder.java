package com.example.alexis.proyecto.mRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexis.proyecto.R;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView nameTxt,txtSeries;
    ImageView img;
    ItemClickListener itemClickListener;

    public MyHolder(View itemView) {
        super(itemView);

        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        txtSeries=(TextView) itemView.findViewById(R.id.txtSeries);
        img= (ImageView) itemView.findViewById(R.id.spacecraftImage);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(this.getLayoutPosition());
    }
}