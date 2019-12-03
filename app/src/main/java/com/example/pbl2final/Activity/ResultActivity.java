package com.example.pbl2final.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pbl2final.R;


public class ResultActivity extends BaseActivity {

    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResult = findViewById(R.id.txtResult);
/*
        Intent i = getIntent();
        String reason = i.getStringExtra("reason");
        int percent = i.getIntExtra("percent",0);

        // 콜렉트 변수 percent 가 기준치 10을 넘어가면
        if(percent>=10) {
            txtResult.setText("이유 : " + reason + "\n" + "탐지(10기준):"+percent+"\n"+"악성URL로 판별"+"\n" );
        }
*/
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        findViewById(R.id.btnOff).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
