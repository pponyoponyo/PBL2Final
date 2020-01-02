package com.example.pbl2final.RuleSet;


import com.example.pbl2final.Method.RuleBase;

public class SuspiciousWords extends RuleBase {
    //여기가 '택배'단어 들어가는 클래스임

    private String html;
    private boolean hypothesis = false;

    public SuspiciousWords(String url) {
        super(url);
        html = getHtml();
    }

    public void rule(){

        if(html.contains("택배")||html.contains("도박")||html.contains("보안승급")){
            setHypothesis(true);
        }

        //todo '보안승급'관련하여 보안카드 입력 나타내는 룰 규칙 추가해서 룰체인으로 엮기




    }

    public boolean isHypothesis() {
        return hypothesis;
    }
    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }
}
