package com.grupodetec.aventuraprote.View.Sites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.grupodetec.aventuraprote.R;
import com.grupodetec.aventuraprote.View.RecyclerViewAdapter;
import com.grupodetec.aventuraprote.Pojo.DataSource;


public class SitesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sites);

        //set recyclerview
        final RecyclerView recyclerView = findViewById(R.id.sites_recyclerview);
        recyclerView.setHasFixedSize(true);

        //set layoutmanager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        final DataSource dataSource = new DataSource();

        //set adapter
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(dataSource.sitesData(), R.layout.cardview_model_full);
        recyclerView.setAdapter(recyclerViewAdapter);

        //set onClick listener with the recyclerview

        recyclerViewAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ContainerActivity.class);
                intent.putExtra("image", dataSource.sitesData().get(recyclerView.getChildAdapterPosition(v)).photo_id);
                intent.putExtra("name", dataSource.sitesData().get(recyclerView.getChildAdapterPosition(v)).name);
                intent.putExtra("local", dataSource.sitesData().get(recyclerView.getChildAdapterPosition(v)).local);
                startActivity(intent);

            }
        });
    }
}
