package com.csjbot.admin.backadmin.tms.model;

public class Result {
    private final boolean success;
    private final String message;

    public Result(boolean suc, String msg) {
        this.success = suc;
        this.message = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
