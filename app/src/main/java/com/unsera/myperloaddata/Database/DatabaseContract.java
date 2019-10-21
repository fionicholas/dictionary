package com.unsera.myperloaddata.Database;

import android.provider.BaseColumns;

public class DatabaseContract {
    static String TABLE_NAME = "table_kamus";
    static String TABLE_NAME1 = "table_kamus1";

    static final class MahasiswaColumns implements BaseColumns {

        // Mahasiswa nama
        static String NAMA = "nama";
        // Mahasiswa nim
        static String TERJEMAH = "terjemah";

    }
}
