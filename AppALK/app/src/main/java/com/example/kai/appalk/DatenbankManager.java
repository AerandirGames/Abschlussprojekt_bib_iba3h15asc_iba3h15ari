package com.example.kai.appalk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Daniel on 31.01.2018.
 */

public class DatenbankManager extends SQLiteOpenHelper{


    public static final String DB_NAME = "interne.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_EINSTELLUNGEN = "einstellungen";
    public static final String AUTO_LOGIN = "autologin";
    public static final String ID = "id";
    public int ph;
    public static final String SQL_CREATE =
            "create table " +  TABLE_EINSTELLUNGEN + "(" +
                    ID + " integer primary key autoincrement, " +
                    AUTO_LOGIN + " integer);";

    public DatenbankManager(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(SQL_CREATE);

        }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2)
    {

    }

    public void updateAutoLog(boolean b)
    {

        if(b)
        {
            ph = 1;
        }
        else
        {
            ph=0;
        }
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AUTO_LOGIN, ph);

        db.update(TABLE_EINSTELLUNGEN,values, AUTO_LOGIN + " = 1", new String[]{String.valueOf(ph)});
        db.update(TABLE_EINSTELLUNGEN,values, AUTO_LOGIN + " = 0", new String[]{String.valueOf(ph)});
        db.update(TABLE_EINSTELLUNGEN,values, AUTO_LOGIN + " = null", new String[]{String.valueOf(ph)});
    }

    public int getSwitchValue()
    {
        int zurueck = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_EINSTELLUNGEN, new String[]{AUTO_LOGIN},ID + "=1",new String[]{"1"},null,null,null,null);
        if(cursor != null)
        {
            cursor.moveToFirst();
        }

        zurueck = cursor.getInt(1);
        return zurueck;


    }
}


