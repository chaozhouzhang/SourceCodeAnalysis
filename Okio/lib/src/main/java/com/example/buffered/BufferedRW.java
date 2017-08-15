package com.example.buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created on 17/8/15 15:33
 */

public class BufferedRW {
    public static void main(String[] args) {

        copyFile("/Users/zhangchaozhou/Documents/skill/SourceAnalysis/Okio/lib/Test.txt", "/Users/zhangchaozhou/Documents/skill/SourceAnalysis/Okio/lib/DestBufferedRW.txt");

    }


    /**
     * @param filePath
     * @return
     */
    public static String file2String(String filePath) {

        char[] chars = new char[1024];
        String content = "";
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            int len = br.read(chars);
            String tmp = new String(chars, 0, len);
            content += tmp;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content;
    }


    /**
     * @param content
     * @param filePath
     */
    public static void string2File(String content, String filePath) {


        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter(filePath);
            bw = new BufferedWriter(fw);
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * @param sourcePath
     * @param destPath
     */
    public static void copyFile(String sourcePath, String destPath) {
        string2File(file2String(sourcePath), destPath);
    }
}
