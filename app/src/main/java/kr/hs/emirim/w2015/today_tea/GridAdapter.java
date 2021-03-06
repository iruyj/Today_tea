package kr.hs.emirim.w2015.today_tea;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

public class GridAdapter extends BaseAdapter {
    ArrayList<TeaDataClass> teas = new ArrayList<>();   // put 으로 데이터 추가
    Context context;

    public GridAdapter( ArrayList<TeaDataClass> teas, Context context){
        this.teas = teas;
        this.context = context;
    }
    @Override
    public int getCount() {
        return teas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItem(ArrayList<TeaDataClass> ds){
        teas = ds;
        this.notifyDataSetChanged(); // 호출후에 하던지 아니면. 그냥 여기서 하자
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.tea_item,parent,false);
        
        ImageView tea_img_view = convertView.findViewById(R.id.teaImg);
        TextView tea_name_view = convertView.findViewById(R.id.teaName);
        TextView tea_explan_view = convertView.findViewById(R.id.teaExplan);

        tea_name_view.setText(this.teas.get(position).teaName);
        tea_explan_view.setText(this.teas.get(position).teaEfficacy);
        switch (teas.get(position).teaImg){
            case 1:
                tea_img_view.setImageResource(R.drawable.yellow);
                break;
            case 2:
                tea_img_view.setImageResource(R.drawable.red);
                break;
            case 3:
                tea_img_view.setImageResource(R.drawable.green);
                break;
            case 4:
                tea_img_view.setImageResource(R.drawable.orange);
                break;
            case 5:
                tea_img_view.setImageResource(R.drawable.blue);
                break;
        }
        return convertView;
    }
}
