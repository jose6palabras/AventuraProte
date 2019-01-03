package com.grupodetec.aventuraprote.View.CocornaGram;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.grupodetec.aventuraprote.Pojo.DataSource;
import com.grupodetec.aventuraprote.R;
import com.grupodetec.aventuraprote.View.RecyclerViewAdapter;

public class CocornagramActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocornagram);

        //set toolbar conf
        Toolbar toolbar = (Toolbar) findViewById(R.id.cocornagram_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        //set recyclerview
        final RecyclerView recyclerView = findViewById(R.id.cocornagram_recyclerview);
        recyclerView.setHasFixedSize(true);

        //set layoutmanager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        final DataSource dataSource = new DataSource();

        //set adapter
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(dataSource.cocornagramData(), R.layout.cardview_model_full);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
