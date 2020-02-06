package com.ovais.tshirtsproject.utils;

public interface LogInterface {

    void onSuccess(String message);

    void onFailure(String message);

    void startDebugger(String message);
}
