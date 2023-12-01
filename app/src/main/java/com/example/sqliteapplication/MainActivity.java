package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static int count = 0;
    private EditText etName, etPasswd;
    private Switch swActive;
    private Button btnView, btnAdd;
    private ListView lvUserList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPasswd = findViewById(R.id.etPasswd);
        swActive = findViewById(R.id.swActive);
        btnView = findViewById(R.id.btnView);
        btnAdd = findViewById(R.id.btnAdd);
        lvUserList = findViewById(R.id.lvUserList);

        btnAdd.setOnClickListener(this);
        btnView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btnView)
        {
            Toast.makeText(this, "Viewing All Users", Toast.LENGTH_SHORT).show();
            DataBaseHelper db = new DataBaseHelper(MainActivity.this);

            ArrayAdapter arrayAdapter = new ArrayAdapter<UserModel>(MainActivity.this, android.R.layout.simple_list_item_1, db.getAllUsers());
            lvUserList.setAdapter(arrayAdapter);
        }
        else if(view ==btnAdd)
        {
            Toast.makeText(this, "Adding User", Toast.LENGTH_SHORT).show();
            
            String name = etName.getText().toString(), passwd = etPasswd.getText().toString();
            if(name.isEmpty())
            {
                Toast.makeText(this, "Name is Empty", Toast.LENGTH_SHORT).show();
            }
            else if(passwd.isEmpty())
            {
                Toast.makeText(this, "Password is Empty", Toast.LENGTH_SHORT).show();
            }
            else
            {
                UserModel user = new UserModel(count++, name, passwd, swActive.isChecked());
                Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show();

                DataBaseHelper db = new DataBaseHelper(MainActivity.this);
                if(db.addUser(user) == -1)
                {
                    Toast.makeText(this, "User Creation Failed", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}