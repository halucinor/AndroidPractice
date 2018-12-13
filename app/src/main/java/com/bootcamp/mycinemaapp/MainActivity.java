package com.bootcamp.mycinemaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button likeButton;
    Button disLikeButton;
    Button showAllButton;
    Button commentWritebutton;

    CommentAdaptor adaptor;

    TextView likeCountView;
    TextView disLikeCountView;

    int likeCount = 15;
    int dislikeCount = 1;
    boolean thumsUpstate = false;
    boolean thumsDownstate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        likeButton = (Button) findViewById(R.id.likeButton);
        disLikeButton = (Button) findViewById(R.id.disLikeButton);
        showAllButton = (Button) findViewById(R.id.showAllBtn);
        commentWritebutton = (Button) findViewById(R.id.commentWriteBtn);


        likeCountView = (TextView) findViewById(R.id.likeCountView);
        disLikeCountView = (TextView) findViewById(R.id.disLikeCountView);

        ListView commentListView = (ListView) findViewById(R.id.commentListView);
        adaptor = new CommentAdaptor();

        adaptor.additem(new commentItem("BSj",R.drawable.user1,"한줄"));
        commentListView.setAdapter(adaptor);


        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thumsUpstate){
                    decrLikeCount();
                }else{
                    incrLikeCount();
                    if(thumsDownstate) {
                        decrDisLikeCount();
                        thumsDownstate = false;
                    }
                }

                thumsUpstate = !thumsUpstate;
            }
        });

        disLikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(thumsDownstate){
                    decrDisLikeCount();
                }else{
                    incrDisLikeCount();
                    if(thumsUpstate){
                        decrLikeCount();
                        thumsUpstate = false;
                    }
                }
                thumsDownstate = !thumsDownstate;
            }
        });

        showAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"ShowAll 버튼이 눌렸습니다", Toast.LENGTH_SHORT).show();
            }
        });

        commentWritebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"commentWrite 버튼이 눌렸습니다", Toast.LENGTH_LONG).show();
            }
        });
    }

    class CommentAdaptor extends BaseAdapter{
        ArrayList<commentItem> items = new ArrayList<commentItem>();

        public void additem(commentItem item){
            items.add(item);
        }
        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            comment_list_view view = new comment_list_view(getApplicationContext());

            commentItem item = items.get(position);
            view.setUserComment(item.getComment());
            view.setUserId(item.getComment());
            view.setUserImage(item.getResId());

            return view;
        }
    }

    public void incrDisLikeCount(){
        dislikeCount++;
        disLikeButton.setBackgroundResource(R.drawable.ic_thumb_down_selected);
        disLikeCountView.setText(String.valueOf(dislikeCount));
    }

    public void decrDisLikeCount(){
        dislikeCount--;
        disLikeButton.setBackgroundResource(R.drawable.thumsdown_selector);
        disLikeCountView.setText(String.valueOf(dislikeCount));
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
