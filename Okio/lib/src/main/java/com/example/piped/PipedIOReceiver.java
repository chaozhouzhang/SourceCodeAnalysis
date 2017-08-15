package com.example.piped;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * Created on 17/8/15 11:50
 */

public class PipedIOReceiver extends Thread {
    PipedInputStream pis = new PipedInputStream();

    public PipedInputStream getPis() {
        return pis;
    }

    @Override
    public void run() {
        super.run();
        byte[] buffer = new byte[1024];
        try {
            int len = pis.read(buffer);
            System.out.println("The following message comes from PipedIOSender：" + new String(buffer, 0, len));
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (pis != null) {
                try {
                    pis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
