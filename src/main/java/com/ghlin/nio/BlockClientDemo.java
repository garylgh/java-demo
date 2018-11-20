package com.ghlin.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class BlockClientDemo {
    public static void main(String[] args) {
        SocketChannel sc;
        try {
            sc = SocketChannel.open();
            sc.connect(new InetSocketAddress("localhost", 8888));

            // send
            sc.write(ByteBuffer.wrap("asdf jkl;".getBytes()));

            // read
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            int num;
            while ((num = sc.read(readBuffer)) > 0) {
                System.out.println("BlockClient receive: " + num + " bytes");
                readBuffer.flip();

                byte[] bytes = new byte[num];
                readBuffer.get(bytes);

                System.out.println("echo: " + new String(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
