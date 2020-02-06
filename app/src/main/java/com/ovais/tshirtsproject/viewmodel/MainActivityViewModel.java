package com.ovais.tshirtsproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.ovais.tshirtsproject.model.Shirt;
import com.ovais.tshirtsproject.repository.DataRepository;

import java.util.List;

//extends view model
public class MainActivityViewModel extends AndroidViewModel {
    private DataRepository myRepo;
    private LiveData<List<Shirt>> shirtsList;

    //constructor
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        //data repo obj
        myRepo = new DataRepository(application);
        //getting all shirts from repo
        shirtsList = myRepo.getAllShirts();

    }

    public LiveData<List<Shirt>> getAllShirts() {
        return shirtsList;

    }



    public void getFromAPI() {

        myRepo.getFromWebServices();
    }


}
