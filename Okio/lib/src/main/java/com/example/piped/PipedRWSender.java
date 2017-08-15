package com.example.piped;

import java.io.IOException;
import java.io.PipedWriter;

/**
 * Created on 17/8/15 12:09
 */

public class PipedRWSender extends Thread {
    private PipedWriter pw = new PipedWriter();

    public PipedWriter getPw() {
        return pw;
    }

    @Override
    public void run() {
        super.run();
        try {
            pw.write("Hello,PipedRWReceiver!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                try {
                    pw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
