package com.snahva.hashfunction;

import android.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CryptoLibs {
    public String Input;
    public String Output;
    public String Algorithm;

    public String getInput() {
        return Input;
    }

    public void setInput(String input) {
        Input = input;
    }

    public String getOutput() {
        return Output;
    }

    public void setOutput(String output) {
        Output = output;
    }

    public String getAlgorithm() {
        return Algorithm;
    }

    public void setAlgorithm(String algorithm) {
        Algorithm = algorithm;
    }

    public String generateHash(){
        try {
            byte[] bytInput = Input.getBytes();
            byte[] bytOuput;

            MessageDigest hash = MessageDigest.getInstance(Algorithm);
            hash.reset();
            hash.update(bytInput);
            bytOuput = hash.digest();

            Output = Base64.encodeToString(bytOuput,Base64.DEFAULT);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return Output;
    }

    public byte[] generateHashByte(){
        byte[] bytOuput;
        bytOuput = "1234".getBytes();
        try {
            byte[] bytInput = Input.getBytes();

            MessageDigest hash = MessageDigest.getInstance(Algorithm);
            hash.reset();
            hash.update(bytInput);
            bytOuput = hash.digest();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return bytOuput;
    }


   public byte[] generateRandomKey(){
        SecureRandom mSecureRandom = new SecureRandom();
        byte[] bytOutput = new byte[16];

        mSecureRandom.nextBytes(bytOutput);

        return bytOutput;

   }

    public byte[] generateRandomKey(int keyLength){
        SecureRandom mSecureRandom = new SecureRandom();
        byte[] bytOutput = new byte[keyLength];

        mSecureRandom.nextBytes(bytOutput);

        return bytOutput;

    }

    public byte[] generateRandomKey(int keyLength, String seed){
        SecureRandom mSecureRandom = new SecureRandom();
        byte[] bytOutput = new byte[keyLength];

        mSecureRandom.setSeed(seed.getBytes());
        mSecureRandom.nextBytes(bytOutput);

        return bytOutput;

    }

}
