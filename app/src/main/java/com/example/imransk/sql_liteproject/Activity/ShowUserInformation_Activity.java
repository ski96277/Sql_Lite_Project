package com.example.imransk.sql_liteproject.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.imransk.sql_liteproject.Adapter.AdapterClass;
import com.example.imransk.sql_liteproject.DataBase.DataInsert;
import com.example.imransk.sql_liteproject.PojoClass.User_Information;
import com.example.imransk.sql_liteproject.R;

import java.util.ArrayList;

public class ShowUserInformation_Activity extends AppCompatActivity {

    ArrayList<User_Information> user_informations = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user_information);

        final DataInsert dataInsert = new DataInsert(getApplicationContext());

        user_informations = dataInsert.get_Data();


        final AdapterClass adapterClass = new AdapterClass(getApplicationContext(), user_informations);
        final ListView listView = findViewById(R.id.list_View);

        listView.setAdapter(adapterClass);

//Delete Operation
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                int id = user_informations.get(i).getId();
                boolean status = dataInsert.deleteUser(id);

                if (status) {
                    Toast.makeText(ShowUserInformation_Activity.this, "deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ShowUserInformation_Activity.this, "deleted failed", Toast.LENGTH_SHORT).show();
                }

                startActivity(getIntent());
                finish();


                return false;
            }
        });


    }
}
