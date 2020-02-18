package com.xjliang.bootlaunch.config.exception;

public class ModelViewException extends RuntimeException {

    private int code;

    private String message;

    public static ModelViewException transfer(CustomException e) {
        return new ModelViewException(e.getCode(), e.getMessage());
    }

    public ModelViewException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
