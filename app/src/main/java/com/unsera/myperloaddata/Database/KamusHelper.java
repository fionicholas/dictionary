package com.unsera.myperloaddata.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.unsera.myperloaddata.Model.KamusModel;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;
import static com.unsera.myperloaddata.Database.DatabaseContract.MahasiswaColumns.NAMA;
import static com.unsera.myperloaddata.Database.DatabaseContract.MahasiswaColumns.TERJEMAH;
import static com.unsera.myperloaddata.Database.DatabaseContract.TABLE_NAME;
import static com.unsera.myperloaddata.Database.DatabaseContract.TABLE_NAME1;

public class KamusHelper {
    private Context context;
    private DatabaseHelper dataBaseHelper;

    private SQLiteDatabase database;

    public KamusHelper(Context context){
        this.context = context;
    }

    public KamusHelper open() throws SQLException {
        dataBaseHelper = new DatabaseHelper(context);
        database = dataBaseHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dataBaseHelper.close();
    }

    public ArrayList<KamusModel> getDataByName(String nama){
        String result = "";
        Cursor cursor = database.query(TABLE_NAME,null,NAMA+" LIKE ?",new String[]{"%"+nama+"%"},null,null,_ID + " ASC",null);
        cursor.moveToFirst();
        ArrayList<KamusModel> arrayList = new ArrayList<>();
        KamusModel kamusModel;
        if (cursor.getCount()>0) {
            do {
                kamusModel = new KamusModel();
                kamusModel.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                kamusModel.setName(cursor.getString(cursor.getColumnIndexOrThrow(NAMA)));
                kamusModel.setKata(cursor.getString(cursor.getColumnIndexOrThrow(TERJEMAH)));

                arrayList.add(kamusModel);
                cursor.moveToNext();

            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public ArrayList<KamusModel> getDataByName1(String nama){
        String result = "";
        Cursor cursor1 = database.query(TABLE_NAME1,null,NAMA+" LIKE ?",new String[]{"%"+nama+"%"},null,null,_ID + " ASC",null);
        cursor1.moveToFirst();
        ArrayList<KamusModel> arrayList1 = new ArrayList<>();
        KamusModel kamusModel;
        if (cursor1.getCount()>0) {
            do {
                kamusModel = new KamusModel();
                kamusModel.setId(cursor1.getInt(cursor1.getColumnIndexOrThrow(_ID)));
                kamusModel.setName(cursor1.getString(cursor1.getColumnIndexOrThrow(NAMA)));
                kamusModel.setKata(cursor1.getString(cursor1.getColumnIndexOrThrow(TERJEMAH)));

                arrayList1.add(kamusModel);
                cursor1.moveToNext();

            } while (!cursor1.isAfterLast());
        }
        cursor1.close();
        return arrayList1;
    }

    public ArrayList<KamusModel> getAllData(){
        Cursor cursor = database.query(TABLE_NAME,null,null,null,null,null,_ID+ " ASC",null);
        cursor.moveToFirst();
        ArrayList<KamusModel> arrayList = new ArrayList<>();
        KamusModel kamusModel;
        if (cursor.getCount()>0) {
            do {
                kamusModel = new KamusModel();
                kamusModel.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                kamusModel.setName(cursor.getString(cursor.getColumnIndexOrThrow(NAMA)));
                kamusModel.setKata(cursor.getString(cursor.getColumnIndexOrThrow(TERJEMAH)));


                arrayList.add(kamusModel);
                cursor.moveToNext();


            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public ArrayList<KamusModel> getAllData1(){
        Cursor cursor1 = database.query(TABLE_NAME1,null,null,null,null,null,_ID+ " ASC",null);
        cursor1.moveToFirst();
        ArrayList<KamusModel> arrayList1 = new ArrayList<>();
        KamusModel kamusModel1;
        if (cursor1.getCount()>0) {
            do {
                kamusModel1 = new KamusModel();
                kamusModel1.setId(cursor1.getInt(cursor1.getColumnIndexOrThrow(_ID)));
                kamusModel1.setName(cursor1.getString(cursor1.getColumnIndexOrThrow(NAMA)));
                kamusModel1.setKata(cursor1.getString(cursor1.getColumnIndexOrThrow(TERJEMAH)));


                arrayList1.add(kamusModel1);
                cursor1.moveToNext();


            } while (!cursor1.isAfterLast());
        }
        cursor1.close();
        return arrayList1;
    }

    public long insert(KamusModel kamusModel){
        ContentValues initialValues =  new ContentValues();
        initialValues.put(NAMA, kamusModel.getName());
        initialValues.put(TERJEMAH, kamusModel.getKata());
        return database.insert(TABLE_NAME, null, initialValues);
    }

    public long insert1(KamusModel kamusModel){
        ContentValues initialValues =  new ContentValues();
        initialValues.put(NAMA, kamusModel.getName());
        initialValues.put(TERJEMAH, kamusModel.getKata());
        return database.insert(TABLE_NAME1, null, initialValues);
    }

    public void beginTransaction(){
        database.beginTransaction();
    }

    public void setTransactionSuccess(){
        database.setTransactionSuccessful();
    }

    public void endTransaction(){
        database.endTransaction();
    }

    public void insertTransaction(KamusModel kamusModel){
        String sql = "INSERT INTO "+TABLE_NAME+" ("+NAMA+", "+TERJEMAH
                +") VALUES (?, ?)";
        SQLiteStatement stmt = database.compileStatement(sql);
        stmt.bindString(1, kamusModel.getName());
        stmt.bindString(2, kamusModel.getKata());
        stmt.execute();
        stmt.clearBindings();

    }

    public void insertTransaction1(KamusModel kamusModel){
        String sql = "INSERT INTO "+TABLE_NAME1+" ("+NAMA+", "+TERJEMAH
                +") VALUES (?, ?)";
        SQLiteStatement stmt = database.compileStatement(sql);
        stmt.bindString(1, kamusModel.getName());
        stmt.bindString(2, kamusModel.getKata());
        stmt.execute();
        stmt.clearBindings();

    }

    public int update(KamusModel kamusModel){
        ContentValues args = new ContentValues();
        args.put(NAMA, kamusModel.getName());
        args.put(TERJEMAH, kamusModel.getKata());
        return database.update(TABLE_NAME, args, _ID + "= '" + kamusModel.getId() + "'", null);
    }

    public int update1(KamusModel kamusModel){
        ContentValues args = new ContentValues();
        args.put(NAMA, kamusModel.getName());
        args.put(TERJEMAH, kamusModel.getKata());
        return database.update(TABLE_NAME1, args, _ID + "= '" + kamusModel.getId() + "'", null);
    }


    public int delete(int id){
        return database.delete(TABLE_NAME, _ID + " = '"+id+"'", null);
    }
}