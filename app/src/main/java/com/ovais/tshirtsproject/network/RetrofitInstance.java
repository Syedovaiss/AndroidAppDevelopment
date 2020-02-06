package com.ovais.tshirtsproject.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.ovais.tshirtsproject.utils.Constants.BASE_URL;

//creating an instance of retrofit
public class RetrofitInstance {
    private static Retrofit retrofit;

    public static RetrofitInterface getShirtsData() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(RetrofitInterface.class);


    }
}
