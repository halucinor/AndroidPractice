package com.bootcamp.mycinemaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button likeButton;
    TextView likeCountView;
    int likeCount = 15;
    boolean thumsUpstate = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        likeButton = (Button) findViewById(R.id.likeButton);
        likeCountView = (TextView) findViewById(R.id.likeCountView);


        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thumsUpstate){
                    decrLikeCount();
                }else{
                    incrLikeCount();
                }

                thumsUpstate = !thumsUpstate;
            }
        });
    }

    public void incrLikeCount(){
        likeCount++;
        likeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
        likeCountView.setText(String.valueOf(likeCount));
    }

    public void decrLikeCount(){
        likeCount--;
        likeButton.setBackgroundResource(R.drawable.thumsup_selector);
        likeCountView.setText(String.valueOf(likeCount));
    }
}
