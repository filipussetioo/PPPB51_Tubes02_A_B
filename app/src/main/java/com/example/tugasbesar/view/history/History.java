package com.example.tugasbesar.view.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.tugasbesar.databinding.HistoryBinding;

public class History extends Fragment{
    HistoryBinding binding;

    public static History newInstance(){
        History fragment = new History();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.binding = HistoryBinding.inflate(inflater, container, false);
        return this.binding.getRoot();
    }
}
