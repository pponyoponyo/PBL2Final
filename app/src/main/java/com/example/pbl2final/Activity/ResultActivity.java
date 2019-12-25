package com.example.pbl2final.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pbl2final.Bean.ReasonBean;
import com.example.pbl2final.Method.DB;
import com.example.pbl2final.Method.EvidenceAc;
import com.example.pbl2final.R;


public class ResultActivity extends BaseActivity {

    Handler handler = new Handler() ; // Thread에서 화면에 그리기 위해 필요
    private TextView txtResult; //
    private int testNum=6; // 연동 전 임의로 테스트 넘버 넣음
    private int value=0; // 프로그래스바 초기값
    private ProgressBar progressBar;
    private int add=5; // 증가량, 방향
    private String inputUrl;
    private int percent;
    private String reason = "";
    private int total=0;
    private int trueNum=0;
    private float temp =0;

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
                        Thread.sleep(100);
                    } catch (InterruptedException e){}
                }

            }
        });
        t.start();

        // todo 리턴되는 true 개수를 progressBar.setProgress(trueNum) 해주기

        Intent i = getIntent();
        inputUrl = i.getExtras().getString("url");

        process();

        txtResult.setText("percent : "+ percent  +"reason : "+reason);

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

    private void process(){

       DB db = new DB(inputUrl);
       ReasonBean reasonBean = db.compare();

       if(reasonBean!=null){
           percent = reasonBean.percent;
           reason = reasonBean.reason;
           return;
       }

        EvidenceAc evidenceAc = new EvidenceAc(inputUrl);

        if(evidenceAc.upperAuthority()){
            trueNum++;
            reason += "상위 권한 탈취 가능성이 있습니다.\n ";
        }
        count();

        result();

    }

    private void count(){
       total++;
    }

    private void result(){

        if(trueNum == 0 ){
            percent = 0;
            reason = "정상적인 URL 입니다.\n";
            return;
        }

        temp = (float)trueNum/(float)total;
        percent = (int)(temp*100);
    }
}
