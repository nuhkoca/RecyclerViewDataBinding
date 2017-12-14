package com.mobilemovement.recyclerviewdatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mobilemovement.recyclerviewdatabinding.adapter.PeopleAdapter;
import com.mobilemovement.recyclerviewdatabinding.databinding.ActivityMainBinding;
import com.mobilemovement.recyclerviewdatabinding.model.People;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mActivityMainBinding;
    private List<People> mPeople = new ArrayList<>();
    private PeopleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        mActivityMainBinding.rvData.setHasFixedSize(true);
        mActivityMainBinding.rvData.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new PeopleAdapter(mPeople);

        mActivityMainBinding.rvData.setAdapter(mAdapter);

        addPeople();
    }

    private void addPeople() {
        People people1 = new People("Nuh Koca", "Android Developer", 25);
        mPeople.add(people1);

        People people2 = new People("Joe Doe", "System Engineer", 28);
        mPeople.add(people2);

        People people3 = new People("Maria Kovac", "Integration Specialist", 27);
        mPeople.add(people3);
        People people4 = new People("Fred Bruno", "IOS Developer", 32);
        mPeople.add(people4);


        mAdapter.updatePeople(mPeople);
    }
}
