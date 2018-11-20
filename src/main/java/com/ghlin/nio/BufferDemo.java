package com.ghlin.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class BufferDemo {
    public static void main(String[] args) {
        System.out.println("--------print number string");
        readBuffer();
        System.out.println("--------print bype");
        readByte();
        System.out.println("--------print char");
        readChar();
        System.out.println("--------transfer file");
        trasferChannel();
    }
    public static void readBuffer() {
        System.out.println(System.getProperty("user.dir"));
        RandomAccessFile raFile = null;
        try {
            raFile = new RandomAccessFile("src/main/resources/test.txt", "rw");
            FileChannel channel = raFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(48);

            int readBytes = channel.read(buf);
            while (readBytes != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.println(buf.get());
                }
                buf.clear();
                readBytes = channel.read(buf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readByte() {
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.put((byte) 1);
        buf.put((byte) 2);
        buf.put((byte) 3);
        buf.put((byte) 4);
        buf.put((byte) 5);
        buf.put((byte) 6);

        buf.flip();
        while (buf.hasRemaining()) {
            System.out.println(buf.get());
        }
        buf.clear();
    }

    public static void readChar() {
        CharBuffer buf = CharBuffer.allocate(48);
        buf.put((char)96);
        buf.put((char)97);
        buf.put((char)98);

        buf.flip();
        System.out.println("limit: " + buf.limit());
        buf.mark();
        while (buf.hasRemaining()) {
            System.out.println(Integer.toBinaryString(buf.get()) );
        }
        System.out.println("before reset position: " + buf.position());
        buf.reset();
        System.out.println("after reset position: " + buf.position());
        buf.clear();
    }

    public static void trasferChannel() {
        RandomAccessFile fromFile = null;
        RandomAccessFile toFile = null;
        try {
            fromFile = new RandomAccessFile("src/main/resources/test.txt", "rw");
            FileChannel fromChannel = fromFile.getChannel();

            toFile = new RandomAccessFile("src/main/resources/totest.txt", "rw");
            FileChannel toChannel = toFile.getChannel();

            int position = 0;
            long size = fromChannel.size();
            toChannel.transferFrom(fromChannel, position, size);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fromFile != null) {
                    fromFile.close();
                }
                if (toFile != null) {
                    toFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
