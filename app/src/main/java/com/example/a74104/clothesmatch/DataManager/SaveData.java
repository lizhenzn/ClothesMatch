package com.example.a74104.clothesmatch.DataManager;

import android.content.Context;
import android.content.SharedPreferences;

public class SaveData {
    Context context;
    public SaveData(Context context){this.context=context;}
    SharedPreferences sharedPreferences= context.getSharedPreferences("myInfo",Context.MODE_PRIVATE);
    SharedPreferences.Editor editor=sharedPreferences.edit();
    public void saveString(String key,String data){
        editor.putString(key,data);
        editor.commit();
    }
}
