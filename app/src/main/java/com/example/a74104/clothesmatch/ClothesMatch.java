package com.example.a74104.clothesmatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;

import com.example.a74104.clothesmatch.HaoYou.ChatUIActivity;
import com.example.a74104.clothesmatch.HaoYou.HaoYouActivity;
import com.example.a74104.clothesmatch.MyInfo.YiGuiActivity;

public class ClothesMatch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_match);
        SharedPreferences sharedPreferences=this.getSharedPreferences("share",MODE_PRIVATE);
        boolean isFirstRun=sharedPreferences.getBoolean("isFirstRun", true);
        Editor editor=sharedPreferences.edit();
        if(isFirstRun){
            Toast.makeText(ClothesMatch.this, "第一次运行", Toast.LENGTH_SHORT).show();
            editor.putBoolean("isFirstRun", false);
            editor.commit();
            startActivity(new Intent(ClothesMatch.this,Introduce.class));
        }else{
            Toast.makeText(ClothesMatch.this, "不是第一次运行", Toast.LENGTH_SHORT).show();
        }
        Button match=findViewById(R.id.Match);
        Button square=findViewById(R.id.Square);
        Button yiGui=findViewById(R.id.Mine);
        Button haoYou=findViewById(R.id.Friend);
        match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ClothesMatch.this, ChatUIActivity.class);
                startActivity(intent);
            }
        });
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ClothesMatch.this,Square.class);
                startActivity(intent);
            }
        });
        yiGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ClothesMatch.this, YiGuiActivity.class);
                startActivity(intent);
            }
        });
        haoYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ClothesMatch.this, HaoYouActivity.class);
                startActivity(intent);
            }
        });
    }
}
