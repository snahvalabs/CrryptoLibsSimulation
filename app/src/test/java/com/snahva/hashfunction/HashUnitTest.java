package com.snahva.hashfunction;

import android.util.Base64;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class HashUnitTest {
    private CryptoLibs mCryptoLibs;

    @Before
    public void setUp() {
        mCryptoLibs = new CryptoLibs();
    }

    @Test
    public void md5Base64() {
        String compareHash = "gdyb21LQTcIANtvYMT7QVQ==";
        byte[] bytCompare = Base64.decode(compareHash,Base64.DEFAULT);

        mCryptoLibs.setInput("1234");
        mCryptoLibs.setAlgorithm("MD5");
        mCryptoLibs.generateHashByte();

        byte[] bytOutput = mCryptoLibs.generateHashByte();

        assertArrayEquals(bytCompare,bytOutput);
    }
}
