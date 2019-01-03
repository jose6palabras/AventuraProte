package com.grupodetec.aventuraprote.View.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.grupodetec.aventuraprote.Pojo.DataSource;
import com.grupodetec.aventuraprote.R;
import com.grupodetec.aventuraprote.View.Adventure.AdventureActivity;
import com.grupodetec.aventuraprote.View.Cocorna.CocornaActivity;
import com.grupodetec.aventuraprote.View.CocornaGram.CocornagramActivity;
import com.grupodetec.aventuraprote.View.DulceAventura.DulceAventuraActivity;
import com.grupodetec.aventuraprote.View.Food.FoodActivity;
import com.grupodetec.aventuraprote.View.Hotel.HotelActivity;
import com.grupodetec.aventuraprote.View.Night.NightActivity;
import com.grupodetec.aventuraprote.View.RecyclerViewAdapter;
import com.grupodetec.aventuraprote.View.Sites.SitesActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuhome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        //left menu for drawer layout
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerlayoutmenuhome);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Navigation View implementation
        NavigationView navigationView = (NavigationView) findViewById(R.id.home_navigationview);
        navigationView.setNavigationItemSelectedListener(this);

        //RecyclerView implementation
        /* set RecyclerView*/
        RecyclerView sitesRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_sites);
        sitesRecyclerView.setHasFixedSize(true);

        RecyclerView foodRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_food);
        foodRecyclerView.setHasFixedSize(true);

        RecyclerView hotelsRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_hotels);
        hotelsRecyclerView.setHasFixedSize(true);

        RecyclerView adventureRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_adventure);
        hotelsRecyclerView.setHasFixedSize(true);

        RecyclerView nightRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_night);
        hotelsRecyclerView.setHasFixedSize(true);

        /*set LayoutManager*/
        LinearLayoutManager sitesLayoutManager = new LinearLayoutManager(this);
        sitesLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        sitesRecyclerView.setLayoutManager(sitesLayoutManager);

        LinearLayoutManager foodLayoutManager = new LinearLayoutManager(this);
        foodLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        foodRecyclerView.setLayoutManager(foodLayoutManager);

        LinearLayoutManager hotelsLayoutManager = new LinearLayoutManager(this);
        hotelsLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        hotelsRecyclerView.setLayoutManager(hotelsLayoutManager);

        LinearLayoutManager adventureLayoutManager = new LinearLayoutManager(this);
        adventureLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        adventureRecyclerView.setLayoutManager(adventureLayoutManager);

        LinearLayoutManager nightLayoutManager = new LinearLayoutManager(this);
        nightLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        nightRecyclerView.setLayoutManager(nightLayoutManager);

        DataSource dataSource = new DataSource();


        /*set Adapter*/
        RecyclerViewAdapter sitesAdapter = new RecyclerViewAdapter(dataSource.sitesData(), R.layout.cardview_model);
        sitesRecyclerView.setAdapter(sitesAdapter);

        RecyclerViewAdapter foodAdapter = new RecyclerViewAdapter(dataSource.foodData(), R.layout.cardview_model);
        foodRecyclerView.setAdapter(foodAdapter);

        RecyclerViewAdapter hotelsAdapter = new RecyclerViewAdapter(dataSource.hotelData(), R.layout.cardview_model);
        hotelsRecyclerView.setAdapter(hotelsAdapter);

        RecyclerViewAdapter adventureAdapter = new RecyclerViewAdapter(dataSource.adventureData(), R.layout.cardview_model);
        adventureRecyclerView.setAdapter(adventureAdapter);

        RecyclerViewAdapter nightAdapter = new RecyclerViewAdapter(dataSource.nightData(), R.layout.cardview_model);
        nightRecyclerView.setAdapter(nightAdapter);

    }
    public void cocornalink (View view){
        Intent intent = new Intent(this, CocornaActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerlayoutmenuhome);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home_item_cocorna) {
            // Handle the camera action
            Intent intent = new Intent(getApplicationContext(), CocornaActivity.class);
            startActivity(intent);
        } else if (id == R.id.home_item_places) {
            Intent intent = new Intent(getApplicationContext(), SitesActivity.class);
            startActivity(intent);

        } else if (id == R.id.home_item_do) {
            Intent intent = new Intent(getApplicationContext(), DulceAventuraActivity.class);
            startActivity(intent);

        } else if (id == R.id.home_item_restaurants) {
            Intent intent = new Intent(getApplicationContext(), FoodActivity.class);
            startActivity(intent);

        } else if (id == R.id.home_item_hotel) {
            Intent intent = new Intent(getApplicationContext(), HotelActivity.class);
            startActivity(intent);

        } else if (id == R.id.home_item_sunday) {

        }else if (id == R.id.home_item_nightlife) {
            Intent intent = new Intent(getApplicationContext(), NightActivity.class);
            startActivity(intent);

        }else if (id == R.id.home_item_adventure) {
            Intent intent = new Intent(getApplicationContext(), AdventureActivity.class);
            startActivity(intent);

        }else if (id == R.id.home_item_community) {
            Intent intent = new Intent(getApplicationContext(), CocornagramActivity.class);
            startActivity(intent);

        }else if (id == R.id.home_item_calendar) {
            Toast.makeText(this, "Dímelo papi!", Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerlayoutmenuhome);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}