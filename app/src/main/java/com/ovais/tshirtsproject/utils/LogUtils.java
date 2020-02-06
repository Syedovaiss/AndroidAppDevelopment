package com.ovais.tshirtsproject.utils;

import android.util.Log;

import static com.ovais.tshirtsproject.utils.Constants.DEBUG_TAG;
import static com.ovais.tshirtsproject.utils.Constants.FAILURE_TAG;
import static com.ovais.tshirtsproject.utils.Constants.SUCCESS_TAG;

public class LogUtils implements LogInterface {


    @Override
    public void onSuccess(String message) {
        Log.i(SUCCESS_TAG, message);

    }

    @Override
    public void onFailure(String message) {
        Log.e(FAILURE_TAG, message);

    }

    @Override
    public void startDebugger(String message) {
        Log.d(DEBUG_TAG, message);

    }

}
