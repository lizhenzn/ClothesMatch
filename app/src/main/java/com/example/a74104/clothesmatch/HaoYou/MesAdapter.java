package com.example.a74104.clothesmatch.HaoYou;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a74104.clothesmatch.R;

import java.util.List;

public class MesAdapter extends BaseAdapter {
    private Context context;
    private List<Message> messageList;
    public MesAdapter(Context context,List<Message> list){
        super();
        this.context=context;
        this.messageList=list;
    }

    @Override
    public int getCount() {
        return messageList.size();
    }

    @Override
    public Object getItem(int position) {
        return messageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        Message message=messageList.get(position);
        return message.getTYPE();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        Message message=messageList.get(position);
        int SENDER=message.getTYPE();
        if(viewHolder==null){
            viewHolder=new ViewHolder();
            if(SENDER==1){
                convertView=View.inflate(context, R.layout.right_message_item,null);
                viewHolder.mes_Text=convertView.findViewById(R.id.mes_tv2);
                viewHolder.mes_Text.setText(message.getMes());
            }else{
                convertView=View.inflate(context,R.layout.left_message_item,null);
                viewHolder.mes_Text=convertView.findViewById(R.id.mes_tv);
                viewHolder.mes_Text.setText(message.getMes());
            }
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        return convertView;
    }
    class ViewHolder{
        TextView mes_Text;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
