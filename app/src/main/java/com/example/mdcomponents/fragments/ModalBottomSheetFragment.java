package com.example.mdcomponents.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentModalBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;


public class ModalBottomSheetFragment extends BottomSheetDialogFragment implements
        NavigationView.OnNavigationItemSelectedListener {

    FragmentModalBottomSheetBinding binding;

    public static final String TAG = "Modal Bottom Sheet";

    public ModalBottomSheetFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentModalBottomSheetBinding.inflate(inflater, container, false);

        binding.nmdBottom.setNavigationItemSelectedListener(this);

        return binding.getRoot();

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
       switch (menuItem.getItemId()){
           case R.id.action_full_screen_dialog: //sera que on me deja acceder a lso IDs ?
               FullScreenDialogFragment fragment = new FullScreenDialogFragment();
               fragment.show(getChildFragmentManager().beginTransaction(), FullScreenDialogFragment.TAG);
               break;
           case R.id.action_cancel:
               break;
           default:
               String msg = menuItem.getTitle().toString();
               Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
               break;

       }
       dismiss();
       
        return true;
    }
}
