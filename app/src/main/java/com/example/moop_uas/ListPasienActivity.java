package com.example.moop_uas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListPasienActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<DataPasien> dataPasien;
    private List<Pasien> listPasien;
    private TextView tv_kosong;
    PasienDao pasienDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pasien);

        pasienDao = MainActivity.db.pasienDao();
        listPasien = new ArrayList<>();

        tv_kosong = findViewById(R.id.tv_dataKosong);
        recyclerView = findViewById(R.id.rv_listPasien);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        dataPasien = pasienDao.getAll();

        if (dataPasien.size() > 0){
            tv_kosong.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            Toast.makeText(ListPasienActivity.this, "Success", Toast.LENGTH_SHORT).show();
            for (int i = 0; i < dataPasien.size(); i++) {
                Pasien tmp = new Pasien(dataPasien.get(i).getNamaPasien(), dataPasien.get(i).getBangsal(), dataPasien.get(i).getPenyakit(), dataPasien.get(i).isGejala1(), dataPasien.get(i).isGejala2(), dataPasien.get(i).isGejala3(), dataPasien.get(i).isGejala4());
                listPasien.add(tmp);
            }
            adapter = new DataAdapter(listPasien, ListPasienActivity.this);
            recyclerView.setAdapter(adapter);
        }
    }
}