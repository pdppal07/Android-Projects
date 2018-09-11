package com.example.android.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME ="Contact.db";
    public static final String TABLE_NAME ="Contact_table";

    public static final String COL_1 ="ID";
    public static final String COL_2 ="NAME";
    public static final String COL_3 ="PHONE";
    public static final String COL_4 ="EMAIL";



    public DataBaseHelper(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }
    //insert data into table ...
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_NAME + "( ID  INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT ,PHONE TEXT ,EMAIL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
    }
    //insert Data into table
    public boolean insertData(String name,String phone,String email){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2,name);
        cv.put(COL_3,phone);
        cv.put(COL_4,email);
        long result = database.insert(TABLE_NAME,null,cv);
        database.close();

        //To check whether Data is Inserted in Database...
        if(result==-1){
            return false;
        }else {
            return true;
        }

    }
    //Read Data from table....
    public Cursor read(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor res = database.rawQuery("select * from " +  TABLE_NAME,null);
        return res;
    }


}
