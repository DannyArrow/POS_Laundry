package com.example.pos_laundry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.pos_laundry.Adapter.RecyclerLaundryAdapter;
import com.squareup.sdk.pos.ChargeRequest;
import com.squareup.sdk.pos.CurrencyCode;
import com.squareup.sdk.pos.PosClient;
import com.squareup.sdk.pos.PosSdk;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LaundryItemListClicked{
    private Drawable drawable;
    private Resources res;
    private ArrayList<Product> productArrayList;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private LaundryItemListClicked itemlistener;
    Fragment fragment_checkout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list_pane);
        gridLayoutManager = new GridLayoutManager(this,2);
        gridLayoutManager.setSpanCount(4);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.HORIZONTAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        CreateProductList();
        CreateRecyclerView();


    }



    private void CreateProductList() {
        productArrayList = new ArrayList<>();

        Drawable tide = getResources().getDrawable(R.drawable.ic_launcher_background);
        Product p1 = new Product(0,"Arm and Hammer", (float) 3.49, 0,0,tide);
        Product p2 = new Product(1,"All Cleaner", 2.50f, 0, 0, tide);
        Product p3 = new Product(2,"E Cover", (float) 1.99, 0,0,tide);
        Product p4 = new Product(3,"Tide", (float) 3.49, 0,0,tide);
        Product p5 = new Product(4,"Clorox", (float) 5.99, 0,0,tide);
        Product p6 = new Product(5,"Bleach", (float) 6.50, 0,0,tide);
        Product p7 = new Product(6,"Softner", (float) 8.00, 0,0,tide);
        Product p8 = new Product(7,"Green", (float) 7.50, 0,0,tide);
        Product p9 = new Product(8,"Downy", (float) 3.00, 0,0,tide);


        productArrayList.add(p1);
        productArrayList.add(p2);
        productArrayList.add(p3);
        productArrayList.add(p4);
        productArrayList.add(p5);
        productArrayList.add(p6);
        productArrayList.add(p7);
        productArrayList.add(p8);
        productArrayList.add(p9);
    }



    private void CreateRecyclerView() {
        recyclerView.setLayoutManager(gridLayoutManager);

        // Create adapter passing in the sample user data
        RecyclerLaundryAdapter adapter = new RecyclerLaundryAdapter(productArrayList, this);
        // Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(adapter);
        // Set layout manager to position the items



    }

    @Override
    public void LaundryItemListClicked(int position) {
        Toast.makeText(getApplicationContext(),"Position = "+ position, Toast.LENGTH_LONG).show();
        Log.i("Clicked", "callback listener..");
    }
}