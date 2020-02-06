package com.ovais.tshirtsproject.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.ovais.tshirtsproject.R;
import com.ovais.tshirtsproject.adapters.ShirtAdapter;
import com.ovais.tshirtsproject.model.Shirt;
import com.ovais.tshirtsproject.utils.ToastUtil;
import com.ovais.tshirtsproject.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    MainActivityViewModel mainActivityViewModel;
    ToastUtil toastUtil = new ToastUtil();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //finding recycler view by id
        recyclerView = findViewById(R.id.recyclerView);
        //view model provider which need lifecycle owner and class
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        //network connectivity
        if (isNetworkConnected(getApplicationContext())) {
            //getting from web service
            mainActivityViewModel.getFromAPI();


        }
        //Observer observes data and perform actions
        mainActivityViewModel.getAllShirts().observe(this, new Observer<List<Shirt>>() {
            @Override
            public void onChanged(List<Shirt> shirts) {
                //when changed it will set it to recycler view
                setUpRecyclerView(shirts);
                //Toast
                toastUtil.longToastOnChange();


            }
        });
    }

    private boolean isNetworkConnected(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            return true;

        } else {
            return false;
        }
    }

    //setting recycler view
    private void setUpRecyclerView(List<Shirt> shirts) {
        ShirtAdapter adapter = new ShirtAdapter(shirts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
