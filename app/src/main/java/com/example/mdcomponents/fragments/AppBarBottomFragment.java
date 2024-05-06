package com.example.mdcomponents.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentAppBarBottomBinding;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppBarBottomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppBarBottomFragment extends DialogFragment {

    private boolean isCentered;

    public static final String TAG = "AppBarBottomFragment";

    FragmentAppBarBottomBinding binding;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AppBarBottomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AppBarBottomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AppBarBottomFragment newInstance(String param1, String param2) {
        AppBarBottomFragment fragment = new AppBarBottomFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAppBarBottomBinding.inflate(inflater, container, false);

    return binding.getRoot();



     }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Infla el menú; esto agrega elementos a la barra de acciones si está presente.
        inflater.inflate(R.menu.menu_bottom_nav, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    //tremenda forma mas rara y sin uso jaja
        //fiajte en como le hc¿iciste en la otra inflacion del menu
            //y si puedes hazlo de uan forma no depracaded
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int resMessage = 0;

               if (item.getItemId() == R.id.action_start) {
                   resMessage = R.string.menu_favorites;
            return true;
        }
        if (item.getItemId() == R.id.action_favorites) {
            resMessage = R.string.menu_favorites;
            return true;
        }
        if (item.getItemId() == R.id.action_profile) {
            resMessage = R.string.menu_profile;
            return true;
        }
        
        Snackbar.make(binding.containerMain , resMessage, Snackbar.LENGTH_LONG)
                .setAnchorView(binding.fab)
                .show();


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.fab.setOnClickListener(v -> {
            if(isCentered){
                binding.bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
            }else {
                binding.bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
            }
            isCentered = !isCentered;
        });

        //setOnMenuItemClickListener(); / esto me podira servir

        binding.bottomAppBar.setNavigationOnClickListener(v -> {
            Snackbar.make(binding.containerMain, R.string.message_action_success, Snackbar.LENGTH_LONG)
                    .setAnchorView(binding.fab)
                    .show();
        });

//        binding.bottomAppBar.setOnMenuItemClickListener(item -> {
//            switch (item.getItemId()){
//                case R.id.action_favorites:
//                    break;
//                case R.id.action_start:
//                    break;
//                case R.id.action_profile:
//                    break;
//
//            }
//        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}