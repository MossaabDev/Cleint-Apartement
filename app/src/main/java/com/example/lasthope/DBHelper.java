package com.example.lasthope;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String USER_TABLE = "USER_TABLE";

    public DBHelper(Context context) {
        super(context, "db.user", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE "+ USER_TABLE+ " (ID TEXT , NAME TEXT, EMAIL TEXT, TLF TEXT, ADRESS TEXT, PAID INTEGER, REST INTEGER, PROGRESS INTEGER)";
        db.execSQL(create);
    }

    public void setUser(User user){
        String read = "SELECT * FROM " + USER_TABLE;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(read, null);
        ContentValues cv = new ContentValues();
        db.delete(USER_TABLE, null, null);
        if (!cursor.moveToFirst()) {
            cv.put("NAME", user.getName());
            cv.put("ID", user.getId());
            cv.put("TLF", user.getTlf());
            cv.put("ADRESS", user.getAdress());
            cv.put("EMAIL", user.getEmail());
            cv.put("PAID", user.getPaied());
            cv.put("REST", user.getRest());
            cv.put("PROGRESS", user.getProgress());
            db.insert(USER_TABLE, null, cv);
            System.out.println(user.getName());
        }
    }

    public User getUser(){
        User user = new User();
        String read = "SELECT * FROM USER_TABLE";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(read, null);
        while(cursor.moveToNext()){
            user.setName(cursor.getString(1));
            user.setEmail(cursor.getString(2));
            user.setTlf(cursor.getString(3));
            user.setPaied(5);
            user.setProgress(7);
            user.setRest(6);
        }
        System.out.println(user.toString());
        return user;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
