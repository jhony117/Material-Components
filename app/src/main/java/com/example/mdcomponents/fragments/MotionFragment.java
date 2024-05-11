package com.example.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.TransitionManager;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentMotionBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;
import com.google.android.material.transition.MaterialContainerTransform;


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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialContainerTransform trasform = new MaterialContainerTransform();
        trasform.setDuration(2500L);

        binding.btnCancel.setOnClickListener(v -> {

        });
        binding.viewStart.setOnClickListener(v -> {
            trasform.setStartView(binding.viewStart);
            trasform.setEndView(binding.viewEnd);
            trasform.addTarget(binding.viewEnd);

            TransitionManager.beginDelayedTransition(binding.containerMain, trasform);
            binding.viewStart.setVisibility(View.GONE);
            binding.viewEnd.setVisibility(View.VISIBLE);
        });


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