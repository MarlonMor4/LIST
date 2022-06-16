package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.list.databinding.ActivityMainBinding;
import com.example.list.databinding.ActivityRegistroBinding;

public class Registro extends AppCompatActivity  implements View.OnClickListener{



    private ActivityRegistroBinding registroBinding;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registroBinding=ActivityRegistroBinding.inflate(getLayoutInflater());
        View view= registroBinding.getRoot();
        setContentView(view);
        registroBinding.btnRegistrar.setOnClickListener(this);
        dbHelper = new DBHelper(this);

    }



    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnRegistrar){
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues userData = new ContentValues();
            String name = registroBinding.etName.getText().toString();
            String email = registroBinding.etEmail.getText().toString();
            String identification = registroBinding.etIdentification.getText().toString();
            String password = registroBinding.etPassword.getText().toString();
            userData.put("name", name);
            userData.put("email", email);
            userData.put("identidication", identification);
            userData.put("password", password);
            long newUser = db.insert("users", null, userData);
            Toast.makeText(this, "" + newUser, Toast.LENGTH_SHORT).show();
            finish();
        }




    }
}
