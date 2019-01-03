package com.grupodetec.aventuraprote.View.Food;

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
import com.grupodetec.aventuraprote.View.Sites.*;

public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        //set toolbar conf
        Toolbar toolbar = (Toolbar) findViewById(R.id.food_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        //set recyclerview
        final RecyclerView recyclerView = findViewById(R.id.food_recyclerview);
        recyclerView.setHasFixedSize(true);

        //set layoutmanager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        final DataSource dataSource = new DataSource();

        //set adapter
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(dataSource.foodData(), R.layout.cardview_model_full);
        recyclerView.setAdapter(recyclerViewAdapter);

        //set onClick listener with the recyclerview

        recyclerViewAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.grupodetec.aventuraprote.View.Food.ContainerActivity.class);
                intent.putExtra("image", dataSource.foodData().get(recyclerView.getChildAdapterPosition(v)).photo_id);
                intent.putExtra("name", dataSource.foodData().get(recyclerView.getChildAdapterPosition(v)).name);
                intent.putExtra("local", dataSource.foodData().get(recyclerView.getChildAdapterPosition(v)).local);
                startActivity(intent);

            }
        });
    }
}
