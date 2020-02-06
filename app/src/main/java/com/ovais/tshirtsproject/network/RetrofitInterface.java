package com.ovais.tshirtsproject.network;

import com.ovais.tshirtsproject.model.Shirt;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.ovais.tshirtsproject.utils.Constants.SHIRT_ROUTE;

//interface which will be implemented to do network transactions
public interface RetrofitInterface {
    @GET(SHIRT_ROUTE)
    Call<List<Shirt>> getData();

}
