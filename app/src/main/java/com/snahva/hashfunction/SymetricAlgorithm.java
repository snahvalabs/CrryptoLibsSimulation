package com.snahva.hashfunction;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SymetricAlgorithm {
    private static byte[] bytSecretKey;
    private String secretKey;
    private String initialVector;
    private String nameAlgoritm;

    public static byte[] getBytSecretKey() {
        return bytSecretKey;
    }

    public static void setBytSecretKey(byte[] bytSecretKey) {
        SymetricAlgorithm.bytSecretKey = bytSecretKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getInitialVector() {
        return initialVector;
    }

    public void setInitialVector(String initialVector) {
        this.initialVector = initialVector;
    }

    public String getNameAlgoritm() {
        return nameAlgoritm;
    }

    public void setNameAlgoritm(String nameAlgoritm) {
        this.nameAlgoritm = nameAlgoritm;
    }

    public byte[] encrypt(byte[] kunciSesi, byte[] teksTerang) throws Exception {
        SecretKey skeySpec = new SecretKeySpec(kunciSesi, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(teksTerang);
        return encrypted;
    }

    public byte[] decrypt(byte[] kunciSesi, byte[] teksSandi)
            throws Exception {
        SecretKey skeySpec = new SecretKeySpec(kunciSesi, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] decrypted = cipher.doFinal(teksSandi);
        return decrypted;
    }
}
