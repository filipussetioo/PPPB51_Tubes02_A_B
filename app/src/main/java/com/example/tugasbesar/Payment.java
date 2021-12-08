package com.example.tugasbesar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import com.example.tugasbesar.databinding.PaymentBinding;

public class Payment extends Fragment implements View.OnClickListener{
    PaymentBinding binding;

    public static Payment newInstance(){
        Payment fragment = new Payment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.binding = PaymentBinding.inflate(inflater, container, false);
        this.binding.btnPesan.setOnClickListener(this);
        return this.binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        Log.d("debug", "clicked!");
        if (v == this.binding.btnPesan) {
            Bundle result = new Bundle();
            result.putInt("page", 6);
            this.getParentFragmentManager().setFragmentResult("changePage", result);
        }
    }
}
