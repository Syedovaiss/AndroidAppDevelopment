package com.ovais.tshirtsproject.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.ovais.tshirtsproject.R;
import com.ovais.tshirtsproject.adapters.ShirtAdapter;
import com.ovais.tshirtsproject.databinding.ActivityMainBinding;
import com.ovais.tshirtsproject.databinding.ActivityMainBindingImpl;
import com.ovais.tshirtsproject.model.Shirt;
import com.ovais.tshirtsproject.utils.ToastUtil;
import com.ovais.tshirtsproject.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //To-Do---> Swipe Refresh Layout

    private RecyclerView recyclerView;
    private ToastUtil toastUtil = new ToastUtil();
    private SwipeRefreshLayout swipeRefreshLayout;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);

        //finding recycler view by id
        recyclerView = findViewById(R.id.recyclerView);
        //view Model Function
        initModel();

    }

    private void initModel() {


        final MainActivityViewModel mainActivityViewModel;

        //view model provider which need lifecycle owner and class
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        binding.setViewModel(mainActivityViewModel);


        //Observer observes data and perform actions
        mainActivityViewModel.getAllShirts().observe(this, new Observer<List<Shirt>>() {
            @Override
            public void onChanged(final List<Shirt> shirts) {
                swipeRefreshLayout = findViewById(R.id.swipeToRefresh);

                swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {

                        //set up recycler view on refresh
                        setUpRecyclerView(shirts);
                        //stopping the refreshing icon
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });

                //when changed it will set it to recycler view
                setUpRecyclerView(shirts);

                //Toast
                toastUtil.longToastOnChange(MainActivity.this);


            }
        });
    }

    //setting recycler view
    private void setUpRecyclerView(final List<Shirt> shirts) {
        ShirtAdapter adapter = new ShirtAdapter(shirts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);


    }


}
