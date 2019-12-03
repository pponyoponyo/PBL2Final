package com.example.pbl2final.Activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pbl2final.R;


public class ResultActivity extends BaseActivity {

    Handler handler = new Handler() ; // Thread에서 화면에 그리기 위해 필요
    private TextView txtResult; //
    private int testNum=9; // 연동 전 임의로 테스트 넘버 넣음
    private int value=0;
    private ProgressBar progressBar;
    private int add=5; // 증가량, 방향

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResult = findViewById(R.id.txtResult);
        testNum=testNum*10;
        txtResult.setText(testNum+"%"); // 연동 전 테스트 넘버

        // 약간 수정 필요함!!
        final ProgressBar progressBar=(ProgressBar)findViewById(R.id.progress_circular1);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(value<=testNum){
                    value=value+add;
                    if(value>=100 || value<=0){
                        add=-add;
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(value);
                        }
                    });
                    try{
                        Thread.sleep(100); // tlrks wldus
                    } catch (InterruptedException e){}
                }

            }
        });
        t.start();




   /*     // todo 리턴되는 true 개수를 progressBar.setProgress(trueNum) 해주기

        progressBar=(ProgressBar)findViewById(R.id.progress_circular1);
        progressBar.setProgress(testNum);
*/
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
