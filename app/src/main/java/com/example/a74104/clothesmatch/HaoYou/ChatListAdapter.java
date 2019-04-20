package com.example.a74104.clothesmatch.HaoYou;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a74104.clothesmatch.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatListAdapter extends BaseAdapter implements View.OnClickListener,View.OnTouchListener {
    private List<HashMap<String, Object>> list; //数据
    private Context context;
    private DisplayMetrics dm;    //用于获取屏幕大小
    private View beforeView;
    private List<ViewHolder> holders = new ArrayList<>();

    public ChatListAdapter(List<HashMap<String, Object>> list,
                     Context context,
                     DisplayMetrics dm) {
        this.list = list;
        this.context = context;
        this.dm = dm;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.chat_item, null);
            holder = new ViewHolder();
            //绑定布局组件
            holder.hsv = (HorizontalScrollView) convertView.findViewById(R.id.hsv);
            holder.linearLayout = (LinearLayout) convertView.findViewById(R.id.chat_ll1);
            holder.btnLayout = (LinearLayout) convertView.findViewById(R.id.chat_ll3);
            holder.image = (ImageView) convertView.findViewById(R.id.chat_iv);
            holder.tvName = (TextView) convertView.findViewById(R.id.chat_XMtv);
            holder.tvMessage = (TextView) convertView.findViewById(R.id.chat_Megtv);
            holder.tvTime=(TextView)convertView.findViewById(R.id.Meg_time);


            //标记按钮
            holder.btnDZ = (Button) convertView.findViewById(R.id.ZD_btn);
            holder.btnDZ.setTag(position);
            holder.btnDelete = (Button) convertView.findViewById(R.id.delete_btn);
            holder.btnDelete.setTag(position);
            //设置标签
            convertView.setTag(holder);
        } else {
            //读取标签
            holder = (ViewHolder) convertView.getTag();
        }
        //记录所有的holder
        holders.add(holder);
        HashMap<String, Object> map = list.get(position);
        //设置左边的LinearLayout宽度为屏幕宽度
        ViewGroup.LayoutParams params = holder.linearLayout.getLayoutParams();
        params.width = dm.widthPixels;
        //给每一项添加监听器
        holder.hsv.setOnTouchListener(this);
        holder.btnDelete.setOnClickListener(this);
        holder.btnDZ.setOnClickListener(this);

        holder.image.setImageDrawable(context.getResources()
                .getDrawable(Integer.parseInt(map.get("image") + "")));
        holder.tvName.setText(map.get("name") + "");
        holder.tvMessage.setText(map.get("message") + "");
        return convertView;
    }

    /**
     * 需要的控件
     */
    class ViewHolder {
        HorizontalScrollView hsv;
        LinearLayout linearLayout;
        LinearLayout btnLayout;
        ImageView image;
        TextView tvName;
        TextView tvMessage;
        TextView tvTime;
        Button btnDZ;
        Button btnDelete;
    }

    /**
     * 监听按钮
     */
    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        switch (v.getId()) {
            case R.id.ZD_btn:
                HashMap<String, Object> map = null;
                map = list.get(position);
                list.remove(position);
                list.add(0, map);
                break;
            case R.id.delete_btn:
                list.remove(position);
                break;

        }
        notifyDataSetChanged();
        //还原所有
        ViewHolder holder = holders.get(position);
        holder.hsv.smoothScrollTo(0, 0);
    }

    /**
     * 监听列表每项
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float down = 0;//按下坐标
        float up = 0;//抬起坐标
        ViewHolder holder = (ViewHolder) v.getTag();
        switch (event.getAction()) {
            //按下动作
            case MotionEvent.ACTION_DOWN:
                down = event.getX();
                if (beforeView != null) {
                    //将上一次操作的滚动条恢复原样
                    ViewHolder beforeHolder = (ViewHolder) beforeView.getTag();
                    beforeHolder.hsv.smoothScrollTo(0, 0);
                }
                //这是一次测试
                break;
            //抬起动作
            case MotionEvent.ACTION_UP:
                //记录此次操作
                beforeView = v;
                up = event.getX();
                if (down == up) {
                    // 手势未移动，即点击
                } else {
                    int scrol = holder.hsv.getScrollX();
                    if (scrol < 50) {
                        //滚动距离小于屏幕1/4，回滚
                        holder.hsv.smoothScrollTo(0, 0);
                    } else {
                        //移动到最后端
                        holder.hsv.smoothScrollTo(1000, 0);
                    }
                }
                /**
                 * 返回true，表示不需要父组件再去处理此事件
                 * 返回false，不能实现上面的全滚动效果
                 */
                return true;
        }
        return false;
    }

}
