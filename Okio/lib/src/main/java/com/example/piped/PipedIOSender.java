package com.example.piped;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * Created on 17/8/15 11:47
 */

public class PipedIOSender extends Thread {
    private PipedOutputStream pos = new PipedOutputStream();

    public PipedOutputStream getPos() {
        return pos;
    }

    @Override
    public void run() {
        super.run();


        String info = new String("Hello,PipedIOReceiver!");
        try {
            pos.write(info.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (pos!=null){
                try {
                    pos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
