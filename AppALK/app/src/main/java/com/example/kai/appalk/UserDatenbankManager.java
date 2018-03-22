package com.example.kai.appalk;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
    private static final String COL14 = "userNID";
    private static final String SQL_CREATE =
            "CREATE TABLE " + DB_NAME + "(" + COL0 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL1 + " TEXT, " + COL2 + " TEXT, " + COL3 + " TEXT, " +
                    COL4 + " TEXT, " + COL5 + " TEXT, " + COL6 + " TEXT, " +
                    COL7 + " TEXT, " + COL8 + " TEXT, " + COL9 + " TEXT, " +
                    COL10 + " TEXT, " + COL11 + " TEXT, " + COL12 + " TEXT, " +
                    COL13 + " TEXT, " + COL14 + " TEXT);";
    private String updateUrl = "http://192.168.214.9/android_connect/updateUser.php";
    private RequestQueue requestQueue;

    public UserDatenbankManager(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
        requestQueue = Volley.newRequestQueue(context);
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
                           String pw, String nid)
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
        contentValues.put(COL14, nid);
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
                           String pw, String nid)
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
        contentValues.put(COL14, nid);
        db.update(DB_NAME, contentValues, "id=0", null);
    }

    public String getName()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + COL1 + " from " + DB_NAME, null);
        String result = "";
        if (res.moveToFirst())
        {
            do
            {
                result = res.getString(res.getColumnIndex("userName"));
            }
            while (res.moveToNext());
        }
        res.close();
        return result;
    }

    public String getVorname()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + COL2 + " from " + DB_NAME, null);
        String result = "";
        if (res.moveToFirst())
        {
            do
            {
                result = res.getString(res.getColumnIndex("userVorname"));
            }
            while (res.moveToNext());
        }
        res.close();
        return result;
    }

    public String getAnrede()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + COL3 + " from " + DB_NAME, null);
        String result = "";
        if (res.moveToFirst())
        {
            do
            {
                result = res.getString(res.getColumnIndex("userAnrede"));
            }
            while (res.moveToNext());
        }
        res.close();
        return result;
    }

    public String getTitel()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + COL4 + " from " + DB_NAME, null);
        String result = "";
        if (res.moveToFirst())
        {
            do
            {
                result = res.getString(res.getColumnIndex("userTitel"));
            }
            while (res.moveToNext());
        }
        res.close();
        return result;
    }

    public String getTel()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + COL5 + " from " + DB_NAME, null);
        String result = "";
        if (res.moveToFirst())
        {
            do
            {
                result = res.getString(res.getColumnIndex("userTel"));
            }
            while (res.moveToNext());
        }
        res.close();
        return result;
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
    public String getPraxisName()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + COL7 + " from " + DB_NAME, null);
        String result = "";
        if (res.moveToFirst())
        {
            do
            {
                result = res.getString(res.getColumnIndex("userPraxisName"));
            }
            while (res.moveToNext());
        }
        res.close();
        return result;
    }


    public String getPraxisAdresse()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + COL8 + " from " + DB_NAME, null);
        String result = "";
        if (res.moveToFirst())
        {
            do
            {
                result = res.getString(res.getColumnIndex("userPraxisAdresse"));
            }
            while (res.moveToNext());
        }
        res.close();
        return result;
    }

    public String getPraxisPlz()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + COL9 + " from " + DB_NAME, null);
        String result = "";
        if (res.moveToFirst())
        {
            do
            {
                result = res.getString(res.getColumnIndex("userPraxisPlz"));
            }
            while (res.moveToNext());
        }
        res.close();
        return result;
    }

    public String getPraxisStadt()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + COL10 + " from " + DB_NAME, null);
        String result = "";
        if (res.moveToFirst())
        {
            do
            {
                result = res.getString(res.getColumnIndex("userPraxisStadt"));
            }
            while (res.moveToNext());
        }
        res.close();
        return result;
    }

    public String getPraxisTel()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + COL11 + " from " + DB_NAME, null);
        String result = "";
        if (res.moveToFirst())
        {
            do
            {
                result = res.getString(res.getColumnIndex("userPraxisTel"));
            }
            while (res.moveToNext());
        }
        res.close();
        return result;
    }

    public String getPraxisAdresszs()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + COL12 + " from " + DB_NAME, null);
        String result = "";
        if (res.moveToFirst())
        {
            do
            {
                result = res.getString(res.getColumnIndex("userPraxisAdresszusatz"));
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

    public String getNid()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select " + COL14 + " from " + DB_NAME, null);
        String result = "";
        if (res.moveToFirst())
        {
            do
            {
                result = res.getString(res.getColumnIndex("userNID"));
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
        updateMySQL();
    }

    public void updateTel(String tel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL5, tel);

        db.update(DB_NAME, values, null, null);
        updateMySQL();
    }

    public void updateName(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL1, name);
        db.update(DB_NAME, values, "id=0", null);
        updateMySQL();
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
        updateMySQL();
    }

    public void updateTitel(String titel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL4, titel);

        db.update(DB_NAME, values, null, null);
        updateMySQL();
    }

    public void updatePasswort(String pw)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL13, pw);
        db.update(DB_NAME, values, null, null);
        updateMySQL();
    }

    public void updateMySQL()
    {
        StringRequest request = new StringRequest(Request.Method.POST, updateUrl, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {

            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("nid", "" + getNid());
                parameters.put("name", ""+getName());
                parameters.put("vorname", ""+getVorname());
                parameters.put("anrede", ""+getAnrede());
                parameters.put("namenszusatz", ""+getTitel());
                parameters.put("praxis", ""+getPraxisName());
                parameters.put("adresse", ""+getPraxisAdresse());
                parameters.put("plz", ""+getPraxisPlz());
                parameters.put("stadt", ""+getPraxisStadt());
                parameters.put("email", ""+getEmail());
                parameters.put("praxisnr", ""+getPraxisTel());
                parameters.put("handynr", ""+getTel());
                parameters.put("passwort", ""+getPw());
                parameters.put("adresszusatz", ""+getPraxisAdresszs());
                return parameters;
            }
        };
        requestQueue.add(request);
    }
}
