package com.example.soru2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InformationActivity extends AppCompatActivity {
    MySQLiteDB mydb;
    Button btnsave;
    Button btnback;
    EditText editWebsite;
    EditText editUsername;
    EditText editPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        mydb=new MySQLiteDB(this);
        btnsave=findViewById(R.id.btnSave);
        btnback=findViewById(R.id.btnback);
        editWebsite=findViewById(R.id.editTextWebSite);
        editUsername=findViewById(R.id.editTextUsername);
        editPassword=findViewById(R.id.editTextPassword);
        initUI();
    }
    private void initUI() {
        btnsave.setOnClickListener(v -> saveClicked());

        btnback.setOnClickListener(v -> backClicked());
    }
    public void saveClicked(){
        if(!editWebsite.getText().toString().equals("") && !editUsername.getText().toString().equals("")&& !editPassword.getText().toString().equals("")){
            mydb.addInformation(editWebsite.getText().toString(),editUsername.getText().toString(),editPassword.getText().toString());
            Toast.makeText(this,"New information added!", Toast.LENGTH_LONG).show();
        }
else        Toast.makeText(this,"New information could not be added!", Toast.LENGTH_LONG).show();
    }
    public void backClicked(){
        Intent myintent= new Intent(this,MainActivity.class);
        startActivity(myintent);

    }

}