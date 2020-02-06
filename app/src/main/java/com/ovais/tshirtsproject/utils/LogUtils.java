package com.ovais.tshirtsproject.utils;

import android.util.Log;

import static com.ovais.tshirtsproject.utils.Constants.DEBUG_MESSAGE;
import static com.ovais.tshirtsproject.utils.Constants.DEBUG_TAG;
import static com.ovais.tshirtsproject.utils.Constants.FAILURE_MESSAGE;
import static com.ovais.tshirtsproject.utils.Constants.FAILURE_TAG;
import static com.ovais.tshirtsproject.utils.Constants.SUCCESS_MESSAGE;
import static com.ovais.tshirtsproject.utils.Constants.SUCCESS_TAG;

public class LogUtils implements LogInterface {


    @Override
    public void onSuccess() {
        Log.i(SUCCESS_TAG,SUCCESS_MESSAGE);

    }

    @Override
    public void onFailure() {
        Log.e(FAILURE_TAG,FAILURE_MESSAGE);

    }

    @Override
    public void startDebugger() {
        Log.d(DEBUG_TAG,DEBUG_MESSAGE);

    }

}
