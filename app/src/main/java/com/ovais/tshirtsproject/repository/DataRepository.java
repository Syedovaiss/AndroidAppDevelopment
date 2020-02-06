package com.ovais.tshirtsproject.repository;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.ovais.tshirtsproject.database.ShirtDao;
import com.ovais.tshirtsproject.database.ShirtDatabase;
import com.ovais.tshirtsproject.model.Shirt;
import com.ovais.tshirtsproject.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    private ShirtDao shirtDao;
    private LiveData<List<Shirt>> shirts;


    //constructor
    public DataRepository(Application application) {
        ShirtDatabase db = ShirtDatabase.getDatabase(application);
        shirtDao = db.shirtDao();
        shirts = shirtDao.selectAllShirt();


    }

    //insert function which will insert shirt
    public void insert(List<Shirt> shirts) {
        shirtDao.insertData(shirts);
    }

    //returns shirts
    public LiveData<List<Shirt>> getAllShirts() {
        return shirts;
    }



    public LiveData<List<Shirt>> getFromDatabase() {
        return shirts;
    }

    //API-Call
    public void getFromWebServices() {

        RetrofitInstance.getShirtsData().getData().enqueue(new Callback<List<Shirt>>() {
            @Override
            public void onResponse(Call<List<Shirt>> call, Response<List<Shirt>> response) {

                //delete shirts
                shirtDao.deleteShirts();
                insert(response.body());
            }

            @Override
            public void onFailure(Call<List<Shirt>> call, Throwable t) {

                Log.e("Error Fetching Data", t.getMessage());
            }
        });

    }


}
