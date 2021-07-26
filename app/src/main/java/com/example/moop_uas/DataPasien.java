package com.example.moop_uas;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "datapasien")
public class DataPasien {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "namaPasien")
    public String namaPasien;

    @ColumnInfo(name = "bangsal")
    public String bangsal;

    @ColumnInfo(name = "penyakit")
    public String penyakit;

    @ColumnInfo(name = "gejala1")
    public boolean gejala1;

    @ColumnInfo(name = "gejala2")
    public boolean gejala2;

    @ColumnInfo(name = "gejala3")
    public boolean gejala3;

    @ColumnInfo(name = "gejala4")
    public boolean gejala4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public String getBangsal() {
        return bangsal;
    }

    public void setBangsal(String bangsal) {
        this.bangsal = bangsal;
    }

    public String getPenyakit() {
        return penyakit;
    }

    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }

    public boolean isGejala1() {
        return gejala1;
    }

    public void setGejala1(boolean gejala1) {
        this.gejala1 = gejala1;
    }

    public boolean isGejala2() {
        return gejala2;
    }

    public void setGejala2(boolean gejala2) {
        this.gejala2 = gejala2;
    }

    public boolean isGejala3() {
        return gejala3;
    }

    public void setGejala3(boolean gejala3) {
        this.gejala3 = gejala3;
    }

    public boolean isGejala4() {
        return gejala4;
    }

    public void setGejala4(boolean gejala4) {
        this.gejala4 = gejala4;
    }
}
