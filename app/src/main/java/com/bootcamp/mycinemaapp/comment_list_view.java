package com.bootcamp.mycinemaapp;

import android.content.Context;
import android.media.Image;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class comment_list_view extends LinearLayout {
    ImageView userImage;
    TextView userId;
    TextView userComment;
    public comment_list_view(Context context) {
        super(context);
        init(context);
    }

    public comment_list_view(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){

       LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       inflater.inflate(R.layout.comment_item,this,true);

       userImage = (ImageView) findViewById(R.id.userImage);
       userId = (TextView) findViewById(R.id.userId);
       userComment = (TextView) findViewById(R.id.commentView);
    }

    public void setUserImage(int resId) {
        userImage.setImageResource(resId);
    }

    public void setUserId(String Id) {
        userId.setText(Id);
    }

    public void setUserComment(String comment) {
        userComment.setText(comment);
    }
}
