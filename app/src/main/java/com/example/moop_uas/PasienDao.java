package com.example.moop_uas;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PasienDao {
    @Query("SELECT * FROM datapasien")
    public List<DataPasien> getAll();

    @Query("DELETE FROM datapasien where id = :id")
    public void deleteData(int id);

    @Insert
    public void insertData(DataPasien pasien);
}
