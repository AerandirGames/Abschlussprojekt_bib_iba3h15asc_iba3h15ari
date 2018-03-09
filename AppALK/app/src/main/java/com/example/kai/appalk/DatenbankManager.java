package com.example.kai.appalk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Daniel on 31.01.2018.
 */

public class DatenbankManager extends SQLiteOpenHelper{


    private Cursor res;
    public static final String DB_NAME = "interneDb";
    public static final int DB_VERSION = 1;
    public static final String TABLE_EINSTELLUNGEN = "einstellungen";
    public static final String AUTO_LOGIN = "autologin";
    public static final String ID = "id";
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

    public void updateAutoLogFalse() {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AUTO_LOGIN, 0);

        db.update(TABLE_EINSTELLUNGEN,values, ID + " = ?", new String[]{String.valueOf(1)});
    }

    public void updateAutoLogTrue()
    {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AUTO_LOGIN, 1);

        db.update(TABLE_EINSTELLUNGEN,values, ID + " = ?", new String[]{String.valueOf(1)});

}
    public Cursor getSwitchValue()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        res = db.rawQuery("select * from " + TABLE_EINSTELLUNGEN,null);
        return res;
    }
    public void insertV()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(AUTO_LOGIN,0);
        long result = db.insert(TABLE_EINSTELLUNGEN,"1",cv);
        if(result == -1)
        {
            Log.d("","fail");
        }
        else
        {
            Log.d("","nice");
        }
    }
}


