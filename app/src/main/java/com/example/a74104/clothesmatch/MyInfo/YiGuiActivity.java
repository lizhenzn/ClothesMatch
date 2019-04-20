package com.example.a74104.clothesmatch.MyInfo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a74104.clothesmatch.MyInfoActivity;
import com.example.a74104.clothesmatch.R;


public class YiGuiActivity extends AppCompatActivity {
private SharedPreferences sharedPreferences;
private ImageView head_iv;
private TextView niCheng_tv;
final String path="/sdcard/Clothes/MyInfo/head";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        sharedPreferences=getSharedPreferences("myInfo",MODE_PRIVATE);
        head_iv=(ImageView) findViewById(R.id.imageView);
        niCheng_tv=(TextView)findViewById(R.id.niCheng_tv);
        Bitmap bitmap= BitmapFactory.decodeFile(path+"head.jpg");
        if(bitmap!=null){
            @SuppressWarnings("deprecation")
            Drawable drawable=new BitmapDrawable(bitmap);
            head_iv.setImageDrawable(drawable);
        }
        else{
            //如果SD卡没有，从服务器获取，然后保存到SD
            Log.d("MyInfo","No head image");

        }
        //从文件读昵称
        String nc=sharedPreferences.getString("user","");
        niCheng_tv.setText(nc);
     head_iv.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent=new Intent(YiGuiActivity.this, MyInfoActivity.class);
             startActivity(intent);
         }
     });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bitmap bitmap= BitmapFactory.decodeFile(path+"head.jpg");
        if(bitmap!=null){
            @SuppressWarnings("deprecation")
            Drawable drawable=new BitmapDrawable(bitmap);
            head_iv.setImageDrawable(drawable);
        }
    niCheng_tv.setText(sharedPreferences.getString("user",""));
    }
}
