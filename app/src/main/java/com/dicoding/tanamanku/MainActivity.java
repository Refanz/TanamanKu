package com.dicoding.tanamanku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTanaman;
    private final ArrayList<Tanaman> list= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle("TanamanKu");

        rvTanaman = findViewById(R.id.rv_tanaman);
        rvTanaman.setHasFixedSize(true);
        list.addAll(DataTanaman.getListTanaman());

        showRecyclerList();

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
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);

    }

    public void showMenuAbout(){
        Intent menuAbout = new Intent(MainActivity.this,MenuAbout.class);
        startActivity(menuAbout);
    }

    public void setMode(int selectedMode){
        switch (selectedMode){
            case R.id.menu_about:
                showMenuAbout();
                break;
        }
    }

    private void showDetailDataTanaman(Tanaman tanaman){
        Intent showDetailTanaman = new Intent(MainActivity.this,MenuDetail.class);
        showDetailTanaman.putExtra(MenuDetail.GAMBAR_TANAMAN,tanaman.getFotoTanaman());
        showDetailTanaman.putExtra(MenuDetail.DETAIL_TANAMAN, tanaman.getDetailTanaman());
        showDetailTanaman.putExtra(MenuDetail.NAMA_TANAMAN,tanaman.getNamaTanaman());
        showDetailTanaman.putExtra(MenuDetail.NAMA_ILMIAH,tanaman.getNamaIlmiah());
        startActivity(showDetailTanaman);

    }
}