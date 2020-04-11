package com.example.mxapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.aware.DiscoverySession;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText userpwd;
    private UserManager mUserManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.edt_username);
        userpwd = findViewById(R.id.edt_userpwd);

    }


  /*  public void click(View v) {
        mUserManager = new UserManager(this);
        SQLiteDatabase db = null;
        mUserManager.onCreate(db);
        mUserManager.onOpen(db);
        mUserManager.createtable();
        mUserManager.insertdata("insert into users(user_name,user_pwd)values('mx','123')");
        int t = mUserManager.findUserByNameAndPwd(username.getText().toString(), userpwd.getText().toString());
        if (t != 1)
            Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            mUserManager.close();
            mUserManager = null;
            Intent intent = new Intent(MainActivity.this, OperateActivity.class);
            startActivity(intent);
        }
    }*/

    public void clicks(View v) {
        mUserManager = new UserManager(this);  //实例化
        SQLiteDatabase db = null;
        mUserManager.onCreate(db);
        mUserManager.onOpen(db);//创建库
        mUserManager.createtable();

        mUserManager.insertdata("Insert into users(username,userpwd) values('mx','1')");

        int a = mUserManager.findUserByNameAndPwd(username.getText().toString(), userpwd.getText().toString());
        if (a != 1)
            Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            mUserManager.close();
            mUserManager = null;
            Intent intent = new Intent(MainActivity.this, OperateActivity.class);
            startActivity(intent);
        }
    }
}