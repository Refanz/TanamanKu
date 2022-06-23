package com.dicoding.tanamanku;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MenuDetailActivity extends AppCompatActivity {

    public static final String ID_TANAMAN = "id_tanaman";
    public static final String GAMBAR_TANAMAN = "gambar_tanaman";
    public static final String DETAIL_TANAMAN = "detail_tanaman";
    public static final String NAMA_TANAMAN = "nama_tanaman";
    public static final String NAMA_ILMIAH = "nama_ilmiah";

    private ImageView ivFotoTanaman;
    private TextView tvDetailTanaman, tvNamaTanaman, tvNamaIlmiah, tvTanaman;
    private ImageButton btnShare, btnFavorite;
    private boolean isFavorite;
    private Tanaman incomingPlant;

    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_menu_detail);
        setTitle("Detail Tanaman");

        init();

        setFavorite();

        int id = getIntent().getIntExtra(ID_TANAMAN, 0);

        searchPlant(id);

//        //int id = getIntent().getIntExtra(ID_TANAMAN, 0);
//        int gambar = getIntent().getIntExtra(GAMBAR_TANAMAN, 0);
//        String detail = getIntent().getStringExtra(DETAIL_TANAMAN);
//        String nama = getIntent().getStringExtra(NAMA_TANAMAN);
//        String ilmiah = getIntent().getStringExtra(NAMA_ILMIAH);
//
//        //Log.d(TAG, "ID : "+id);
//
//        ivFotoTanaman.setImageResource(gambar);
//        tvDetailTanaman.setText(detail);
//        tvNamaTanaman.setText(nama);
//        tvNamaIlmiah.setText(ilmiah);
//        tvTanaman.setText(nama);

        btnShare.setOnClickListener(view -> {
            btnShareTapped();
        });

        btnFavorite.setOnClickListener(view -> {
          btnFavoriteTapped();
        });
    }

    private void init() {
        ivFotoTanaman = findViewById(R.id.iv_foto_t);
        tvDetailTanaman = findViewById(R.id.tv_detail_t);
        tvNamaTanaman = findViewById(R.id.tv_nama_t);
        tvNamaIlmiah = findViewById(R.id.tv_nama_i);
        btnShare = findViewById(R.id.b_share);
        btnFavorite = findViewById(R.id.b_favorite);
        tvTanaman = findViewById(R.id.tv_t);
        isFavorite = false;
        Util util = new Util();
    }

    private void btnShareTapped () {
        String detailTanaman = String.valueOf(tvDetailTanaman.getText());
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, detailTanaman);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }

    private void btnFavoriteTapped () {
        int id = getIntent().getIntExtra(ID_TANAMAN, 0);

        ArrayList<Tanaman> plants = Util.getAllPlants();
        ArrayList<Tanaman> favoritePlants = Util.getAllFavoritePlant();

        for(Tanaman t: plants){
            if(t.getIdTanaman() == id){
                incomingPlant = t;
            }
        }

        if (isFavorite == false) {
            btnFavorite.setImageResource(R.drawable.ic_fill_star);

            Toast.makeText(MenuDetailActivity.this, "Add to favorite", Toast.LENGTH_SHORT).show();
            Util.addFavoritePlant(incomingPlant);

            isFavorite = true;
        } else {
            btnFavorite.setImageResource(R.drawable.ic_empty_star);
            Toast.makeText(MenuDetailActivity.this, "Remove from favorite", Toast.LENGTH_SHORT).show();
            Util.removeFavoritePlant(incomingPlant);
            isFavorite = false;
        }
    }

    private void setFavorite(){
        int id = getIntent().getIntExtra(ID_TANAMAN, 0);
        ArrayList<Tanaman> favoritePlants = Util.getAllFavoritePlant();
        for(Tanaman t: favoritePlants){
            if(t.getIdTanaman() == id){
                btnFavorite.setImageResource(R.drawable.ic_fill_star);
                isFavorite = true;
            }
        }
    }

    private void searchPlant(int id){
        for(Tanaman t: Util.getAllPlants()){
            if(t.getIdTanaman() == id){
                ivFotoTanaman.setImageResource(t.getFotoTanaman());
                tvDetailTanaman.setText(t.getDetailTanaman());
                tvNamaTanaman.setText(t.getNamaTanaman());
                tvNamaIlmiah.setText(t.getNamaIlmiah());
                tvTanaman.setText(t.getNamaTanaman());
            }
        }
    }

}
