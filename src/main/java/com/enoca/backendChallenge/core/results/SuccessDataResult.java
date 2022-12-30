package com.enoca.backendChallenge.core.results;

public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T data,  String message) {
        super(data,true, message);
    }
    public SuccessDataResult(T data,  boolean success) {
        super(data,true);
    }
    public SuccessDataResult(String message) {
        super(null, true, message);
    }
    public SuccessDataResult() {
        super(null, true);
    }
}

