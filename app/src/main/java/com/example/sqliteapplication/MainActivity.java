package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static int count = 0;
    private EditText etName, etPasswd;
    private Switch swActive;
    private Button btnView, btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPasswd = findViewById(R.id.etPasswd);
        swActive = findViewById(R.id.swActive);
        btnView = findViewById(R.id.btnView);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(this);
        btnView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btnView)
        {
            Toast.makeText(this, "Viewing All Users", Toast.LENGTH_SHORT).show();
        }
        else if(view ==btnAdd)
        {
            Toast.makeText(this, "Adding User", Toast.LENGTH_SHORT).show();

            UserModel user = new UserModel(count++, etName.getText().toString(), etPasswd.getText().toString(), swActive.isChecked());
            Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}