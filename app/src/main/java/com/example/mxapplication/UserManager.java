package com.example.mxapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class UserManager extends SQLiteOpenHelper {
    private static final String TAG="UserDataManager";
    private static final String DB_NAME="user_data";
    private static final String TABLE_NAME="users";
    private static final String USER_NAME="username";
    private static final String USER_PWD="userpwd";
    private SQLiteDatabase db;
    private static final int DB_VERSION = 2;
    private static String userInfo;
    private Context mContext = null;
    public UserManager( Context context) {
        super(context,DB_NAME, null, 1);
        db=getWritableDatabase();
    }

    public void createtable()
    {
     db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
    db.execSQL("CREATE TABLE " + TABLE_NAME + " ("
            + USER_NAME + " varchar,"
            + USER_PWD + " varchar" + ");");
    }
    public void insertdata(String sql)
    {
        db.execSQL(sql);
    }

    public int findUserByNameAndPwd(String username, String pwd) {
        int a= 0;
        Cursor mCursor = db.query(TABLE_NAME, null, "username=? and userpwd=?", new String[]{username, pwd}, null, null,
                null);
        if (mCursor != null) {
            a= mCursor.getCount();
            mCursor.close();
        }
        return a;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
