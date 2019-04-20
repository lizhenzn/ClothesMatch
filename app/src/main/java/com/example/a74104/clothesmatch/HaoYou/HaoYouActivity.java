package com.example.a74104.clothesmatch.HaoYou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.a74104.clothesmatch.R;

public class HaoYouActivity extends AppCompatActivity {
LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        linearLayout=(LinearLayout)findViewById(R.id.chat_ll1);
        setContentView(R.layout.activity_hao_you);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HaoYouActivity.this,ChatUIActivity.class);
                startActivity(intent);
            }
        });
    }
}
