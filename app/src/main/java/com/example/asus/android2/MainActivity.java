package com.example.asus.android2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public TextView textView;

    private Button bt_1;
    private Button bt_2;

    private Button bt_4;
    private Button bt_5;
    private Button bt_7;
    private  Button bt_8;
    //butterknife
    @butterknife.OnClick(R.id.bt_6)
    public void show() {
        textView.setText("点击了butterknife绑定的监听器");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //给textView赋值
        textView = findViewById(R.id.text);



        //采用activity绑定
        bt_1 = findViewById(R.id.bt_1);
        bt_1.setOnClickListener(MainActivity.this);



        //匿名内部类
        bt_2 = findViewById(R.id.bt_2);
        bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("点击了采用内部类绑定的监听器");
            }
        });


        //绑定到标签





        //内部类
        bt_4 = findViewById(R.id.bt_4);
        bt_4.setOnClickListener(new OnClick());


        //外部类
        bt_5 = findViewById(R.id.bt_5);
        bt_5.setOnClickListener(new MyClickListener(MainActivity.this, textView));
        //configuration
        bt_7=findViewById(R.id.bt_7);
        bt_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ConfigurationTest.class);
                startActivity(intent);
            }
        });

        //进度条
        bt_8=findViewById(R.id.bt_8);
        bt_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ProgressDialogTest.class);
                startActivity(intent);
            }
        });


    }



    //activity
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_1:
                textView.setText("点击了采用activity绑定的监听器");
                break;
        }

    }





//绑定到标签里声明的函数

    public void show(View v) {
        switch (v.getId()) {
            case R.id.bt_3:
                textView.setText("点击了采用标签绑定的监听器");
                break;

        }

    }




    //内部类
    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            textView.setText("点击了采用内部类绑定的监听器");
        }
    }


}
