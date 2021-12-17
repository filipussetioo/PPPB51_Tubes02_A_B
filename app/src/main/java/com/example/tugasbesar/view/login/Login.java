package com.example.tugasbesar.view.login;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.tugasbesar.databinding.LoginBinding;

public class Login extends Fragment implements View.OnClickListener {
    LoginBinding binding;

    public static Login newInstance(){
        Login fragment = new Login();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.binding = LoginBinding.inflate(inflater, container, false);
        this.binding.btnLogin.setOnClickListener(this);
        return this.binding.getRoot();
    }

    @Override
    public void onClick(View v) {
        Log.d("debug", "clicked!");
        if (v == this.binding.btnLogin) {
            Bundle result = new Bundle();
            result.putInt("page", 1);
            this.getParentFragmentManager().setFragmentResult("changePage", result);
        }
    }
}

