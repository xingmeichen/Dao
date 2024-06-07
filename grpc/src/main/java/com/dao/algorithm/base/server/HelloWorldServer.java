package com.dao.algorithm.base.server;

import com.dao.algorithm.base.helloworld.GreeterGrpc;
import com.dao.algorithm.base.helloworld.HelloReply;
import com.dao.algorithm.base.helloworld.HelloRequest;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2021-07-06 11:49
 **/
public class HelloWorldServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldServer.class);

    private int port = 50051;
    private Server server;

    public void start() throws Exception {
        server = ServerBuilder.forPort(port)
                .addService(new GreeterImpl())
                .build()
                .start();
        LOGGER.info("Server start, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("***** shutting down gRPC since JVM is shutting down *****");
                try {
                    HelloWorldServer.this.stop();
                } catch (InterruptedException e) {
                    LOGGER.error("", e);
                }
                System.err.println("***** server shut down *****");
            }
        });
    }

    private void stop() throws InterruptedException {
        if (null != server) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (null != server) {
            server.awaitTermination();
        }
    }

    static class GreeterImpl extends GreeterGrpc.GreeterImplBase {

        @Override
        public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseStreamObserver) {
            HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
            responseStreamObserver.onNext(reply);
            responseStreamObserver.onCompleted();
        }
    }
}