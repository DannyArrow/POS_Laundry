package com.example.pos_laundry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;

import com.squareup.sdk.pos.ChargeRequest;
import com.squareup.sdk.pos.CurrencyCode;
import com.squareup.sdk.pos.PosClient;
import com.squareup.sdk.pos.PosSdk;

public class PointOfSaleActivity extends AppCompatActivity {
    private static final String APPLICATION_ID = "sq0idp-hkBGtO0llqykOawA0IO-bA";
    private PosClient posClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        posClient = PosSdk.createClient(this, APPLICATION_ID);
    }
    private static final int CHARGE_REQUEST_CODE = 1;
    
    public void startTransaction(int TotalAmount) {
        ChargeRequest request = new ChargeRequest.Builder(
                TotalAmount,
                CurrencyCode.USD)
                .build();
        try {
            Intent intent = posClient.createChargeIntent(request);
            startActivityForResult(intent, CHARGE_REQUEST_CODE);

        } catch (ActivityNotFoundException e) {
            AlertDialogHelper.showDialog(
                    this,
                    "Error",
                    "Square Point of Sale is not installed"
            );
            posClient.openPointOfSalePlayStoreListing();
        }
    }
}