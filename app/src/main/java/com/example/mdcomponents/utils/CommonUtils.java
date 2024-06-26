package com.example.mdcomponents.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mdcomponents.fragments.AlertDialogFragment;
import com.example.mdcomponents.fragments.AppBarFragment;
import com.example.mdcomponents.fragments.BottomNavigationBarFragment;
import com.example.mdcomponents.fragments.ButtonFragment;
import com.example.mdcomponents.fragments.CardFragment;
import com.example.mdcomponents.fragments.CheckboxFragment;
import com.example.mdcomponents.fragments.FloatingActionButtonFragment;
import com.example.mdcomponents.fragments.MenuFragment;
import com.example.mdcomponents.fragments.MotionFragment;
import com.example.mdcomponents.fragments.NavigationDrawerFragment;
import com.example.mdcomponents.fragments.PickerFragment;
import com.example.mdcomponents.fragments.SheetsBottomFragment;
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
            case CheckboxFragment.TAG:
                fragment = new CheckboxFragment();
                break;
            case CardFragment.TAG:
                fragment = new CardFragment();
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
            case MenuFragment.TAG:
                fragment = new MenuFragment();
                break;
                case AlertDialogFragment.TAG:
                fragment = new AlertDialogFragment();
                break;
            case AppBarFragment.TAG:
                fragment = new AppBarFragment();
                break;
            case PickerFragment.TAG:
                fragment = new PickerFragment();
                break;
            case NavigationDrawerFragment.TAG:
                fragment =  new NavigationDrawerFragment();
                break;
            case SheetsBottomFragment.TAG:
                fragment =  new SheetsBottomFragment();
                break;
            case MotionFragment.TAG:
                fragment =  new MotionFragment();
                break;
        }
        return  fragment;
    }
}
