package com.example.piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created on 17/8/15 11:53
 */

public class PipedIO {
    public static void main(String[] args) {
        PipedIOSender sender = new PipedIOSender();
        PipedIOReceiver receiver = new PipedIOReceiver();

        PipedOutputStream pos = sender.getPos();
        PipedInputStream pis = receiver.getPis();
        try {
            // 可以将管道输出流连接到管道输入流来创建通信管道。管道输出流是管道的发送端，管道输入流是管道的接收端。
            // 通常，数据由某个线程写入 PipedOutputStream 对象，并由其他线程从连接的 PipedInputStream 读取。
            // 不建议对这两个对象尝试使用单个线程，因为这样可能会造成该线程死锁。
            // 如果某个线程正从连接的管道输入流中读取数据字节，但该线程不再处于活动状态，则该管道被视为处于 毁坏 状态。
            // 使用管道流类，可以实现各个程序模块之间的松耦合通信。比如一个加密压缩程序模块，调用程序，只需向该模块的输入流中写入数据。
            pos.connect(pis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sender.start();
        receiver.start();

    }
}
