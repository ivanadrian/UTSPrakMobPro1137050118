package com.example.ivan.utspmobpro1137050118;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Coffeein extends AppCompatActivity {

    Intent tangkap;
    TextView judul , konten;
    ImageView gambar;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_s1);

        judul= (TextView)findViewById(R.id.txtJudul);
        konten= (TextView)findViewById(R.id.txtKonten);
        gambar= (ImageView)findViewById(R.id.imgGambar);
        tangkap = getIntent();


String alamat;

        String paramHasil = tangkap.getStringExtra("param");

        if (paramHasil.equals("0"))
        {
            judul.setText("Cafe' Latte");
            gambar.setImageResource(R.drawable.hiji);
            konten.setText("Coffee with variant of latte. Served between cold and hot water. Enjoy your coffee!");

        }else  if (paramHasil.equals("1"))

        {

            gambar.setImageResource(R.drawable.dua);
            judul.setText("Pure Vanilla");
            konten.setText("Coffee with variant of vanilla. Served with cold water. You Won't even miss the coffee");

        }else  if (paramHasil.equals("2"))
        {
            judul.setText("Vanilla Latte");
            gambar.setImageResource(R.drawable.tilu);
            konten.setText("Coffee with variant of vanilla and latte. Served between cold and hot water. Enjoy your coffee!");

        }else  if (paramHasil.equals("3")) {
            judul.setText("Espresso");
            gambar.setImageResource(R.drawable.opat);
            konten.setText("Coffee with variant of Espresso. Served between cold and hot water. Enjoy your coffee!");
        }


    }
}
