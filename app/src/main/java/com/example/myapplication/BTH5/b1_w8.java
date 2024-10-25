package com.example.myapplication.BTH5;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class b1_w8 extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bth5_b1_activity_man);

        EditText txtName = findViewById(R.id.txtName);
        EditText txtEmail = findViewById(R.id.txtEmail);
        EditText txtProject = findViewById(R.id.txtProject);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent getContactInfo = new Intent(getApplicationContext(), contactinfo.class);

                Bundle bundle = new Bundle();
                bundle.putString("nameKey", txtName.getText().toString());
                bundle.putString("emailKey", txtEmail.getText().toString());
                bundle.putString("projectKey", txtProject.getText().toString());

                getContactInfo.putExtras(bundle);

                startActivity(getContactInfo);
            }
        });
    }


}
