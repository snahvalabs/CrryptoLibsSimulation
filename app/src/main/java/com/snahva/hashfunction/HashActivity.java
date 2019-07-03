package com.snahva.hashfunction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HashActivity extends AppCompatActivity {
    Button btn_Hash;
    EditText input_ed;
    TextView tvMD5, tvSHA1, tvSHA256, tvSHA384, tvSHA512;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        input_ed.addTextChangedListener(onTextChangedListener());
    }

    private TextWatcher onTextChangedListener() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                doHashOtomatis();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }

    private void initUI(){
        btn_Hash = findViewById(R.id.btnHash);
        input_ed = findViewById(R.id.edtInput);
        tvMD5 = findViewById(R.id.txtMD5);
        tvSHA1 = findViewById(R.id.txtSHA1);
        tvSHA256 = findViewById(R.id.txtSHA256);
        tvSHA384 = findViewById(R.id.txtSHA384);
        tvSHA512 = findViewById(R.id.txtSHA512);
    }

    public void doHashOtomatis() {
        CryptoLibs cl = new CryptoLibs();
        cl.setInput(input_ed.getText().toString());
        cl.setAlgorithm("MD5");
        cl.generateHash();
        tvMD5.setText(cl.getOutput());

        cl.setAlgorithm("SHA1");
        cl.generateHash();
        tvSHA1.setText(cl.getOutput());

        cl.setAlgorithm("SHA256");
        cl.generateHash();
        tvSHA256.setText(cl.getOutput());

        cl.setAlgorithm("SHA384");
        cl.generateHash();
        tvSHA384.setText(cl.getOutput());

        cl.setAlgorithm("SHA512");
        cl.generateHash();
        tvSHA512.setText(cl.getOutput());
    }

    public void doHash(View view) {
        CryptoLibs cl = new CryptoLibs();
        cl.setInput(input_ed.getText().toString());
        cl.setAlgorithm("MD5");
        cl.generateHash();
        tvMD5.setText(cl.getOutput());

        cl.setAlgorithm("SHA1");
        cl.generateHash();
        tvSHA1.setText(cl.getOutput());

        cl.setAlgorithm("SHA256");
        cl.generateHash();
        tvSHA256.setText(cl.getOutput());

        cl.setAlgorithm("SHA384");
        cl.generateHash();
        tvSHA384.setText(cl.getOutput());

        cl.setAlgorithm("SHA512");
        cl.generateHash();
        tvSHA512.setText(cl.getOutput());

//
//        byte[] bytRandom = cl.secretKeyGen(16, input_ed.getText().toString());
//        String strRandom = Base64.encodeToString(bytRandom,Base64.DEFAULT);
//        Log.d("--RNG-- : ", strRandom);

    }
}
