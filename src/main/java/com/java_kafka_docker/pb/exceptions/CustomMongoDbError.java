package com.java_kafka_docker.pb.exceptions;

public class CustomMongoDbError extends RuntimeException {
    public CustomMongoDbError(String message) {
        super(message);
    }
}
