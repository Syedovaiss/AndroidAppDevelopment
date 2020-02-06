package com.ovais.tshirtsproject.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.ovais.tshirtsproject.database.ShirtDao;
import com.ovais.tshirtsproject.database.ShirtDatabase;
import com.ovais.tshirtsproject.model.Shirt;
import com.ovais.tshirtsproject.network.RetrofitInstance;
import com.ovais.tshirtsproject.utils.LogUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    private ShirtDao shirtDao;
    private LiveData<List<Shirt>> shirts;
    private LogUtils logs = new LogUtils();
    //private Application application;


    //constructor
    public DataRepository(Application application) {
        ShirtDatabase db = ShirtDatabase.getDatabase(application);
        shirtDao = db.shirtDao();
        shirts = shirtDao.selectAllShirt();


    }

    //insert function which will insert shirt
    private void insert(List<Shirt> shirts) {
        shirtDao.insertData(shirts);
    }

    public LiveData<List<Shirt>> getAllShirts() {

        if (getFromDatabase() == null) {

            logs.onFailure("db---> null---starting web service");
            getFromWebServices();
        }


        return shirts;


    }


    private LiveData<List<Shirt>> getFromDatabase() {
        return shirts;
    }

    //API-Call
    private void getFromWebServices() {

        RetrofitInstance.getShirtsData().getData().enqueue(new Callback<List<Shirt>>() {
            @Override
            public void onResponse(Call<List<Shirt>> call, Response<List<Shirt>> response) {


                shirtDao.deleteShirts();
                insert(response.body());
            }

            @Override
            public void onFailure(Call<List<Shirt>> call, Throwable t) {


                logs.onFailure("Call Failed");

            }
        });

    }


}
