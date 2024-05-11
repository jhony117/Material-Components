package com.example.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentMotionBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;


public class MotionFragment extends Fragment {

    FragmentMotionBinding binding;


    public static final String TAG = "Motion";
    private static Component mInstance;
    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_motion);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }


    public MotionFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
binding = FragmentMotionBinding.inflate(inflater, container, false);
return  binding.getRoot();

    }
}