package com.example.sqliteapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(@Nullable Context context) {
        super(context, "users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String startDataBaseStatement = "CREATE TABLE USERS_TABLE (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PASSWD TEXT, ACTIVE BOOL)";

        db.execSQL(startDataBaseStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public int addUser(UserModel user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("NAME", user.getName());
        cv.put("PASSWD", user.getPasswd());
        cv.put("ACTIVE", user.isActive());

        int result = (int)db.insert("USERS_TABLE", null, cv);
        db.close();
        return result;
    }

    public int deleteUserByID(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        int result = (int)db.delete("USERS_TABLE", "ID =" + id, null);
        db.close();
        return result;
    }

    public List<UserModel> getAllUsers()
    {
        List<UserModel> userList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor c = db.rawQuery("SELECT * FROM USERS_TABLE", null);
        while(c.moveToNext())
        {
            UserModel userModel = new UserModel(c.getInt(0), c.getString(1), c.getString(2), (c.getInt(3) == 1));
            userList.add(userModel);
        }
        c.close();
        db.close();
        return userList;
    }
}
