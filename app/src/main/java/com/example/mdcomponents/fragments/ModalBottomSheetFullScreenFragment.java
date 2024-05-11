package com.example.mdcomponents.fragments;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentModalBottomSheetFullScreenBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class ModalBottomSheetFullScreenFragment extends BottomSheetDialogFragment {

    public static final String TAG = "Modal BottomSheet FullScreen";

    private BottomSheetBehavior mBottomSheetBehavior;


    FragmentModalBottomSheetFullScreenBinding binding;//= FragmentModalBottomSheetFullScreenBinding.inflate(getLayoutInflater());

    public ModalBottomSheetFullScreenFragment() {
        // Required empty public constructor
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

       // View view = fragmentModalBottomSheetFullScreenBinding.containerMain;

        bottomSheetDialog.setContentView(binding.containerMain);

        binding.vExtraSpace.setMinimumHeight((Resources.getSystem().getDisplayMetrics().heightPixels) / 4);


        mBottomSheetBehavior = BottomSheetBehavior.from((View)
                binding.containerMain.getParent());

        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
        mBottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int newState) {

                int statusBarColor = ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark);

                if(BottomSheetBehavior.STATE_EXPANDED == newState){
                    binding.appBar.setVisibility(View.VISIBLE);
                 //   binding.llBar.setVisibility(View.GONE);
                    binding.tvBar.setVisibility(View.GONE);
                    statusBarColor = ContextCompat.getColor(getActivity(), R.color.colorAccent);
                }else if(BottomSheetBehavior.STATE_COLLAPSED == newState){
                    binding.appBar.setVisibility(View.GONE);
                    //binding.llBar.setVisibility(View.VISIBLE);
                    binding.tvBar.setVisibility(View.VISIBLE);
                }
                getActivity().getWindow().setStatusBarColor(statusBarColor);
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });

        binding.btnCancel.setOnClickListener(v -> mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN));
        return bottomSheetDialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentModalBottomSheetFullScreenBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}