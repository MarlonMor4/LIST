package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.list.databinding.ActivityInicioBinding;
import com.example.list.databinding.ActivityMainBinding;

public class Inicio extends AppCompatActivity implements View.OnClickListener {

    private ActivityInicioBinding inicioBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inicioBinding= ActivityInicioBinding.inflate(getLayoutInflater());
        View view = inicioBinding.getRoot();
        setContentView(view);
        inicioBinding.btnlist.setOnClickListener(this);
        inicioBinding.btnCreate.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnlist) {
            Intent intent= new Intent(this,List.class);
        }
        if(v.getId()==R.id.btnCreate)  {
            Intent intent=new Intent(this,Crear.class);
        }

    }
}