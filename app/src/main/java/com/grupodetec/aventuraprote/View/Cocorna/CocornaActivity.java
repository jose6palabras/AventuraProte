package com.grupodetec.aventuraprote.View.Cocorna;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.grupodetec.aventuraprote.Pojo.DataSource;
import com.grupodetec.aventuraprote.R;
import com.grupodetec.aventuraprote.View.RecyclerViewAdapter;

public class CocornaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocorna);

        //set toolbar conf
        Toolbar toolbar = (Toolbar) findViewById(R.id.cocorna_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        //set recyclerview
        final RecyclerView recyclerView = findViewById(R.id.cocorna_recyclerview);
        recyclerView.setHasFixedSize(true);

        //set layoutmanager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        final DataSource dataSource = new DataSource();

        //set adapter
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(dataSource.cocornaData(), R.layout.cardview_model_full);
        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerViewAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.grupodetec.aventuraprote.View.Cocorna.ContainerActivity.class);
                intent.putExtra("image", dataSource.cocornaData().get(recyclerView.getChildAdapterPosition(v)).photo_id);
                intent.putExtra("name", dataSource.cocornaData().get(recyclerView.getChildAdapterPosition(v)).name);
                intent.putExtra("local", dataSource.cocornaData().get(recyclerView.getChildAdapterPosition(v)).local);
                startActivity(intent);

            }
        });
    }
}
