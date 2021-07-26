package com.example.moop_uas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Button btn_next, btn_show;
    Spinner spinner_bangsal, spinner_penyakit;
    public static PasienDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mendapatkan semua komponen yang dibutuhkan
        btn_next = findViewById(R.id.btn_next);
        btn_show = findViewById(R.id.btn_show);
        spinner_bangsal = findViewById(R.id.spinner_bangsal);
        spinner_penyakit = findViewById(R.id.spinner_penyakit);

        //Inisialisasi database
        db = Room.databaseBuilder(getApplicationContext(), PasienDatabase.class, "uasmoop").allowMainThreadQueries().build();

        //Mengisi pilihan spinner
        ArrayAdapter<CharSequence> adapterBangsal = ArrayAdapter.createFromResource(this,
                R.array.spinner_bangsal_item, android.R.layout.simple_spinner_item);
        adapterBangsal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_bangsal.setAdapter(adapterBangsal);

        ArrayAdapter<CharSequence> adapterPenyakit = ArrayAdapter.createFromResource(this,
                R.array.spinner_penyakit_item, android.R.layout.simple_spinner_item);
        adapterPenyakit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_penyakit.setAdapter(adapterPenyakit);

        //Menambahkan onClickListener untuk button
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBtnClick(v);
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onShowBtnClick(v);
            }
        });
    }

    public void onBtnClick(View view){
        String bangsal = spinner_bangsal.getSelectedItem().toString();
        String penyakit = spinner_penyakit.getSelectedItem().toString();

        Intent i = new Intent(this, ChecklistFormActivity.class);
        i.putExtra("bangsal", bangsal);
        i.putExtra("penyakit", penyakit);
        startActivity(i);
    }

    public void onShowBtnClick(View view){
        Intent i = new Intent(this, ListPasienActivity.class);
        startActivity(i);
    }
}