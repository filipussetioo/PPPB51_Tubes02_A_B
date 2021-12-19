package com.example.tugasbesar.view.seat;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.tugasbesar.databinding.SeatBinding;

public class Seat extends Fragment implements View.OnClickListener{
    SeatBinding binding;

    public static Seat newInstance(){
        Seat fragment = new Seat();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.binding = SeatBinding.inflate(inflater, container, false);
        this.binding.btnLanjut.setOnClickListener(this);
        return this.binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        Log.d("debug", "clicked!");
        if (v == this.binding.btnLanjut) {
            Bundle result = new Bundle();
            result.putInt("page", 5);
            this.getParentFragmentManager().setFragmentResult("changePage", result);
        }
    }
}
