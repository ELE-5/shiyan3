package com.example.asus.android2;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class MyClickListener implements View.OnClickListener{
    private Activity mactivity;
    private TextView textView;

    public MyClickListener(Activity activity,TextView textView){
        this.mactivity= activity;
        this.textView=textView;
    }
    @Override
    public void onClick(View v) {
    this.textView.setText("采用了外部类绑定的监听器");
    }
}
