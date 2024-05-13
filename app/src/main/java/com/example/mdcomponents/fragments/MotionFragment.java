package com.example.mdcomponents.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.transition.TransitionManager;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentButtonBinding;
import com.example.mdcomponents.databinding.FragmentMotionBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;
import com.google.android.material.transition.MaterialArcMotion;
import com.google.android.material.transition.MaterialContainerTransform;
import com.google.android.material.transition.MaterialSharedAxis;


public class MotionFragment extends Fragment {

    FragmentMotionBinding binding;
   // FragmentButtonBinding binding1;


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

        binding.btnCustom.setText(R.string.motion_button_next);


      //fab a fragment
        MaterialContainerTransform transform = new MaterialContainerTransform();
        transform.setDuration(500L);
        transform.setScrimColor(Color.TRANSPARENT);

        binding.btnCancel.setOnClickListener(v -> {
            transform.setStartView(binding.viewEnd);
            transform.setEndView(binding.viewStart);
            transform.addTarget(binding.viewStart);

            TransitionManager.beginDelayedTransition(binding.containerMain, transform);
            binding.viewEnd.setVisibility(View.GONE);
            binding.viewStart.setVisibility(View.VISIBLE);

        });
        binding.viewStart.setOnClickListener(v -> {
            transform.setPathMotion(new MaterialArcMotion());
            transform.setStartView(binding.viewStart);
            transform.setEndView(binding.viewEnd);
            transform.addTarget(binding.viewEnd);

            TransitionManager.beginDelayedTransition(binding.containerMain, transform);
            binding.viewStart.setVisibility(View.GONE);
            binding.viewEnd.setVisibility(View.VISIBLE);
        });

        //se supone que se arreglaria en ejecuacion o algo asi
//tambien se supone que un include a el xml pasa todas sus views osea que el binding tambien puede usarlas
        binding.btnCustom.setOnClickListener(v -> {
            MaterialSharedAxis sharedAxis = new MaterialSharedAxis(MaterialSharedAxis.X, true);
            sharedAxis.setDuration(1500L);

            TransitionManager.beginDelayedTransition(binding.viewEnd, sharedAxis);

            binding.viewOut.setVisibility(View.GONE);
            binding.viewIn.setVisibility(View.VISIBLE);
        });

        binding.btnBack.setOnClickListener(v -> {
            MaterialSharedAxis sharedAxis = new MaterialSharedAxis(MaterialSharedAxis.X, false);
            sharedAxis.setDuration(1500L);
            TransitionManager.beginDelayedTransition(binding.viewEnd, sharedAxis);

            binding.viewIn.setVisibility(View.GONE);
            binding.viewOut.setVisibility(View.VISIBLE);
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