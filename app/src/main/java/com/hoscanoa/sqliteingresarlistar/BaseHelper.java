package com.hoscanoa.sqliteingresarlistar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hernan on 18/03/15.
 */
public class BaseHelper extends SQLiteOpenHelper {

    String table="CREATE TABLE Personas(Id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre Text, Apellido Text, Edad Integer)";

    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
