package com.example.a74104.clothesmatch.HaoYou;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a74104.clothesmatch.R;

import java.util.ArrayList;
import java.util.List;

public class ChatUIActivity extends AppCompatActivity {

private ListView chatUI_lv;
private MesAdapter mesAdapter;
    private List<Message> messageList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         @SuppressLint("HandlerLeak") final Handler handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                int what = msg.what;
                switch (what) {
                    case 1:
                        /**
                         * ListView条目控制在最后一行
                         */
                        chatUI_lv.setSelection(messageList.size());
                        break;

                    default:
                        break;
                }
            };
        };
        setContentView(R.layout.chat_jiemian);
        mesAdapter=new MesAdapter(ChatUIActivity.this,messageList);
        chatUI_lv=(ListView)findViewById(R.id.message_lv);
        chatUI_lv.setAdapter(mesAdapter);
        Button send_btn=(Button)findViewById(R.id.send_btn);
        final EditText mes_et=(EditText)findViewById(R.id.message_et);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (TextUtils.isEmpty(mes_et.getText().toString())) {
                    Toast.makeText(ChatUIActivity.this, "发送内容不能为空", 0).show();
                    return;
                }
                Message personChat = new Message();
                //代表自己发送
                personChat.setTYPE(1);
                //得到发送内容
                personChat.setMes(mes_et.getText().toString());
                //加入集合
                messageList.add(personChat);
                //清空输入框
                mes_et.setText("");
                //刷新ListView
                mesAdapter.notifyDataSetChanged();
                handler.sendEmptyMessage(1);
            }
        });
    }
}
