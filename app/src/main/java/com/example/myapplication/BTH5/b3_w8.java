package com.example.myapplication.BTH5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class b3_w8 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bth5_b2_showgg);
        Button button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //store phone number
//                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:(+84)123456789"));

                //send SMS
//                Intent intent = new Intent( Intent.ACTION_SENDTO, Uri.parse("sms:5551234"));
//                intent.putExtra("sms_body", "Thu bay nay di choi khong?");
//
//                startActivity(intent);

                //show Image
//                Intent myIntent = new Intent();
//                myIntent.setType("image/pictures/*");
//                myIntent.setAction(Intent.ACTION_GET_CONTENT);
//
//                startActivity(myIntent);
                // listen to music
                Intent myActivity2 = new Intent("android.intent.action.MUSIC_PLAYER");
                startActivity(myActivity2);

                //find path
//                String url = "http://maps.google.com/maps?"+
//                        "saddr=9.938083,-84.054430&daddr=9.926392,-84.055964";
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                startActivity(intent);

            }

        });

    }
}
