package com.example.soru2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnNew;
    Button btnList;
    SearchView srcview;
    RecyclerView Listrec;
    MySQLiteDB mydb;
    ArrayList<MyInformation> myInformationsArrayList = new ArrayList<>();
    InformationListAdapter informationListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb= new MySQLiteDB(this);
        btnNew=findViewById(R.id.btnNew);
        btnList=findViewById(R.id.btnList);
        srcview=findViewById(R.id.searchfilter);
        Listrec=findViewById(R.id.recv1);
        informationListAdapter= new InformationListAdapter(mydb.getList());
        initUI();
        srcview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                informationListAdapter.myfilter.filter(newText);
                return true;
            }
        });
    }

    private void initUI() {
        btnNew.setOnClickListener(v -> newClicked());

        btnList.setOnClickListener(v -> ListInformation());
    }
    public void newClicked(){
        Intent myintent= new Intent(this,InformationActivity.class);
        startActivity(myintent);

    }

    public void ListInformation(){

        myInformationsArrayList = mydb.getList();
        informationListAdapter = new InformationListAdapter(myInformationsArrayList);
        for (MyInformation information : myInformationsArrayList) {
            System.out.println(information.id  +" " + information.website + " " + information.username + " " + information.password);

        }
        Listrec.setAdapter(informationListAdapter);
    }
}

