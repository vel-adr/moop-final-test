package com.example.moop_uas;

public class Pasien {
    private String namaPasien;
    private String bangsal;
    private String penyakit;
    private boolean gejala1;
    private boolean gejala2;
    private boolean gejala3;
    private boolean gejala4;

    public Pasien(String namaPasien, String bangsal, String penyakit, boolean gejala1, boolean gejala2, boolean gejala3, boolean gejala4) {
        this.namaPasien = namaPasien;
        this.bangsal = bangsal;
        this.penyakit = penyakit;
        this.gejala1 = gejala1;
        this.gejala2 = gejala2;
        this.gejala3 = gejala3;
        this.gejala4 = gejala4;
    }

    @Override
    public String toString() {
        return "Pasien{" +
                "namaPasien='" + namaPasien + '\'' +
                ", bangsal='" + bangsal + '\'' +
                ", penyakit='" + penyakit + '\'' +
                ", gejala1=" + gejala1 +
                ", gejala2=" + gejala2 +
                ", gejala3=" + gejala3 +
                ", gejala4=" + gejala4 +
                '}';
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
