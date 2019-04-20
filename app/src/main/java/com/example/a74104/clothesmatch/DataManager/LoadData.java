package com.example.a74104.clothesmatch.DataManager;

import android.content.Context;
import android.content.SharedPreferences;

public class LoadData {
    Context context;
    public LoadData(Context context){this.context=context;}
    SharedPreferences sharedPreferences=context.getSharedPreferences("myInfo",Context.MODE_PRIVATE);
    SharedPreferences.Editor editor=sharedPreferences.edit();
      public String getInfo(String string) {
          String string1 = null;
       if(string.equalsIgnoreCase("user"))
           string1=sharedPreferences.getString(string,"");
       else if(string.equalsIgnoreCase("xingBie"))
           string1=sharedPreferences.getString(string,"");
       else if(string.equalsIgnoreCase("niCheng"))
           string1=sharedPreferences.getString(string,"");
       else if(string.equalsIgnoreCase("shenGao"))
           string1=sharedPreferences.getString(string,"");
       return  string1;
      }
    }

