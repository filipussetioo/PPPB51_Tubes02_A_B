package com.example.tugasbesar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.tugasbesar.databinding.HomeBinding;

public class Home extends Fragment implements View.OnClickListener{
    HomeBinding binding;

    public static Home newInstance(){
        Home fragment = new Home();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.binding = HomeBinding.inflate(inflater, container, false);
        this.binding.btnPesanSekarang.setOnClickListener(this);
        return this.binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        Log.d("debug", "clicked!");
        if (v == this.binding.btnPesanSekarang) {
            Bundle result = new Bundle();
            result.putInt("page", 3);
            this.getParentFragmentManager().setFragmentResult("changePage", result);
        }
    }
}
