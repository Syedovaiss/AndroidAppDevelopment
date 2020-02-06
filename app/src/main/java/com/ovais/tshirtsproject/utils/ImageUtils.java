package com.ovais.tshirtsproject.utils;

import android.widget.ImageView;

import com.ovais.tshirtsproject.R;
import com.squareup.picasso.Picasso;

public class ImageUtils {

    //function that implements picasso
    public static void setImage(String imageUrl, ImageView imageView) {
        Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageView);

    }
}
