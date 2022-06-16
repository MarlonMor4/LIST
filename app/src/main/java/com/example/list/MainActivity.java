package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.list.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {


    private ActivityMainBinding mainBinding;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        dbHelper = new DBHelper(this);
        mainBinding.btnSigIn.setOnClickListener(this);
        mainBinding.btnSingUp.setOnClickListener(this);


    }

    public void onClick(View view) {
        if( view.getId()==R.id.btnSigIn){
                String email = mainBinding.entEmail.getText().toString();
                String password = mainBinding.entPassword.getText().toString();
                Toast.makeText(this, email , Toast.LENGTH_SHORT).show();
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String query = String.format("SELECT * FROM users WHERE email='%s' and password='%s'",email,password);
                Cursor cursor = db.rawQuery(query, null);
                // verifica si el usuario existe
                if(cursor.getCount() > 0){
                    Toast.makeText(this, "El usuario existe", Toast.LENGTH_SHORT).show();
                    cursor.moveToNext();
                    String emailResult = cursor.getString(2);
                    int id = cursor.getInt(3);
                    Intent intent= new Intent(getApplicationContext(),Inicio.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(this, "Usuario no existe", Toast.LENGTH_SHORT).show();
                }

        }
        if(view.getId()==R.id.btnSingUp)  {
            Intent intent = new Intent(this, Registro.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "El usuario no existe", Toast.LENGTH_SHORT).show();
        }




    }


}












