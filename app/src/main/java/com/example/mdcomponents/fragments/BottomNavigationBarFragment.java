package com.example.mdcomponents.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentButtonBinding;
import com.example.mdcomponents.databinding.FragmentButtonNavigationBarBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BottomNavigationBarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottomNavigationBarFragment extends Fragment {


    public static final String TAG = "Bottom Navigation";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

     FragmentButtonNavigationBarBinding binding;



    private static Component mInstance;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BottomNavigationBarFragment() {
        // Required empty public constructor
    }

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_bottomnav_mobile_portrait);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ButtonNavigationBarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BottomNavigationBarFragment newInstance(String param1, String param2) {
        BottomNavigationBarFragment fragment = new BottomNavigationBarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_button_navigation_bar, container, false);

        // Inflate the layout for this fragment with view binding
        binding = FragmentButtonNavigationBarBinding.inflate(inflater, container, false);


        return binding.getRoot();

    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtén la referencia a tu BottomNavigationView
        BottomNavigationView bottomNavigationView = binding.bottomNavigation;

        // Infla el menú
        MenuInflater inflater = requireActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_bottom_nav, bottomNavigationView.getMenu());


        // Obtiene el elemento del menú por su ID
        MenuItem actionStart = bottomNavigationView.getMenu().findItem(R.id.action_start);

      bottomNavigationView.getOrCreateBadge(R.id.action_start);
      // bottomNavigationView.removeBadge(R.id.action_start);

        BadgeDrawable favoriteBadge = bottomNavigationView.getOrCreateBadge(R.id.action_favorites);
        favoriteBadge.setNumber(21);

        BadgeDrawable profileBadge = bottomNavigationView.getOrCreateBadge(R.id.action_profile);
        profileBadge.setNumber(1000); // 999+ default / 4 caracteres
        profileBadge.setMaxCharacterCount(3);
        profileBadge.setBackgroundColor(Color.CYAN);
        profileBadge.setBadgeTextColor(Color.MAGENTA);


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

