package com.example.buffered;

/**
 * 不带缓冲的操作，每读一个字节就要写入一个字节，由于涉及磁盘的IO操作相比内存的操作要慢很多，所以不带缓冲的流效率很低。
 * 带缓冲的流，可以一次读很多字节，但不向磁盘中写入，只是先放到内存里。
 * 等凑够了缓冲区大小的时候一次性写入磁盘，这种方式可以减少磁盘操作次数，速度就会提高很多，综合效率高！
 * Created on 17/8/15 15:01
 */

/**
 * 在介绍FileInputStream和FileOutputStream的例子中，使用了一个byte数组来作为数据读入的缓冲区，以文件存取为例，硬盘存取的速度远低于内存中的数据存取速度。
 * 为了减少对硬盘的存取，通常从文件中一次读入一定长度的数据，而写入时也是一次写入一定长度的数据，这可以增加文件存取的效率。
 */

/**
 * BufferedOutputStream的数据成员buf是一个位数组，默认为8192字节。
 * 当使用write()方法写入数据时，实际上会先将数据写至buf中.
 * 当buf已满时才会实现给定的OutputStream对象的write()方法，将buf数据写至目的地，而不是每次都对目的地作写入的动作。
 */


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * BufferedInputStream的数据成员buf是一个位数组，默认为8192字节。
 * 当读取数据来源时，BufferedInputStream会尽量将buf填满。
 * 当使用read()方法时，实际上是先读取buf中的数据，而不是直接对数据来源作读取。
 * 当buf中的数据不足时，才会再实现给定的InputStream对象的read()方法，从指定的装置中提取数据。
 */
public class BufferedIO {
    public static void main(String[] args) {
        copyFile("/Users/zhangchaozhou/Documents/skill/SourceAnalysis/Okio/lib/Test.txt", "/Users/zhangchaozhou/Documents/skill/SourceAnalysis/Okio/lib/DestBufferedIO.txt");

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
        BufferedInputStream bis = null;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            bis = new BufferedInputStream(fis);
            //从输入流中读取字节到字节数组中！注意字节数组大小的合适定义！
            while ((size = bis.read(buffer)) != -1) {
                String tmp = new String(buffer, 0, size);
                content += tmp;
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

        return content;
    }


    /**
     * 输出流是用来写入数据的！从字节数组中将字节写入到输出流中！
     *
     * @param content
     * @param filePath
     */

    public static void string2File(String content, String filePath) {
        BufferedOutputStream bos = null;
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            bos = new BufferedOutputStream(fos);
            //从字节数组中将字节写入到输出流中！
            bos.write(content.getBytes());
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
