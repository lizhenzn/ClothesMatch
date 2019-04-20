package com.example.a74104.clothesmatch.HaoYou;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.a74104.clothesmatch.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatListFragment extends Fragment {
    ChatListAdapter chatListAdapter;
    List<HashMap<String,Object>> list;
    ListView listView;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.chatlist_fragment,container,false);
        listView=(ListView)view.findViewById(R.id.chatLV);
        HashMap<String,Object> map=new HashMap<>();
        list = new ArrayList<>();//自己添加数据
        map = new HashMap<>();
        map.put("image", R.mipmap.guang);
        map.put("name", "好友1");
        map.put("message", "晚上一起吃饭");
        list.add(map);
        map = new HashMap<>();
        map.put("image", R.mipmap.guang);
        map.put("name", "好友2");
        map.put("message", "明天一起上班");
        list.add(map);
        map = new HashMap<>();
        map.put("image", R.mipmap.ic_launcher_round);
        map.put("name", "好友3");
        map.put("message", "明天一起上班");
        list.add(map);
        map = new HashMap<>();
        map.put("image", R.mipmap.ic_launcher);
        map.put("name", "好友4");
        map.put("message", "明天一起上班");
        list.add(map);
        //获取当前屏幕信息
        DisplayMetrics dm = new DisplayMetrics();

        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        chatListAdapter = new ChatListAdapter(list,getContext(), dm);//自定义适配器
        listView.setAdapter(chatListAdapter);
        
        return view;
    }
}
