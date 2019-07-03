package com.snahva.hashfunction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;

public class RNGActivity extends AppCompatActivity {
    EditText edRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rng);

        edRandom = findViewById(R.id.txtRandom);
    }

    public void doGenerate(View view){
        String strOutputRandom;
        byte[] bytOutputRandom;

        CryptoLibs mCryptoLibs = new CryptoLibs();

        //Cara 1
        bytOutputRandom = mCryptoLibs.generateRandomKey();

        //Cara 2
        bytOutputRandom = mCryptoLibs.generateRandomKey(64);

        //Cara 3
        String strSeed = "ini seed";
        bytOutputRandom = mCryptoLibs.generateRandomKey(64,strSeed);

        strOutputRandom = Base64.encodeToString(bytOutputRandom,Base64.DEFAULT);

        edRandom.setText(strOutputRandom);
    }
}
