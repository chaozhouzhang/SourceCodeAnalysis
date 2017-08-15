package com.example.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {


    public static void main(String[] args) {
        copyFile("/Users/zhangchaozhou/Documents/skill/SourceAnalysis/Okio/lib/Test.txt", "/Users/zhangchaozhou/Documents/skill/SourceAnalysis/Okio/lib/DestIO.txt");
    }


    /**
     * 输入流是用来读取数据的！从输入流中读取字节到字节数组中！注意字节数组大小的合适定义！
     *
     * @param filePath
     * @return
     */
    public static String file2String(String filePath) {

        String content = "";
        int size;
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            //从输入流中读取字节到字节数组中！注意字节数组大小的合适定义！
            while ((size = fis.read(buffer)) != -1) {
                String tmp = new String(buffer, 0, size);
                content += tmp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return content;
    }


    /**
     * 输出流是用来写入数据的！从字节数组中将字节写入到输出流中！
     *
     * @param content
     * @param filePath
     */

    public static void string2File(String content, String filePath) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filePath);
            //从字节数组中将字节写入到输出流中！
            fos.write(content.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
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
