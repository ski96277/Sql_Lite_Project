package com.example.imransk.sql_liteproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.imransk.sql_liteproject.Activity.Update_Activity;
import com.example.imransk.sql_liteproject.PojoClass.User_Information;
import com.example.imransk.sql_liteproject.R;

import java.util.ArrayList;
public class AdapterClass extends ArrayAdapter<User_Information> {

    ArrayList<User_Information> user_informations;
    LayoutInflater layoutInflater;
    Context context;


    public AdapterClass(@NonNull Context context, ArrayList<User_Information> objects) {

        super(context, R.layout.item_view, objects);
        this.user_informations = objects;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = layoutInflater.inflate(R.layout.item_view,null);
        TextView name=convertView.findViewById(R.id.name_ET_ID);
        TextView email = convertView.findViewById(R.id.email_ET_ID);
        name.setText(user_informations.get(position).getName());
        email.setText(user_informations.get(position).getEmail());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,Update_Activity.class);
                intent.putExtra("name",user_informations.get(position).getName());
                intent.putExtra("email",user_informations.get(position).getEmail());
                intent.putExtra("id",user_informations.get(position).getId());
                intent.putExtra("phone",user_informations.get(position).getPhone());
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
