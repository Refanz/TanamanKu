package com.dicoding.tanamanku;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuAboutActivity extends AppCompatActivity {

    private TextView tvDeskripsiDiri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_about);
        setTitle("About");

        tvDeskripsiDiri = findViewById(R.id.tv_deskripsi_diri);

        tvDeskripsiDiri.setText("Saya adalah seorang mahasiswa yang mengambil jurusan Teknik Komputer. " +
                "Saya berminat di bidang pengembangan aplikasi android");
    }

}
