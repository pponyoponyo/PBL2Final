package com.example.pbl2final.Method;


import com.example.pbl2final.RuleSet.BackSlash;
import com.example.pbl2final.RuleSet.Bitly;
import com.example.pbl2final.RuleSet.Dot;
import com.example.pbl2final.RuleSet.EvalMethod;
import com.example.pbl2final.RuleSet.LengthOfDoc;
import com.example.pbl2final.RuleSet.LengthOfURL;
import com.example.pbl2final.RuleSet.NumOfLines;
import com.example.pbl2final.RuleSet.SuspiciousWords;
import com.example.pbl2final.RuleSet.TLD;
import com.example.pbl2final.RuleSet.UrlKorean;
import com.example.pbl2final.RuleSet.WindowOpenMethod;

public class EvidenceAc {

    private String url;
    private int total = 0;
    private int trueNum = 0;
    private float resultN = 0;

    public EvidenceAc(String url) {
        this.url = url;
    }

    public int Evidence(){

        BackSlash backSlash = new BackSlash(url);
        Bitly bitly = new Bitly(url);
        Dot dot=new Dot(url);
        EvalMethod evalMethod = new EvalMethod(url);
        LengthOfDoc lengthOfDoc = new LengthOfDoc(url);
        LengthOfURL lengthOfURL = new LengthOfURL(url);
        NumOfLines numOfLines = new NumOfLines(url);
        SuspiciousWords suspiciousWords = new SuspiciousWords(url);
        TLD tld = new TLD(url);
        WindowOpenMethod windowOpenMethod = new WindowOpenMethod(url);
        UrlKorean urlKorean = new UrlKorean(url);


        if(backSlash.isHypothesis() && lengthOfURL.isHypothesis()){
            if(dot.isHypothesis()){
                //상위 권한 탈취 가능성
            }
        }

        count();

        if(tld.isCn_hypothesis()||tld.isRu_hypothesis()){
            // 러시아와 중국에 위치한 TLD
        }

        count();

        /*
        if(backSlash.rule()){
            trueNum++;
        }
        count();

        if(tld.rule()){
            trueNum++;
        }
        count();

        if(bitly.rule() && suspiciousWords.rule()){
            trueNum++;
        }
        count();

        if(backSlash.rule()&& dot.rule()){
            // 권한 및 경로 탈취 url
            trueNum++;
        }
        count();*/

        //result();

        return 0;
    }

    private void count(){
        total ++;
    }

    private void result(){

    }
}
