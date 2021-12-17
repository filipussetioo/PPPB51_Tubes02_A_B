package com.example.tugasbesar.adapter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tugasbesar.R;

import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter{
    ArrayList<String> list;
    private Fragment fragment;

    public MenuAdapter(Fragment fragment){
        this.fragment = fragment;
        this.list = new ArrayList<String>();
    }

    public void add(@NonNull String[] strings){
        for(String string: strings){
            this.list.add(string);
        }
        this.notifyDataSetChanged();
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fragment fragment = this.fragment;
        View itemView = this.fragment.getLayoutInflater().inflate(R.layout.list_menu, null);
        TextView tv = itemView.findViewById(R.id.lst_menu);
        tv.setText(this.list.get(position));

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("index", String.valueOf(position));
                Bundle result = new Bundle();
                result.putInt("page", position);
                fragment.getParentFragmentManager().setFragmentResult("changePage", result);
            }
        });
        return itemView;
    }

}
