package com.example.tugasbesar.view.order;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.tugasbesar.databinding.OrderBinding;


public class Order extends Fragment implements View.OnClickListener{
    OrderBinding binding;

    public static Order newInstance(){
        Order fragment = new Order();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.binding = OrderBinding.inflate(inflater, container, false);
        this.binding.btnCari.setOnClickListener(this);
        return this.binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        Log.d("debug", "clicked!");
        if (v == this.binding.btnCari) {
            Bundle result = new Bundle();
            result.putInt("page", 4);
            this.getParentFragmentManager().setFragmentResult("changePage", result);
        }
    }
}
