package com.cnippet.finalproject1_0;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DateList extends ArrayAdapter<UserDate>{
    private Activity context;
    private List<UserDate> userinfoList;


    public DateList(Activity context, List<UserDate>userinfoList){
        super(context,R.layout.list_view,userinfoList);
        this.context=context;
        this.userinfoList=userinfoList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View listViewItem=inflater.inflate(R.layout.list_view,null,true);

        TextView textView1=(TextView)listViewItem.findViewById(R.id.textView6);
        TextView textView2=(TextView)listViewItem.findViewById(R.id.textView7);
        TextView textView3=(TextView)listViewItem.findViewById(R.id.textView8);


        UserDate userDate=userinfoList.get(position);

        textView1.setText(userDate.getname());
        textView2.setText(userDate.getroll());
        textView3.setText(userDate.getatte());

        return listViewItem;
    }
}


