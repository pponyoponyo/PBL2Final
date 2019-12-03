package com.example.pbl2final.Method;

import androidx.annotation.NonNull;

import com.example.pbl2final.Bean.ReasonBean;
import com.example.pbl2final.Bean.UrlBean;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DB {
    private String inputUrl;
    public boolean comResult = true;

    public DB(String inputUrl) {
        this.inputUrl = inputUrl;
    }

    public ReasonBean compare(){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = database.getReference("DB");

        final ReasonBean reasonBean = new ReasonBean();

        dbRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){

                    UrlBean bean = snapshot.getValue(UrlBean.class);

                   // Log.d("--------", "key"+key+"bean"+bean.url+"input :"+inputUrl+"boolean"+comResult );

                    if(comResult){
                        reasonBean.percent = 100;
                        reasonBean.reason = "악성 URL DB에 존재하는 악성 URL 입니다.\n";
                    }

                    if(inputUrl.contains(bean.url)){
                       comResult = true;
                       // Log.d("--------", "key"+key+"bean"+bean.url+"input :"+inputUrl+"boolean"+comResult );
                       return;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

    return reasonBean;
    }
}
