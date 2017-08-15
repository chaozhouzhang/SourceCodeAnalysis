package com.example;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created on 17/8/15 12:51
 */

public class ByteChar {
    public static void main(String[] args) {

        byteArray();
    }


    public static void byteArray() {
        byte[] letters = {
                0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
                0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
        };
        String content = "";
        byte[] buffer = new byte[5];
        InputStream is = new ByteArrayInputStream(letters);
        try {
            int len = is.read(buffer,0,5);
            while (len != -1) {
                String tmp = new String(buffer);
                content += tmp;
                System.out.println(content);
                len = is.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
