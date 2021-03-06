package com.example.tugasbesar.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

import com.example.tugasbesar.R;
import com.example.tugasbesar.adapter.MenuAdapter;

public class SideBar extends Fragment {
    com.example.tugasbesar.adapter.MenuAdapter adapter;
    ListView lv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.sidebar, container, false);

        String[] menu = {"Home", "Pesan", "History"};

        this.adapter = new MenuAdapter(this);
        this.adapter.add(menu);

        this.lv = view.findViewById(R.id.list_menu);
        this.lv.setAdapter(this.adapter);

        return view;
    }
}
