package com.example.mdcomponents.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mdcomponents.fragments.BottomNavigationBarFragment;
import com.example.mdcomponents.fragments.ButtonFragment;
import com.example.mdcomponents.fragments.FloatingActionButtonFragment;
import com.example.mdcomponents.fragments.SnackBarFragment;
import com.example.mdcomponents.fragments.TextFieldFragment;

public class CommonUtils {

    public static void setFragment(AppCompatActivity activity, String nameFragment, int contentRes){
        Fragment fragment = getFragmentById(nameFragment);
        activity.getSupportFragmentManager().beginTransaction()
                .add(contentRes, fragment)
                .commit();
    }

    private static Fragment getFragmentById(String nameFragment) {
        Fragment fragment = null;

        switch (nameFragment) {
            //SCROLL
            case ButtonFragment.TAG:
                 fragment = new ButtonFragment();
                 break;
            case TextFieldFragment.TAG:
                fragment = new TextFieldFragment();
                break;

            //STATIC
            case BottomNavigationBarFragment.TAG:
                fragment = new BottomNavigationBarFragment();
                break;
            case SnackBarFragment.TAG:
                fragment = new SnackBarFragment();
                break;
            case FloatingActionButtonFragment.TAG:
                fragment = new FloatingActionButtonFragment();
                break;
        }
        return  fragment;
    }
}
