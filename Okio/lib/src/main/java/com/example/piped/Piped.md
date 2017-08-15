#对管道进行操作（节点流）
PipedInputStream（字节输入流）

PipedOutStream（字节输出流）

PipedReader（字符输入流）

PipedWriter（字符输出流）

PipedInputStream的一个实例要和PipedOutputStream的一个实例共同使用，共同完成管道的读取写入操作。主要用于线程操作。