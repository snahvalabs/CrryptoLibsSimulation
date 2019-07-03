package com.snahva.hashfunction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void actRandom(View view) {
        Intent intent = new Intent(this,RNGActivity.class);
        startActivity(intent);
    }

    public void actSimmetric(View view) {
        Intent intent = new Intent(this,SymmeticActivity.class);
        startActivity(intent);
    }

    public void actHash(View view) {
        Intent intent = new Intent(this,HashActivity.class);
        startActivity(intent);
    }
}
