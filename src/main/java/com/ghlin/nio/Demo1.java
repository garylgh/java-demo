package com.ghlin.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * http://tutorials.jenkov.com/java-nio/nio-vs-io.html
 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
//        ioProcessData1();
//        ioReadFile();

        nioReadFile();
    }

    public static void ioProcessData1() {
        String s = "Name: Anna\n" +
                "Age: 25\n" +
                "Email: anna@mailserver.com\n" +
                "Phone: 1234567890";

        InputStream is = new ByteArrayInputStream(s.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line;
        try {
            // readline是一个阻塞函数
            // https://blog.csdn.net/swingline/article/details/5357581
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

    }

    public static void ioReadFile() {
        InputStream is = null;

        try {
            is = new BufferedInputStream(new FileInputStream("src/main/resources/file1.txt"));
            byte[] buffer = new byte[1024];
            int byteReads = is.read(buffer);
            while (byteReads != -1) {
                for(int i = 0; i < byteReads; i++)
                    System.out.print((char)buffer[i]);
                byteReads = is.read(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)  {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void nioReadFile() {
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("src/main/resources/file1.txt", "rw");
            FileChannel fc = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);

            int bytesRead = fc.read(buf);
            while (bytesRead != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char)buf.get());
                }
                buf.compact();
                bytesRead = fc.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (aFile != null)  {
                    aFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
