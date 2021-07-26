package com.example.moop_uas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    List<Pasien> listPasien;
    Context context;

    public DataAdapter(List<Pasien> listPasien, Context context) {
        this.listPasien = listPasien;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pasien_one_line_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        holder.tv_namaPasien.setText(listPasien.get(position).getNamaPasien());
        holder.tv_bangsal.setText(listPasien.get(position).getBangsal());
        holder.tv_penyakit.setText(listPasien.get(position).getPenyakit());
        switch (listPasien.get(position).getBangsal()){
            case "Bangsal Anak":
                switch (listPasien.get(position).getPenyakit()) {
                    case "Demam Berdarah":
                        holder.cb_gejala1.setText("Temperatur kurang dari 37");
                        if(listPasien.get(position).isGejala1()){
                            holder.cb_gejala1.setChecked(true);
                        }
                        holder.cb_gejala2.setText("Tingkat haemogoblin di atas 35000");
                        if(listPasien.get(position).isGejala2()){
                            holder.cb_gejala2.setChecked(true);
                        }
                        holder.cb_gejala3.setText("Mata tidak cekung");
                        if(listPasien.get(position).isGejala3()){
                            holder.cb_gejala3.setChecked(true);
                        }
                        holder.cb_gejala4.setText("Aktif");
                        if(listPasien.get(position).isGejala4()){
                            holder.cb_gejala4.setChecked(true);
                        }
                        break;

                    case "Tipus":
                        holder.cb_gejala1.setText("Temperatur kurang dari 37");
                        if(listPasien.get(position).isGejala1()){
                            holder.cb_gejala1.setChecked(true);
                        }
                        holder.cb_gejala2.setText("Tingkat leukosit normal");
                        if(listPasien.get(position).isGejala2()){
                            holder.cb_gejala2.setChecked(true);
                        }
                        holder.cb_gejala3.setText("Tidak diare");
                        if(listPasien.get(position).isGejala3()){
                            holder.cb_gejala3.setChecked(true);
                        }
                        holder.cb_gejala4.setText("Nafsu makan kembali");
                        if(listPasien.get(position).isGejala4()){
                            holder.cb_gejala4.setChecked(true);
                        }
                        break;
                }
                break;

            case "Bangsal Dewasa":
                switch (listPasien.get(position).getPenyakit()) {
                    case "Demam Berdarah":
                        holder.cb_gejala1.setText("Temperatur kurang dari 36,5");
                        if(listPasien.get(position).isGejala1()){
                            holder.cb_gejala1.setChecked(true);
                        }
                        holder.cb_gejala2.setText("Tingkat haemogoblin di atas 30000");
                        if(listPasien.get(position).isGejala2()){
                            holder.cb_gejala2.setChecked(true);
                        }
                        holder.cb_gejala3.setText("Mata tidak cekung");
                        if(listPasien.get(position).isGejala3()){
                            holder.cb_gejala3.setChecked(true);
                        }
                        holder.cb_gejala4.setText("Aktif");
                        if(listPasien.get(position).isGejala4()){
                            holder.cb_gejala4.setChecked(true);
                        }
                        break;

                    case "Tipus":
                        holder.cb_gejala1.setText("Temperatur kurang dari 37");
                        if(listPasien.get(position).isGejala1()){
                            holder.cb_gejala1.setChecked(true);
                        }
                        holder.cb_gejala2.setText("Tingkat leukosit normal");
                        if(listPasien.get(position).isGejala2()){
                            holder.cb_gejala2.setChecked(true);
                        }
                        holder.cb_gejala3.setText("Tidak diare");
                        if(listPasien.get(position).isGejala3()){
                            holder.cb_gejala3.setChecked(true);
                        }
                        holder.cb_gejala4.setText("Nafsu makan kembali");
                        if(listPasien.get(position).isGejala4()){
                            holder.cb_gejala4.setChecked(true);
                        }
                        break;
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return listPasien.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_namaPasien, tv_bangsal, tv_penyakit;
        CheckBox cb_gejala1, cb_gejala2, cb_gejala3, cb_gejala4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_namaPasien = itemView.findViewById(R.id.tv_one_namaPasien);
            tv_bangsal = itemView.findViewById(R.id.tv_one_bangsal);
            tv_penyakit = itemView.findViewById(R.id.tv_one_penyakit);
            cb_gejala1 = itemView.findViewById(R.id.cb_one_gejala1);
            cb_gejala2 = itemView.findViewById(R.id.cb_one_gejala2);
            cb_gejala3 = itemView.findViewById(R.id.cb_one_gejala3);
            cb_gejala4 = itemView.findViewById(R.id.cb_one_gejala4);
        }
    }
}
