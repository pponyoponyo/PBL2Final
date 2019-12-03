package com.example.pbl2final.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pbl2final.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends BaseActivity {

    private EditText input;
    private String inputUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.edtInput);

        /*
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = database.getReference("DB");

        int n =6 ;
        dbRef.child("URL"+n).setValue("diaryofagameaddict.com\n");
        n++;
        dbRef.child("URL"+n).setValue("espdesign.com.au\n");
        n++;
        dbRef.child("URL"+n).setValue("iamagameaddict.com\n");
        n++;
        dbRef.child("URL"+n).setValue("kalantzis.net\n");
        n++;
        dbRef.child("URL"+n).setValue("slightlyoffcenter.net\n");
        n++;
        dbRef.child("URL"+n).setValue("tubemoviez.com\n");
        n++;
*/
        findViewById(R.id.btnCheck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(input==null){
                    Toast.makeText(getApplicationContext(), "URL을 입력하세요.",Toast.LENGTH_SHORT).show();
                    return;
                }

                inputUrl = input.getText().toString();
                input.setText("");

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
