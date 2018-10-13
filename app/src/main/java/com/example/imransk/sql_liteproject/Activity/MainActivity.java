package com.example.imransk.sql_liteproject.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imransk.sql_liteproject.DataBase.DataInsert;
import com.example.imransk.sql_liteproject.PojoClass.User_Information;
import com.example.imransk.sql_liteproject.R;

public class MainActivity extends AppCompatActivity {

    EditText nameET;
    EditText emailET;
    EditText phoneET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initialized();


    }

    public void Initialized() {

        emailET = findViewById(R.id.email_ET_ID);
        nameET = findViewById(R.id.name_ET_ID);
        phoneET = findViewById(R.id.phone_ET_ID);

    }

    public void checkEmptyInformation(View view) {

        String name = nameET.getText().toString();
        String email = emailET.getText().toString();
        String phone = phoneET.getText().toString();

        if (TextUtils.isEmpty(name)) {
            nameET.requestFocus();
            nameET.setError("set name");
            return;

        }
        if (TextUtils.isEmpty(email)) {
            nameET.requestFocus();
            nameET.setError("set email");
            return;

        }
        if (TextUtils.isEmpty(phone)) {
            nameET.requestFocus();
            nameET.setError("set phone");
            return;
        }


        User_Information user_information = new User_Information(name, email, phone);

        DataInsert dataInsert = new DataInsert(getApplicationContext());

        boolean status = dataInsert.insertData(user_information);

        if (status) {
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Not Saved", Toast.LENGTH_SHORT).show();
        }

    }

    public void showALlEmail(View view) {
        startActivity(new Intent(MainActivity.this,ShowUserInformation_Activity.class));
    }
}
