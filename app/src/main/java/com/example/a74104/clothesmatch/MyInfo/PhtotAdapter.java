package com.example.a74104.clothesmatch.MyInfo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.a74104.clothesmatch.R;

import java.util.List;

public class PhtotAdapter extends RecyclerView.Adapter<PhtotAdapter.ViewHolder> {
    private List<Phtot> phtotList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView phtotImage;
        public ViewHolder(View view){
            super(view);
            phtotImage=(ImageView)view.findViewById(R.id.phtot_iv);
        }
    }
    public PhtotAdapter(List<Phtot> phtotList1){
        phtotList=phtotList1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.phtot_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Phtot phtot=phtotList.get(position);
        holder.phtotImage.setImageResource(phtot.getImageID());
    }

    @Override
    public int getItemCount() {
        return phtotList.size();
    }
}
