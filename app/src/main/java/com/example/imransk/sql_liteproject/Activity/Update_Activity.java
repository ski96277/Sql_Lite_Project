package com.example.imransk.sql_liteproject.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imransk.sql_liteproject.DataBase.DataInsert;
import com.example.imransk.sql_liteproject.PojoClass.User_Information;
import com.example.imransk.sql_liteproject.R;

public class Update_Activity extends AppCompatActivity {
    EditText name_ET;
    EditText email_ET;
    EditText phone_ET;
    String TAG = "Update activity";

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        id = intent.getIntExtra("id", 0);
        String phone = intent.getStringExtra("phone");

        name_ET = findViewById(R.id.name_ET_update_ID);
        email_ET = findViewById(R.id.email_ET_update_ID);
        phone_ET = findViewById(R.id.phone_ET_update_ID);
        name_ET.setText(name);
        email_ET.setText(email);
        phone_ET.setText(phone);

    }

    public void update_Information(View view) {
        String name = name_ET.getText().toString();
        String email = email_ET.getText().toString();
        String phone = phone_ET.getText().toString();

        DataInsert dataInsert=new DataInsert(getApplicationContext());

        User_Information user_information=new User_Information(name,email,phone,id);

       boolean status =  dataInsert.updateUser(user_information);
       if (status){
           startActivity( new Intent(Update_Activity.this,ShowUserInformation_Activity.class));
           finish();
       }else {
           Toast.makeText(this, "can't Update", Toast.LENGTH_SHORT).show();
       }

    }
}
