package com.grupodetec.aventuraprote.View.Home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.grupodetec.aventuraprote.R;
import com.grupodetec.aventuraprote.View.CardViewModel;
import com.grupodetec.aventuraprote.View.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    List<CardViewModel> sitescardViewModels;
    List<CardViewModel> foodcardViewModels;
    List<CardViewModel> hotelscardViewModels;
    List<CardViewModel> adventurViewModels;
    List<CardViewModel> nightcardViewModels;

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


        initializeData();

        /*set Adapter*/
        RecyclerViewAdapter sitesAdapter = new RecyclerViewAdapter(sitescardViewModels);
        sitesRecyclerView.setAdapter(sitesAdapter);

        RecyclerViewAdapter foodAdapter = new RecyclerViewAdapter(foodcardViewModels);
        foodRecyclerView.setAdapter(foodAdapter);

        RecyclerViewAdapter hotelsAdapter = new RecyclerViewAdapter(hotelscardViewModels);
        hotelsRecyclerView.setAdapter(hotelsAdapter);

        RecyclerViewAdapter adventureAdapter = new RecyclerViewAdapter(adventurViewModels);
        adventureRecyclerView.setAdapter(adventureAdapter);

        RecyclerViewAdapter nightAdapter = new RecyclerViewAdapter(nightcardViewModels);
        nightRecyclerView.setAdapter(nightAdapter);

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
        return false;
    }

    private void initializeData() {
        sitescardViewModels = new ArrayList<>();
        sitescardViewModels.add(new CardViewModel(R.drawable.site1, "Cabellera venus", "Media Cuesta"));
        sitescardViewModels.add(new CardViewModel(R.drawable.site3, "Microcuenca", "Potreros"));
        sitescardViewModels.add(new CardViewModel(R.drawable.site4, "Mirador Cocorná", "Chorrera"));

        foodcardViewModels = new ArrayList<>();
        foodcardViewModels.add(new CardViewModel(R.drawable.food1, "Asado al Carbón", "Restaurante 1"));
        foodcardViewModels.add(new CardViewModel(R.drawable.food2, "Hamburguesa de Pollo", "Restaurante 2"));
        foodcardViewModels.add(new CardViewModel(R.drawable.food3, "Pizza Artesanal", "Restaurante 3"));
        foodcardViewModels.add(new CardViewModel(R.drawable.food4, "Punta de Anca", "Restaurante 4"));

        hotelscardViewModels = new ArrayList<>();
        hotelscardViewModels.add(new CardViewModel(R.drawable.hotel1, "Hotel 1", "Parque principal"));
        hotelscardViewModels.add(new CardViewModel(R.drawable.hotel2, "Hotel 2", "Parque principal"));
        hotelscardViewModels.add(new CardViewModel(R.drawable.hotel3, "Hotel 3", "Cra 21 34-32"));
        hotelscardViewModels.add(new CardViewModel(R.drawable.hotel4, "Hotel 4", "Calle 19 23-22"));

        adventurViewModels = new ArrayList<>();
        adventurViewModels.add(new CardViewModel(R.drawable.adventure1, "Downhill", "Parque principal"));
        adventurViewModels.add(new CardViewModel(R.drawable.adventure2, "Parapente", "Parque principal"));
        adventurViewModels.add(new CardViewModel(R.drawable.adventure3, "Rafting", "Cra 21 34-32"));
        adventurViewModels.add(new CardViewModel(R.drawable.adventure4, "Rappel", "Calle 19 23-22"));

        nightcardViewModels = new ArrayList<>();
        nightcardViewModels.add(new CardViewModel(R.drawable.night1, "Cocktails", "Parque principal"));
        nightcardViewModels.add(new CardViewModel(R.drawable.night2, "Disco 2", "Parque principal"));
        nightcardViewModels.add(new CardViewModel(R.drawable.night3, "Disco 3", "Cra 21 34-32"));
        nightcardViewModels.add(new CardViewModel(R.drawable.night4, "Disco 4", "Calle 19 23-22"));
    }
}