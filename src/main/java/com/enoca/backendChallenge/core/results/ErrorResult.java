package com.enoca.backendChallenge.core.results;

public class ErrorResult extends Result{

    public ErrorResult() {
        super(false);
    }

    public ErrorResult(boolean success, String message) {
        super(success, message);
    }
}
