package com.example.mdcomponents.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.BottomSheetBinding;
import com.example.mdcomponents.databinding.FragmentSheetsBottomBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;


public class SheetsBottomFragment extends Fragment {

    private boolean mIsExpanded ;

    FragmentSheetsBottomBinding binding ;
    BottomSheetBinding bottomSheetBinding;

    private BottomSheetBehavior mBottomSheetBehavior;


    public static final String TAG = "Sheets Bottom";
    private static Component mInstance;
    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_sheets_bottom);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public SheetsBottomFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
   binding = FragmentSheetsBottomBinding.inflate( inflater, container, false);

   mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheetBinding.bottomSheet);
    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    //es como un listenr del estado del elemento
mBottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
    @Override
    public void onStateChanged(@NonNull View view, int newState) {
      switch (newState){
          case BottomSheetBehavior.STATE_COLLAPSED:
              mIsExpanded = false;
              bottomSheetBinding.btnResize.setImageDrawable(ContextCompat.getDrawable(getActivity(),
                      R.drawable.ic_expand_less));
              break;
          case BottomSheetBehavior.STATE_EXPANDED:
              mIsExpanded = true;
              bottomSheetBinding.btnResize.setImageDrawable(ContextCompat.getDrawable(getActivity(),
                      R.drawable.ic_expand_more));
              break;

      }
    }

    @Override
    public void onSlide(@NonNull View view, float v) {

    }
});
    binding.btnStandar.setOnLongClickListener(v ->
                 {mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
                 return true;});

   return  binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.btnStandar.setOnClickListener(v -> {
            if(mBottomSheetBehavior.getState() ==  BottomSheetBehavior.STATE_HIDDEN){
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            } else {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        bottomSheetBinding.btnResize.setOnClickListener(v -> {
            if(mIsExpanded){
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            } else {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }

        });
        binding.btnModal.setOnClickListener(v -> {
            ModalBottomSheetFullScreenFragment fragment = new ModalBottomSheetFullScreenFragment();
            fragment.show(getParentFragmentManager().beginTransaction(), ModalBottomSheetFullScreenFragment.TAG);
        });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}