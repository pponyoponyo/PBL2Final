package com.example.pbl2final.RuleSet;

import com.example.pbl2final.Method.RuleBase;

public class HiddenTag extends RuleBase {
    private String html;
    private boolean hypothesis = false;

    public boolean isHypothesis() {
        return hypothesis;
    }

    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }

    public HiddenTag(String url) {
        super(url);
        html = getHtml();
    }



    public void rule() {
        String[] checkBig = html.split("<");// < 기준으로 문장 쪼개서 단어로 배열만들기
        for (int i = 0; i < checkBig.length; i++) {
            String[] checkMid = checkBig[i].split(">");
            for (int j = 0; j < checkMid.length; j++) {
                String[] checkSmall = checkMid[j].split(" ");
                for (int k = 0; k < checkSmall.length; k++) {

                    //Number of hidden
                    if (checkSmall[k].equals("type=\"hidden\"")) {
                        setHypothesis(true);
                    }


                }

            }
        }
    }
}
