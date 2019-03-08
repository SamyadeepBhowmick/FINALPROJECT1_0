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

public class UserList extends ArrayAdapter<User>{
    private Activity context;
    private List<User> userinfoList;

    public UserList(Activity context, List<User>userinfoList){
        super(context,R.layout.list_layout,userinfoList);
        this.context=context;
        this.userinfoList=userinfoList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View listViewItem=inflater.inflate(R.layout.list_layout,null,true);

        TextView textView1=(TextView)listViewItem.findViewById(R.id.textViewRoll);
        TextView textView2=(TextView)listViewItem.findViewById(R.id.textViewptte);
        TextView textView3=(TextView)listViewItem.findViewById(R.id.textViewName);
        TextView textView4=(TextView)listViewItem.findViewById(R.id.textViewatte);

        User user=userinfoList.get(position);

        textView1.setText(user.getRoll());
        textView2.setText(user.getPtte());
        textView3.setText(user.getNam());
        textView4.setText(user.getAtte());

        return listViewItem;

    }
}

