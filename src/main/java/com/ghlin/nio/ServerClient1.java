package com.ghlin.nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class ServerClient1 {

    public static void nioClient() {

    }

    public static void ioServer() {
        ServerSocket serverSocket = null;
        InputStream in = null;

        try {
            serverSocket = new ServerSocket(9000);
            int recvSize = 0;
            byte[] recvBuffer = new byte[1024];
            while (true) {
                Socket cliSocket = serverSocket.accept();
                SocketAddress cliAddress = cliSocket.getRemoteSocketAddress();
                System.out.println("client address: " + cliAddress);

                in = cliSocket.getInputStream();
                while ( (recvSize = in.read(recvBuffer)) != -1) {
                    byte[] tmp = new byte[recvSize];
                    System.arraycopy(recvBuffer, 0, tmp, 0, recvSize);
                    System.out.println(new String(tmp));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
