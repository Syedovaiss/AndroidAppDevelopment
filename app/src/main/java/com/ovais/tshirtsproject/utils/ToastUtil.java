package com.ovais.tshirtsproject.utils;

import android.content.Context;
import android.widget.Toast;

import static com.ovais.tshirtsproject.utils.Constants.ON_CHANGE;

public class ToastUtil implements ToastInterface {
    Context context;

    @Override
    public void longToastOnChange() {
        Toast.makeText(context,ON_CHANGE,Toast.LENGTH_LONG).show();
    }

    @Override
    public void shortToastOnChange() {
        Toast.makeText(context,ON_CHANGE,Toast.LENGTH_SHORT).show();

    }
}
