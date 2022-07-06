package org.demo;

import com.demo.grpc.api.APIResponse;
import com.demo.grpc.api.UserGrpc;

/**
 * @Author wanghe
 * @Date 2022/7/6
 * @DESC
 */
public class UserClient extends UserGrpc.userImplBase {

    /**
     *
     */
    @Override
    public void login(com.demo.grpc.api.LoginRequest request,
                      io.grpc.stub.StreamObserver<com.demo.grpc.api.APIResponse> responseObserver) {
        System.out.println("request:" + request);

        // 根据逻辑设置响应体
        APIResponse success = APIResponse
                .newBuilder()
                .setResponseCode(200)
                .setResponsemessage("success").build();

        responseObserver.onNext(success);
        responseObserver.onCompleted();
    }

    /**
     *
     */
    @Override
    public void logout(com.demo.grpc.api.Empty request,
                       io.grpc.stub.StreamObserver<com.demo.grpc.api.APIResponse> responseObserver) {
        System.out.println(request);
        System.out.println(responseObserver);
    }
}
