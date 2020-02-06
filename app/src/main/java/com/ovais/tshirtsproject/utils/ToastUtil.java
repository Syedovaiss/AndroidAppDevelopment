package com.ovais.tshirtsproject.utils;

import android.content.Context;
import android.widget.Toast;

import static com.ovais.tshirtsproject.utils.Constants.ON_CHANGE;

public class ToastUtil implements ToastInterface {


    @Override
    public void longToastOnChange(Context context) {
        Toast.makeText(context, ON_CHANGE, Toast.LENGTH_LONG).show();
    }

    @Override
    public void shortToastOnChange(Context context) {
        Toast.makeText(context, ON_CHANGE, Toast.LENGTH_SHORT).show();

    }
}
