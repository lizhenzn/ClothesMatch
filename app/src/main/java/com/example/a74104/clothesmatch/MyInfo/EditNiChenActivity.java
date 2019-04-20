package com.example.a74104.clothesmatch.MyInfo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.a74104.clothesmatch.R;

public class EditNiChenActivity extends  AppCompatActivity {
private EditText nichen_et;
private SharedPreferences sharedPreferences;
private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_nichen);
        nichen_et=(EditText)findViewById(R.id.edit_nichen);
        sharedPreferences=getSharedPreferences("myInfo",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("编辑昵称");
        actionBar.setDisplayHomeAsUpEnabled(true);
        Intent intent=getIntent();
        String niCheng=intent.getStringExtra("niCheng");
        nichen_et.setText(niCheng);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent();
        String nicheng1=String.valueOf(nichen_et.getText());
        setResult(RESULT_OK,intent);
        editor.putString("user",nicheng1);
        editor.apply();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Intent intent=new Intent();
                String nicheng1=String.valueOf(nichen_et.getText());
                setResult(RESULT_OK,intent);
                editor.putString("user",nicheng1);
                editor.apply();
             finish();
        }
        return true;
    }
}
