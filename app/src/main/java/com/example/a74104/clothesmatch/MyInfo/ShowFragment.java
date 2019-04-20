package com.example.a74104.clothesmatch.MyInfo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a74104.clothesmatch.R;

import java.util.ArrayList;
import java.util.List;

public class ShowFragment extends Fragment {
    private List<Phtot> phtotList=new ArrayList<>();
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.show_fragment,container,false);
        initPhtot();
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.show_recycler);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        PhtotAdapter phtotAdapter=new PhtotAdapter(phtotList);
        recyclerView.setAdapter(phtotAdapter);
        return view;
    }
    private void initPhtot(){
        phtotList.clear();
        for(int i=0;i<10;i++)
        {
            Phtot phtot=new Phtot(R.mipmap.guang);
            phtotList.add(phtot);
        }

    }
}
