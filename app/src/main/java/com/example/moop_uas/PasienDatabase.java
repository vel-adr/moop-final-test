package com.example.moop_uas;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = DataPasien.class, version = 1)
public abstract class PasienDatabase extends RoomDatabase {
    public abstract PasienDao pasienDao();
}