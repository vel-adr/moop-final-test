package com.example.moop_uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class ChecklistFormActivity extends AppCompatActivity {

    EditText et_namaPasien;
    CheckBox cb1, cb2, cb3, cb4;
    Button btn_simpan;
    PasienDao pasienDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist_form);

        //Mendapatkan semua komponen yang dibutuhkan
        cb1 = findViewById(R.id.cb_1);
        cb2 = findViewById(R.id.cb_2);
        cb3 = findViewById(R.id.cb_3);
        cb4 = findViewById(R.id.cb_4);
        et_namaPasien = findViewById(R.id.et_namaPasien);
        btn_simpan = findViewById(R.id.btn_simpan);

        pasienDao = MainActivity.db.pasienDao();

        //Mendapatkan pilihan dari activity sebelumnya
        Intent i = getIntent();
        String bangsal = i.getStringExtra("bangsal");
        String penyakit = i.getStringExtra("penyakit");

        //Meng-assign text checkbox sesuai pilihan dari activity sebelumnya
        switch (bangsal){
            case "Bangsal Anak":
                switch (penyakit) {
                    case "Demam Berdarah":
                        cb1.setText("Temperatur kurang dari 37");
                        cb2.setText("Tingkat haemogoblin di atas 35000");
                        cb3.setText("Mata tidak cekung");
                        cb4.setText("Aktif");
                        break;

                    case "Tipus":
                        cb1.setText("Temperatur kurang dari 37");
                        cb2.setText("Tingkat leukosit normal");
                        cb3.setText("Tidak diare");
                        cb4.setText("Nafsu makan kembali");
                        break;
                }
                break;

            case "Bangsal Dewasa":
                switch (penyakit) {
                    case "Demam Berdarah":
                        cb1.setText("Temperatur kurang dari 36,5");
                        cb2.setText("Tingkat haemogoblin di atas 30000");
                        cb3.setText("Mata tidak cekung");
                        cb4.setText("Aktif");
                        break;

                    case "Tipus":
                        cb1.setText("Temperatur kurang dari 37");
                        cb2.setText("Tingkat leukosit normal");
                        cb3.setText("Tidak diare");
                        cb4.setText("Nafsu makan kembali");
                        break;
                }
                break;
        }

        //Menambahkan onClickListener untuk button
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBtnClick(v, ChecklistFormActivity.this, bangsal, penyakit);
            }
        });


    }

    public void onBtnClick(View view, Context context, String bangsal, String penyakit){
        //Mendapatkan data nama pasien dan kondisinya
        String namaPasien = et_namaPasien.getText().toString();
        boolean cb1_status = cb1.isChecked();
        boolean cb2_status = cb2.isChecked();
        boolean cb3_status = cb3.isChecked();
        boolean cb4_status = cb4.isChecked();

        //Membuat object untuk dimasukkan ke dalam storage
        DataPasien p = new DataPasien();
        p.setNamaPasien(namaPasien);
        p.setBangsal(bangsal);
        p.setPenyakit(penyakit);
        p.setGejala1(cb1_status);
        p.setGejala2(cb2_status);
        p.setGejala3(cb3_status);
        p.setGejala4(cb4_status);

        //Memasukkan data ke dalam storage(database) local
        pasienDao.insertData(p);

        //Munculkan pesan bahwa penyimpanan data berhasil dilakukan
        Toast.makeText(ChecklistFormActivity.this, "Penyimpanan berhasil dilakukan", Toast.LENGTH_SHORT).show();
    }
}