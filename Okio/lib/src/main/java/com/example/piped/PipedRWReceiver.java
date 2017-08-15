package com.example.piped;

import java.io.IOException;
import java.io.PipedReader;

/**
 * Created on 17/8/15 12:11
 */

public class PipedRWReceiver extends Thread {
    private PipedReader pr = new PipedReader();

    public PipedReader getPr() {
        return pr;
    }

    @Override
    public void run() {
        super.run();
        try {
            char[] chars = new char[1024];
            int len = pr.read(chars);
            System.out.println("The following message comes from PipedIOSender：" + new String(chars, 0, len));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pr != null) {
                try {
                    pr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
