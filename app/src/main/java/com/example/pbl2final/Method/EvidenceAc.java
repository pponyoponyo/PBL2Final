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

    private BackSlash backSlash;
    private Bitly bitly;
    private Dot dot;
    private  EvalMethod evalMethod;
    private LengthOfDoc lengthOfDoc;
    private LengthOfURL lengthOfURL;
    private NumOfLines numOfLines;
    private SuspiciousWords suspiciousWords;
    private TLD tld;
    private WindowOpenMethod windowOpenMethod;
    private UrlKorean urlKorean;

    public EvidenceAc(String url) {

        backSlash = new BackSlash(url);
        bitly = new Bitly(url);
        dot=new Dot(url);
      //  evalMethod = new EvalMethod(url);
       // lengthOfDoc = new LengthOfDoc(url);
        lengthOfURL = new LengthOfURL(url);
     //   numOfLines = new NumOfLines(url);
     //   suspiciousWords = new SuspiciousWords(url);
        tld = new TLD(url);
    //    windowOpenMethod = new WindowOpenMethod(url);
        urlKorean = new UrlKorean(url);
    }

    public boolean upperAuthority(){
        if(backSlash.isHypothesis() && lengthOfURL.isHypothesis()){
            if(dot.isHypothesis()){
                //상위 권한 탈취 가능성
                return true;
            }
        }
        return false;
    }

    public boolean ChinaTld(){
        if(tld.isCn_hypothesis()){
            // 중국에 위치한 TLD
            return true;
        }
        return false;
    }

    public boolean RussiaTld(){
        if(tld.isRu_hypothesis()){
            // 러시아에 위치한 TLD
            return true;
        }
        return false;
    }

}
