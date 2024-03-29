package com.example.pbl2final.RuleSet;

import com.example.pbl2final.Method.RuleBase;

public class SemiColon extends RuleBase {

    private String url;
    private boolean hypothesis = false;

    public boolean isHypothesis() {
        return hypothesis;
    }
    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }

    public SemiColon(String url) {
        super(url);
        this.url = url;
    }


    public void rule(){
        char [] c ;
        c = url.toCharArray(); // url을 char 문자로 변환

        for(int i=0; i<c.length; i++){
            if(c[i]==';'){
                setHypothesis(true);
            }
        }

    }
}
