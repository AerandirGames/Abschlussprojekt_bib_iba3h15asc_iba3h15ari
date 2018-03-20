package com.example.kai.appalk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kai on 17.03.2018.
 */

public class UserDatenbankManager extends SQLiteOpenHelper
{
    private static final String DB_NAME = "UserDatabase";
    private static final int DB_VERSION = 2;
    private static final String COL0 = "id";
    private static final String COL1 = "userName";
    private static final String COL2 = "userVorname";
    private static final String COL3 = "userAnrede";
    private static final String COL4 = "userTitel";
    private static final String COL5 = "userTel";
    private static final String COL6 = "userEmail";
    private static final String COL7 = "userPraxisName";
    private static final String COL8 = "userPraxisAdresse";
    private static final String COL9 = "userPraxisPlz";
    private static final String COL10 = "userPraxisStadt";
    private static final String COL11 = "userPraxisTel";
    private static final String COL12 = "userPraxisAdresszusatz";
    private static final String COL13 = "userPw";
    private static final String SQL_CREATE =
            "CREATE TABLE " + DB_NAME + "(" + COL0 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL1 + " TEXT, " + COL2 + " TEXT, " + COL3 + " TEXT, " +
                    COL4 + " TEXT, " + COL5 + " TEXT, " + COL6 + " TEXT, " +
                    COL7 + " TEXT, " + COL8 + " TEXT, " + COL9 + " TEXT, " +
                    COL10 + " TEXT, " + COL11 + " TEXT, " + COL12 + " TEXT, " +
                    COL13 + " TEXT);";

    public UserDatenbankManager(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }

    public void insertUser(String name, String vorname, String anrede, String titel,
                           String tel, String mail, String pName, String pAdresse,
                           String pPLZ, String pStadt, String pTel, String pAdrZs,
                           String pw)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL0, 0);
        contentValues.put(COL1, name);
        contentValues.put(COL2, vorname);
        contentValues.put(COL3, anrede);
        contentValues.put(COL4, titel);
        contentValues.put(COL5, tel);
        contentValues.put(COL6, mail);
        contentValues.put(COL7, pName);
        contentValues.put(COL8, pAdresse);
        contentValues.put(COL9, pPLZ);
        contentValues.put(COL10, pStadt);
        contentValues.put(COL11, pTel);
        contentValues.put(COL12, pAdrZs);
        contentValues.put(COL13, pw);
        db.insert(DB_NAME, null, contentValues);
    }

    public void deleteUser()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_NAME, null, null);
    }

    public void updateUser(String name, String vorname, String anrede, String titel,
                           String tel, String mail, String pName, String pAdresse,
                           String pPLZ, String pStadt, String pTel, String pAdrZs,
                           String pw)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL0, 0);
        contentValues.put(COL1, name);
        contentValues.put(COL2, vorname);
        contentValues.put(COL3, anrede);
        contentValues.put(COL4, titel);
        contentValues.put(COL5, tel);
        contentValues.put(COL6, mail);
        contentValues.put(COL7, pName);
        contentValues.put(COL8, pAdresse);
        contentValues.put(COL9, pPLZ);
        contentValues.put(COL10, pStadt);
        contentValues.put(COL11, pTel);
        contentValues.put(COL12, pAdrZs);
        contentValues.put(COL13, pw);
        db.update(DB_NAME, contentValues, "id=0", null);
    }

    public Cursor getUser()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + DB_NAME, null);
        res.close();
        return res;
    }

    public String getEmail()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + COL6 + " from " + DB_NAME, null);
        String result = "";
        if (res.moveToFirst())
        {
            do
            {
                result = res.getString(res.getColumnIndex("userEmail"));
            }
            while (res.moveToNext());
        }
        res.close();
        return result;
    }

    public String getPw()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + COL13 + " from " + DB_NAME, null);
        String result = "";
        if (res.moveToFirst())
        {
            do
            {
                result = res.getString(res.getColumnIndex("userPw"));
            }
            while (res.moveToNext());
        }
        res.close();
        return result;
    }

    public void updateEmail(String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL6, email);

        db.update(DB_NAME, values, null, null);
    }

    public void updateTel(String tel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL5, tel);

        db.update(DB_NAME, values, null, null);
    }

    public void updateName(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL1, name);

        db.update(DB_NAME, values, null, null);
    }

    public void updatePraxis(String pName, String pAdresse, String pPLZ, String pStadt,
                             String pTel, String pAdrZs)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL7, pName);
        values.put(COL8, pAdresse);
        values.put(COL9, pPLZ);
        values.put(COL10, pStadt);
        values.put(COL11, pTel);
        values.put(COL12, pAdrZs);

        db.update(DB_NAME, values, null, null);
    }

    public void updateTitel(String titel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL4, titel);

        db.update(DB_NAME, values, null, null);
    }

    public void updatePasswort(String pw)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL13, pw);

        db.update(DB_NAME, values, null, null);
    }
}
