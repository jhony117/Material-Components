package com.example.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mdcomponents.R;
import com.example.mdcomponents.databinding.FragmentSnackBarBinding;
import com.example.mdcomponents.utils.Component;
import com.example.mdcomponents.utils.Constants;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SnackBarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SnackBarFragment extends Fragment {


    FragmentSnackBarBinding binding ;
    public static final String TAG = "Snackbar";
    private static Component mInstance;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_singleline_action);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SnackBarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SnackBarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SnackBarFragment newInstance(String param1, String param2) {
        SnackBarFragment fragment = new SnackBarFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_snack_bar, container, false);

        binding = FragmentSnackBarBinding.inflate(inflater, container, false);

        Snackbar.make(binding.containerMain, R.string.message_action_success, Snackbar.LENGTH_LONG)
                .setAction("Volver", view1 -> getActivity().finish() )
                .show();

        return  binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}