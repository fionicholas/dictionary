package com.unsera.myperloaddata.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static com.unsera.myperloaddata.Database.DatabaseContract.MahasiswaColumns.NAMA;
import static com.unsera.myperloaddata.Database.DatabaseContract.MahasiswaColumns.TERJEMAH;
import static com.unsera.myperloaddata.Database.DatabaseContract.TABLE_NAME;
import static com.unsera.myperloaddata.Database.DatabaseContract.TABLE_NAME1;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "dbkampus";

    private static final int DATABASE_VERSION = 1;

    public static String CREATE_TABLE_INDONESIA = "create table "+TABLE_NAME+
            " ("+_ID+" integer primary key autoincrement, " +
            NAMA+" text not null, " +
            TERJEMAH+" text not null);";

    public static String CREATE_TABLE_ENGLISH = "create table "+TABLE_NAME1+
            " ("+_ID+" integer primary key autoincrement, " +
            NAMA+" text not null, " +
            TERJEMAH+" text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_INDONESIA);
        db.execSQL(CREATE_TABLE_ENGLISH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }
}
