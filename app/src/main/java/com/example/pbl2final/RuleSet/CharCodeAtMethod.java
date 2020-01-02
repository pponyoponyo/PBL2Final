package com.example.pbl2final.RuleSet;

import com.example.pbl2final.Method.RuleBase;

import java.lang.reflect.Method;

public class CharCodeAtMethod extends RuleBase {

    private String html;
    private boolean hypothesis = false;

    public CharCodeAtMethod(String url) {
        super(url);
        html = getHtml();
    }

    public void rule(){

        if(html.contains("CharCodeAt()")){
            setHypothesis(true);
        }
    }

    public boolean isHypothesis() {
        return hypothesis;
    }

    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }
}
