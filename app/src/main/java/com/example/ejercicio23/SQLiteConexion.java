package com.example.ejercicio23;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteConexion  extends SQLiteOpenHelper{

    public SQLiteConexion(Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Config.CreateTableCardsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Config.DropTableCardsTable);
        onCreate(db);
    }
    public Cursor getAll() {
        return(getReadableDatabase().rawQuery("SELECT * FROM cards",null));
    }
    public void insert(byte[] bytes, String description)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(Config.image,bytes);
        contentValues.put(Config.description,description);
        getWritableDatabase().insert(Config.cards_table,Config.id,contentValues);
    }
    public byte[] getImage(Cursor cursor)
    {
        return(cursor.getBlob(1));
    }
}
