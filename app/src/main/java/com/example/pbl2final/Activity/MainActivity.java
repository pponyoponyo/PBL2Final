package com.example.pbl2final.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pbl2final.R;

public class MainActivity extends BaseActivity {

    private EditText input;
    private String inputUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.edtInput);

/*
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = database.getReference("DB");

        UrlBean temp = new UrlBean();
        temp.url = "test.com";
        int n = 0;
        dbRef.child("URL"+n).setValue(temp);
        n++;
        temp.url = "espdesign.com.au";
        dbRef.child("URL"+n).setValue(temp);
        n++;
        temp.url = "iamagameaddict.com";
        dbRef.child("URL"+n).setValue(temp);
        n++;
        temp.url = "kalantzis.net";
        dbRef.child("URL"+n).setValue(temp);
        n++;
        temp.url = "slightlyoffcenter.net";
        dbRef.child("URL"+n).setValue(temp);
        n++;
        temp.url = "tubemoviez.com";
        dbRef.child("URL"+n).setValue(temp);
        n++;
*/

     findViewById(R.id.btnCheck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inputUrl = input.getText().toString();

                if(inputUrl.equals("")){
                    Toast.makeText(getApplicationContext(), "URL을 입력하세요.",Toast.LENGTH_SHORT).show();
                    return;
                }

                sendUrl();
            }
        });

    }
    public void sendUrl(){
        Intent i = new Intent(getBaseContext(), ResultActivity.class);
        i.putExtra("url",inputUrl);
        startActivity(i);
        finish();
    }
}
