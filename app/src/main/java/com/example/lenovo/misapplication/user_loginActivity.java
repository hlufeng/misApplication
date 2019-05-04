package com.example.lenovo.misapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class user_loginActivity extends AppCompatActivity {
    EditText userphone;
    EditText userpwd;
    String user_phone="";
    String user_pwd="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        userphone =findViewById(R.id.user_login_phone);
        userpwd =findViewById(R.id.user_login_pwd);
    }

    public void login(View btn){
        user_phone=userphone.getText().toString();
        user_pwd=userpwd.getText().toString();
        DBUtil db=new DBUtil(user_phone,user_pwd);//调用数据库查询类
        String ret=db.QuerySQL();//得到返回值
        if (ret.equals("1"))//为1，页面跳转，登陆成功
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "登录成功",Toast.LENGTH_SHORT).show();//显示提示框
            return;
        }
        Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();

    }
}
