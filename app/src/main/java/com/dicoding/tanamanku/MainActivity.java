package com.dicoding.tanamanku;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTanaman;
    private final ArrayList<Tanaman> list= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle("TanamanKu");

        init();

        rvTanaman.setHasFixedSize(true);
        list.addAll(Util.getAllPlants());

        showRecyclerList();
    }

    private void init(){
        rvTanaman = findViewById(R.id.rv_tanaman);
        Util util = new Util();
    }

    public void showRecyclerList(){
        rvTanaman.setLayoutManager(new LinearLayoutManager(this));
        ListTanamanAdapter listTanamanAdapter= new ListTanamanAdapter(list);
        rvTanaman.setAdapter(listTanamanAdapter);

        listTanamanAdapter.setOnItemClickCallBack(new ListTanamanAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Tanaman data) {
                showDetailDataTanaman(data);
            }
        });
    }

    public void setActionBarTitle(String title){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_list,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.menu_about:
                showMenuAbout();
                break;
            case R.id.menu_favorite:
                showMenuFavorite();
                break;
        }
    }

    public void showMenuAbout() {
        Intent menuAbout = new Intent(MainActivity.this, MenuAboutActivity.class);
        startActivity(menuAbout);
    }

    private void showMenuFavorite() {
        Intent menuFavorite = new Intent(MainActivity.this, MenuFavoriteActivity.class);
        startActivity(menuFavorite);
    }

    private void showDetailDataTanaman(Tanaman tanaman) {
        Intent showDetailTanaman = new Intent(MainActivity.this, MenuDetailActivity.class);
        showDetailTanaman.putExtra(MenuDetailActivity.ID_TANAMAN, tanaman.getIdTanaman());
        startActivity(showDetailTanaman);
    }

}