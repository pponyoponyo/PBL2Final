package com.example.pbl2final.RuleSet;

import com.example.pbl2final.Method.RuleBase;

public class EscapeMethod extends RuleBase {

    private String html;
    private boolean hypothesis = false;

    public EscapeMethod(String url) {
        super(url);
        html = getHtml();
    }

    public void rule(){

        if(html.contains("escape()")){
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
