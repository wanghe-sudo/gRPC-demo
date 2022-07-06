package org.demo;

import com.demo.grpc.api.APIResponse;
import com.demo.grpc.api.LoginRequest;
import com.demo.grpc.api.UserGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @Author wanghe
 * @Date 2022/7/5
 * @DESC
 */
public class Client {
    public static void main(String[] args) {
        ManagedChannel build = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        UserGrpc.userBlockingStub userBlockingStub = UserGrpc.newBlockingStub(build);
        LoginRequest defaultInstance = LoginRequest.newBuilder().setUsername("zs").setPasswd("123").build();
        APIResponse login = userBlockingStub.login(defaultInstance);
        System.out.println(login);
        build.shutdown();
    }
}
