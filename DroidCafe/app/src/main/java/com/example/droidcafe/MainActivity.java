package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity<Pubic, Public> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

    }

    public void donetClick(View view) {
        displayToast(getString(R.string.donet_are_super));
    }

    public void icecreamClick(View view) {
        displayToast(getString(R.string.icecream_are_supe));
    }

    public void cakeClick(View view) {
        displayToast(getString(R.string.caketxt));
    }

    public void shoppingFAB(View view) {

        Intent intent =  new Intent(MainActivity.this,OrderActivity.class);
        startActivity(intent);
    }
}