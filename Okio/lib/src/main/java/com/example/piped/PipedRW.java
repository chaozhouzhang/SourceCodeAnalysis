package com.example.piped;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created on 17/8/15 12:08
 */

public class PipedRW {

    public static void main(String[]args){
        PipedRWSender pipedRWSender = new PipedRWSender();
        PipedRWReceiver pipedRWReceiver = new PipedRWReceiver();
        PipedWriter pw = pipedRWSender.getPw();
        PipedReader pr = pipedRWReceiver.getPr();


        try {
            pw.connect(pr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        pipedRWReceiver.start();
        pipedRWSender.start();


    }
}
