package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.list.databinding.ActivityCrearBinding;
import com.example.list.databinding.ActivityMainBinding;

public class Crear extends AppCompatActivity  implements  View.OnClickListener{
    private ActivityCrearBinding crearBinding;
    private DBTienda dbTienda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       crearBinding = ActivityCrearBinding.inflate(getLayoutInflater());
        View view = crearBinding.getRoot();
        setContentView(view);
        dbTienda = new DBTienda(this);
        crearBinding.btnSave.setOnClickListener(this);


    }

    public void onClick(View view) {
        if( view.getId()==R.id.btnSave){
            String name = crearBinding.nameProducto.getText().toString();
            String cantidad = crearBinding.numCantidad.getText().toString();
            Toast.makeText(this, name , Toast.LENGTH_SHORT).show();
            SQLiteDatabase db = dbTienda.getWritableDatabase();
            finish();
        }





    }


}