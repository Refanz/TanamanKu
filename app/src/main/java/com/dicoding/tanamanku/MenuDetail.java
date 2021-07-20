package com.dicoding.tanamanku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuDetail extends AppCompatActivity implements View.OnClickListener {

    public static final String GAMBAR_TANAMAN = "gambar_tanaman";
    public static final String DETAIL_TANAMAN = "detail_tanaman";
    public static final String NAMA_TANAMAN = "nama_tanaman";
    public static final String NAMA_ILMIAH = "nama_ilmiah";

    @Override
    protected void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.menu_detail);
        setTitle("Detail Tanaman");

        ImageView ivFotoTanaman = findViewById(R.id.iv_foto_t);
        TextView tvDetailTanaman = findViewById(R.id.tv_detail_t);
        TextView tvNamaTanaman = findViewById(R.id.tv_nama_t);
        TextView tvNamaIlmiah = findViewById(R.id.tv_nama_i);

        int gambar = getIntent().getIntExtra(GAMBAR_TANAMAN,0);
        String detail = getIntent().getStringExtra(DETAIL_TANAMAN);
        String nama = getIntent().getStringExtra(NAMA_TANAMAN);
        String ilmiah = getIntent().getStringExtra(NAMA_ILMIAH);


        ivFotoTanaman.setImageResource(gambar);
        tvDetailTanaman.setText(detail);
        tvNamaTanaman.setText(nama);
        tvNamaIlmiah.setText(ilmiah);

        Button btnShare = findViewById(R.id.b_share);
        btnShare.setOnClickListener((View.OnClickListener)this);


    }

    @Override
    public void onClick(View V){
        if(V.getId() == R.id.b_share){
            TextView detail = findViewById(R.id.tv_detail_t);
            String detailTanaman = String.valueOf(detail.getText());

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,detailTanaman);
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent,null);
            startActivity(shareIntent);

        }

    }
}
