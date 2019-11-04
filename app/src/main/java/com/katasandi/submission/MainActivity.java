package com.katasandi.submission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPemain;
    private ArrayList<Pemain> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPemain = (RecyclerView) findViewById(R.id.rv_pemain);
        rvPemain.setHasFixedSize(true);

        list.addAll(DataPemain.getListData());
        showRecylerCardView();
    }

    private void showRecylerCardView() {
        rvPemain.setLayoutManager(new LinearLayoutManager(this));
        CardViewPemainAdapter cardViewPemainAdapter =  new CardViewPemainAdapter(list);
        rvPemain.setAdapter(cardViewPemainAdapter);

    }
}
