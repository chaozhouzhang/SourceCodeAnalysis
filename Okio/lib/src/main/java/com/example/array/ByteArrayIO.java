package com.example.array;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created on 17/8/15 16:00
 */

public class ByteArrayIO {
    public static void main(String[] args){

        copyFile("/Users/zhangchaozhou/Documents/skill/SourceAnalysis/Okio/lib/Test.txt", "/Users/zhangchaozhou/Documents/skill/SourceAnalysis/Okio/lib/DestByteArrayIO.txt");

    }


    /**
     * 输入流是用来读取数据的！从输入流中读取字节到字节数组中！注意字节数组大小的合适定义！
     *
     * @param filePath
     * @return
     */
    public static byte[] file2String(String filePath) {

        int size;
        byte[] buffer = new byte[1024];
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            bis = new BufferedInputStream(fis);

            //从输入流中读取字节到字节数组中！注意字节数组大小的合适定义！
            while ((size = bis.read(buffer)) != -1) {
                baos.write(buffer,0,size);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return baos.toByteArray();
    }


    /**
     * 输出流是用来写入数据的！从字节数组中将字节写入到输出流中！
     *
     * @param content
     * @param filePath
     */

    public static void string2File(byte[] content, String filePath) {
        BufferedOutputStream bos = null;
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            bos = new BufferedOutputStream(fos);
            //从字节数组中将字节写入到输出流中！
            bos.write(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 复制文件
     *
     * @param sourcePath
     * @param destPath
     */
    public static void copyFile(String sourcePath, String destPath) {

        string2File(file2String(sourcePath), destPath);
    }


}


