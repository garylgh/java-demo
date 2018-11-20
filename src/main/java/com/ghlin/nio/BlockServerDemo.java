package com.ghlin.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class BlockServerDemo {
    static class SocketHandler implements Runnable {
        private SocketChannel sc;
        public SocketHandler(SocketChannel sc) {
            this.sc = sc;
        }

        @Override
        public void run() {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            try {
                int num;
                while (( num = this.sc.read(buffer)) > 0) {
                    buffer.flip();

                    byte[] bytes = new byte[num];
                    buffer.get(bytes);
                    String re = new String(bytes);
                    System.out.println("receive: " + re);

                    // echo back to client
//                    ByteBuffer writeBuffer = ByteBuffer.wrap(("我已经收到你的请求，你的请求内容是：" + re).getBytes());
                    System.out.println("before clear, buffer.position:" + buffer.position());
                    buffer.rewind();
                    System.out.println("after clear, buffer.position:" + buffer.position());
                    sc.write(buffer);

//                    buffer.clear();
                    System.out.println("after write back, buffer.position:" + buffer.position());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ServerSocketChannel ssc = null;
        try {
            ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(8888));

            while (true) {
                SocketChannel sc = ssc.accept();
                SocketHandler handler = new SocketHandler(sc);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ssc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
