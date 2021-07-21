package com.example.pos_laundry.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pos_laundry.LaundryItemListClicked;
import com.example.pos_laundry.Product;
import com.example.pos_laundry.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerLaundryAdapter extends RecyclerView.Adapter<RecyclerLaundryAdapter.ViewHolder>{

    private ArrayList<Product> productArraylist;
    public LaundryItemListClicked itemListerner;

    public RecyclerLaundryAdapter(ArrayList<Product> productArraylist, LaundryItemListClicked itemlistener) {
        this.productArraylist = productArraylist;
        this.itemListerner = itemlistener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView priceview;
        private final ImageView laundryview;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            priceview = view.findViewById(R.id.priceView);
            laundryview = view.findViewById(R.id.imageView);

        }



        public TextView getPriceview() {
            return priceview;
        }

        public ImageView getLaundryview() {
            return laundryview;
        }


        @Override
        public void onClick(View v) {
            Log.i("Click", "Click listener..:");
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.laundryitem, viewGroup, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerLaundryAdapter.ViewHolder holder, int position) {

        Product product = productArraylist.get(position);
        holder.getPriceview().setText(String.valueOf(product.getPrice()));

        holder.getPriceview().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Click", "Click listener.....");
                itemListerner.LaundryItemListClicked(position);
            }
        });

        holder.getLaundryview().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Click", "Click listener.....");
                itemListerner.LaundryItemListClicked(position);


            }
        });


    }



    @Override
    public int getItemCount() {
        return productArraylist.size();
    }
}
