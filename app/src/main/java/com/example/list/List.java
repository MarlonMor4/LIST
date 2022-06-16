package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.list.databinding.ActivityListBinding;
import com.example.list.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class List extends AppCompatActivity implements View.OnClickListener {

    private ActivityListBinding listBinding;
    private DBTienda dbTienda;
    private int idUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       listBinding = ActivityListBinding.inflate(getLayoutInflater());

        dbTienda = new DBTienda(this);

        View view = listBinding.getRoot();
        setContentView(view);
         dbTienda = new DBTienda(this);
        listBinding.btnSearch.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSearch:
                
        }
    }
}