package com.ovais.tshirtsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView title,description,price;
    private ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getPassedData();
    }

    private void getPassedData(){


        Intent intent=getIntent();
        title=findViewById(R.id.title);
        price=findViewById(R.id.price);
        description=findViewById(R.id.description);
        picture=findViewById(R.id.image);
        title.setText(intent.getStringExtra("name"));
        price.setText(intent.getStringExtra("price"));
        description.setText(intent.getStringExtra("desc"));




    }
}
