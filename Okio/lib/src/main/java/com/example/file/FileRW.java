package com.example.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created on 17/8/15 12:32
 */

public class FileRW {
    public static void main(String[] args) {

        copyFile("/Users/zhangchaozhou/Documents/skill/SourceAnalysis/Okio/lib/Test.txt", "/Users/zhangchaozhou/Documents/skill/SourceAnalysis/Okio/lib/DestRW.txt");


    }


    /**
     * @param filePath
     * @return
     */
    public static String file2String(String filePath) {

        FileReader fr = null;
        char[] chars = new char[1024];
        String content = "";
        try {
            fr = new FileReader(filePath);
            int len = fr.read(chars);
            String tmp = new String(chars, 0, len);
            content += tmp;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
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

        FileWriter fw = null;

        try {
            fw = new FileWriter(filePath);
            fw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
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
