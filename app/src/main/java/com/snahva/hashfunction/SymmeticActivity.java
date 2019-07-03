package com.snahva.hashfunction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SymmeticActivity extends AppCompatActivity {
    EditText edInSym, edKunciSym, edOutSym;
    Button btnEncryptSym, btnDecryptSym;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symmetic);

        edInSym = findViewById(R.id.txtInputSym);
        edKunciSym = findViewById(R.id.txtKunciSym);
        edOutSym = findViewById(R.id.txtOutSym);
        btnEncryptSym = findViewById(R.id.btnESym);
        btnDecryptSym = findViewById(R.id.btnDSym);
    }

    public void doEncryptSym(View view) {
        byte[] bytTeksSandi;
        byte[] bytKunci;
        byte[] bytTeksTerang;

        String strKunci = String.valueOf(edKunciSym.getText());
        bytKunci = strKunci.getBytes();

        String strTeksTerang = String.valueOf(edInSym.getText());
        bytTeksTerang     = strTeksTerang.getBytes();

        SymetricAlgorithm symetricAlgorithm = new SymetricAlgorithm();

        try {
            bytTeksSandi = symetricAlgorithm.encrypt(bytKunci,bytTeksTerang);
            edOutSym.setText(Base64.encodeToString(bytTeksSandi, Base64.DEFAULT));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void doDecryptSym(View view) {
        byte[] bytTeksSandi;
        byte[] bytKunci;
        byte[] bytTeksTerang;

        String strKunci = String.valueOf(edKunciSym.getText());
        bytKunci = strKunci.getBytes();

        String strTeksSandi = String.valueOf(edInSym.getText());
        bytTeksSandi     = Base64.decode(strTeksSandi,Base64.DEFAULT);

        SymetricAlgorithm symetricAlgorithm = new SymetricAlgorithm();

        try {
            bytTeksTerang = symetricAlgorithm.decrypt(bytKunci,bytTeksSandi);
            edOutSym.setText(new String(bytTeksTerang));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
