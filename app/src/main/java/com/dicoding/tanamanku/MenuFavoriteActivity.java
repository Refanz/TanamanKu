package com.dicoding.tanamanku;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuFavoriteActivity extends AppCompatActivity {

    private RecyclerView rvFavorite;
    private ArrayList<Tanaman> favoritePlants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_favorite);
        setTitle("Favorite Tanaman");

        init();

        rvFavorite.setHasFixedSize(true);
        favoritePlants.addAll(Util.getAllFavoritePlant());

        showRecyclerView();
    }

    private void init(){
        rvFavorite = findViewById(R.id.rv_favorite);
        Util util = new Util();
    }

    private void showRecyclerView(){
        rvFavorite.setLayoutManager(new LinearLayoutManager(MenuFavoriteActivity.this));
        ListTanamanAdapter listTanamanAdapter = new ListTanamanAdapter(favoritePlants);
        rvFavorite.setAdapter(listTanamanAdapter);

        listTanamanAdapter.setOnItemClickCallBack(new ListTanamanAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Tanaman data) {
                showDetailDataTanaman(data);
            }
        });
    }

    private void showDetailDataTanaman(Tanaman tanaman){
        Intent intent = new Intent(MenuFavoriteActivity.this, MenuDetailActivity.class);
        intent.putExtra(MenuDetailActivity.ID_TANAMAN, 0);
        startActivity(intent);
    }
}