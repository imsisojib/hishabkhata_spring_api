package com.appsterminal.hishabkhata.models.responses;

public class Response<T> {
    String message;
    T result;

    public Response() {
    }

    public Response(String message, T result) {
        this.message = message;
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
