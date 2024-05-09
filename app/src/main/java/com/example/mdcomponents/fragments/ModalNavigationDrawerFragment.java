package com.example.mdcomponents.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentModalNavigationDrawerBinding;
import com.google.android.material.navigation.NavigationView;


public class ModalNavigationDrawerFragment extends DialogFragment implements NavigationView.OnNavigationItemSelectedListener{

    public static  final String TAG = "Modal Navigation Drawer Fragment";



    FragmentModalNavigationDrawerBinding binding;

    public ModalNavigationDrawerFragment() {
        // Required empty public constructor
    }

     // TODO: Rename and change types and number of parameters


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialog);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentModalNavigationDrawerBinding.inflate(inflater, container, false);

        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), binding.drawerLayout, binding.toolbar,
                R.string.dialog_ok,R.string.dialog_cancel );
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        binding.nmd.setNavigationItemSelectedListener(this);

  return binding.getRoot();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.action_cancel:
              //  binding.drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.action_app_bar_bottom:
                AppBarBottomFragment bottomFragment = new AppBarBottomFragment();
                bottomFragment.show(getChildFragmentManager().beginTransaction(), AppBarBottomFragment.TAG);
                break;
            default:
                String msg = menuItem.getTitle().toString();
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


}