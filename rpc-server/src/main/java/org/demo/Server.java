package org.demo;

import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @Author wanghe
 * @Date 2022/7/6
 * @DESC
 */
public class Server {
    public static void main(String[] args) {
        io.grpc.Server server = ServerBuilder.forPort(9090).addService(new UserClient()).build();
        try {
            server.start();
            System.out.println("Started");
            server.awaitTermination();
        }  catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
