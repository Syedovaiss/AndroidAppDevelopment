package com.ovais.tshirtsproject.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ovais.tshirtsproject.R;
import com.ovais.tshirtsproject.adapters.ShirtAdapter;
import com.ovais.tshirtsproject.model.Shirt;
import com.ovais.tshirtsproject.utils.ToastUtil;
import com.ovais.tshirtsproject.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ToastUtil toastUtil = new ToastUtil();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding recycler view by id
        recyclerView = findViewById(R.id.recyclerView);
        initModel();

    }

    private void initModel(){


        MainActivityViewModel mainActivityViewModel;

        //view model provider which need lifecycle owner and class
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        //Observer observes data and perform actions
        mainActivityViewModel.getAllShirts().observe(this, new Observer<List<Shirt>>() {
            @Override
            public void onChanged(List<Shirt> shirts) {

                //when changed it will set it to recycler view
                setUpRecyclerView(shirts);

                //Toast
                toastUtil.longToastOnChange(MainActivity.this);


            }
        });
    }
    //setting recycler view
    private void setUpRecyclerView(List<Shirt> shirts) {
        ShirtAdapter adapter = new ShirtAdapter(shirts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
