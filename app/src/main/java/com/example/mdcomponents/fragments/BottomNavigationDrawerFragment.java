package com.example.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentAppBarBottomBinding;
import com.example.mdcomponents.databinding.FragmentBottomNavigationDrawerBinding;
import com.example.mdcomponents.utils.BottomAppBarCutCornersTopEdge;
import com.google.android.material.shape.MaterialShapeDrawable;


public class BottomNavigationDrawerFragment extends DialogFragment {

        FragmentBottomNavigationDrawerBinding binding ;

        FragmentAppBarBottomBinding AppBarBinding ;

        public static  final String  TAG = "Bottom Navigation Drawer";

    public BottomNavigationDrawerFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     binding = FragmentBottomNavigationDrawerBinding.inflate( inflater, container, false);
     //AppBarBinding = FragmentAppBarBottomBinding.inflate(inflater, container, false);
   // es nesesario inflarlo si es que si propio view o java se ejecuta cuando un include de xml  ,  no es asi ?
        AppBarBinding.bottomAppBar.setOnClickListener(v -> {
ModalBottomSheetFragment fragment = new ModalBottomSheetFragment();
fragment.show(getChildFragmentManager().beginTransaction(), ModalBottomSheetFragment.TAG);
         
     });

        BottomAppBarCutCornersTopEdge topEdge = new BottomAppBarCutCornersTopEdge(
                AppBarBinding.bottomAppBar.getFabCradleMargin(),
                AppBarBinding.bottomAppBar.getFabCradleRoundedCornerRadius(),
                AppBarBinding.bottomAppBar.getCradleVerticalOffset()
        );

        MaterialShapeDrawable shapeDrawable = (MaterialShapeDrawable)binding.bottomAppBar.getBackground();
        shapeDrawable.setShapeAppearanceModel(
                shapeDrawable.getShapeAppearanceModel()
                        .toBuilder()
                        .setTopEdge(topEdge)
                        .build());
     return  binding.getRoot();

     }

    @Override
    public void onDestroy() {
        super.onDestroy();

        binding = null;
    }
}